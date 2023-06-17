package modelo;

import dao.Conexion;
import static dao.Conexion.abrirConexion;
import static dao.Conexion.cerrarConexion;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelacionesDB extends Conexion {

    public RelacionesDB() {
    }

    public List<ReporteFacturaCliente> consultarFacturaCliente(LocalDate fecha, String placa) {
        List<ReporteFacturaCliente> rowsQuery = new ArrayList<ReporteFacturaCliente>();
        Connection conex = abrirConexion();
        ReporteFacturaCliente objFacturaCliente;
        try {
            String sql = "SELECT CONCAT(c.nombre_c, ' ', c.apellido_c) AS cliente, c.cc_c as documento, \n"
                        + "c.direccion_c as direccion, v.placa_v AS vehiculo, v.marca_v AS marca, v.color_v AS color, \n"
                        + "s.nombre_s AS servicio, s.costo_s AS costo_servicio, prod.nombre_prod AS producto, \n"
                        + "cp.valor_cp  as precio_unitario, mov.cantidad_producto as cantidad, cp.iva_cp as iva, \n"
                        + "SUM((cp.valor_cp * mov.cantidad_producto + s.costo_s)*(cp.iva_cp+100)/100) AS total, f.fecha_f as fecha, \n"
                        + "CONCAT(e.nombre_e, ' ', e.apellido_e) AS empleado, f.idf, f.admin \n"
                        + "FROM movimiento AS mov \n"
                        + "INNER JOIN servicios AS s ON mov.servicios_ids = s.ids \n"
                        + "INNER JOIN empleados AS e ON mov.empleados_ide = e.ide \n"
                        + "INNER JOIN vehiculo AS v ON mov.vehiculo_idv = v.idv \n"
                        + "INNER JOIN productos AS prod ON mov.productos_idprod = prod.idprod \n"
                        + "INNER JOIN factura AS f ON mov.idmov = f.movimiento_idmov\n"
                        + "INNER JOIN clientes AS c ON c.idc = v.clientes_idc \n"
                        + "INNER JOIN comprasproductos AS cp ON cp.idcp = prod.idprod where f.fecha_f =? and v.placa_v = ?\n"
                        + "GROUP BY c.nombre_c, c.apellido_c, c.cc_c, c.direccion_c, v.placa_v, v.marca_v, v.color_v, \n"
                        + "s.nombre_s, s.costo_s, cp.valor_cp, prod.nombre_prod, mov.cantidad_producto, cp.iva_cp, \n"
                        + "f.fecha_f, e.nombre_e, e.apellido_e, f.idf, f.admin \n"
                        + "ORDER BY mov.idmov ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fecha));
            preparedStatement.setString(2, placa);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                objFacturaCliente = new ReporteFacturaCliente();

                objFacturaCliente.setCliente(resultSet.getString("cliente"));
                objFacturaCliente.setDocumento(resultSet.getString("documento"));
                objFacturaCliente.setDireccion(resultSet.getString("direccion"));
                objFacturaCliente.setVehiculo(resultSet.getString("vehiculo"));
                objFacturaCliente.setMarca(resultSet.getString("marca"));
                objFacturaCliente.setColor(resultSet.getString("color"));
                objFacturaCliente.setServicio(resultSet.getString("servicio"));
                objFacturaCliente.setCosto_servicio(resultSet.getInt("costo_servicio"));
                objFacturaCliente.setProducto(resultSet.getString("producto"));
                objFacturaCliente.setPrecio_unitario(resultSet.getInt("precio_unitario"));
                objFacturaCliente.setCantidad(resultSet.getInt("cantidad"));
                objFacturaCliente.setIva(resultSet.getFloat("iva"));
                objFacturaCliente.setTotal(resultSet.getBigDecimal("total").setScale(0, RoundingMode.HALF_UP));
                objFacturaCliente.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                objFacturaCliente.setEmpleado(resultSet.getString("empleado"));
                objFacturaCliente.setIdf(resultSet.getInt("idf"));
                objFacturaCliente.setAdmin(resultSet.getString("admin"));

                rowsQuery.add(objFacturaCliente);

            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<ReporteDineroInvertido> consultarDatos2() {
        List<ReporteDineroInvertido> rowsQuery = new ArrayList<ReporteDineroInvertido>();
        Connection conex = abrirConexion();
        ReporteDineroInvertido objReporteDineroInvertido;
        try {
            String sql = "select tabla1.producto, tabla2.maquina, tabla3.herramienta, nombre_prov as proveedor, \n"
                        + "(tabla1.producto+tabla2.maquina+tabla3.herramienta) as total from proveedores as prov\n"
                        + "inner join (\n"
                        + "  SELECT cp.proveedores_idprov, SUM(cp.valor_cp) AS producto\n"
                        + "  FROM comprasproductos AS cp \n"
                        + "  GROUP BY cp.proveedores_idprov\n"
                        + ") AS tabla1 ON prov.idprov = tabla1.proveedores_idprov\n"
                        + "inner join (\n"
                        + "  SELECT cm.proveedores_idprov, SUM(cm.valor_cm) AS maquina\n"
                        + "  FROM comprasmaquinas AS cm \n"
                        + "  GROUP BY cm.proveedores_idprov\n"
                        + ") AS tabla2 ON prov.idprov = tabla2.proveedores_idprov\n"
                        + "inner join (\n"
                        + "  SELECT ch.proveedores_idprov, SUM(ch.valor_ch) AS herramienta\n"
                        + "  FROM comprasherramientas AS ch \n"
                        + "  GROUP BY ch.proveedores_idprov\n"
                        + ") AS tabla3 ON prov.idprov = tabla3.proveedores_idprov\n"
                        + "order by nombre_prov";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objReporteDineroInvertido = new ReporteDineroInvertido();

                objReporteDineroInvertido.setProducto(resultSet.getString("producto"));
                objReporteDineroInvertido.setMaquina(resultSet.getString("maquina"));
                objReporteDineroInvertido.setHerramienta(resultSet.getString("herramienta"));
                objReporteDineroInvertido.setProveedor(resultSet.getString("proveedor"));
                objReporteDineroInvertido.setTotal(resultSet.getInt("total"));
                
                rowsQuery.add(objReporteDineroInvertido);
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<ReporteBalanceProductos> consultarDatos9(LocalDate fechaInicio9, LocalDate fechaFin9, String nombreProd) {
        List<ReporteBalanceProductos> rowsQuery = new ArrayList<ReporteBalanceProductos>();
        Connection conex = abrirConexion();
        ReporteBalanceProductos objListaProductos;
        try {
            String sql = " SELECT tabla1.cantidad_utilizada, prod.nombre_prod as producto, tabla2.cantidad_inicial,\n"
                        + " (tabla2.cantidad_inicial - tabla1.cantidad_utilizada) AS cantidad_actual, cp.fecha_cp as fecha_de_compra, \n"
                        + " f.fecha_f as fecha_factura, concat(e.nombre_e,\" \",e.apellido_e) as empleado_responsable\n"
                        + "FROM productos AS prod\n"
                        + "INNER JOIN (\n"
                        + "  SELECT mov.productos_idprod, SUM(mov.cantidad_producto) AS cantidad_utilizada\n"
                        + "  FROM movimiento AS mov \n"
                        + "  GROUP BY mov.productos_idprod\n"
                        + ") AS tabla1 ON prod.idprod = tabla1.productos_idprod\n"
                        + "INNER JOIN (\n"
                        + "  SELECT cp.productos_idprod, SUM(cp.cantidad_cp) AS cantidad_inicial\n"
                        + "  FROM comprasproductos AS cp\n"
                        + "  GROUP BY cp.productos_idprod\n"
                        + ") AS tabla2 ON prod.idprod = tabla2.productos_idprod\n"
                        + "INNER JOIN movimiento mov ON mov.productos_idprod = prod.idprod \n"
                        + "INNER JOIN factura AS f ON mov.idmov = f.movimiento_idmov\n"
                        + "INNER JOIN empleados AS e ON mov.empleados_ide = e.ide \n"
                        + "INNER JOIN comprasproductos AS cp ON cp.idcp = prod.idprod\n"
                        + "where fecha_f BETWEEN ? AND ? AND nombre_prod = ? \n"
                        + "ORDER BY fecha_f ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaInicio9));
            preparedStatement.setDate(2, java.sql.Date.valueOf(fechaFin9));
            preparedStatement.setString(3, nombreProd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objListaProductos = new ReporteBalanceProductos();

                objListaProductos.setCantidad_utilizada(resultSet.getInt("cantidad_utilizada"));
                objListaProductos.setFecha_de_compra(resultSet.getDate("fecha_de_compra").toLocalDate());
                objListaProductos.setFecha_factura(resultSet.getDate("fecha_factura").toLocalDate());
                objListaProductos.setEmpleado_responsable(resultSet.getString("empleado_responsable"));
                objListaProductos.setCantidad_actual(resultSet.getInt("cantidad_actual"));
                objListaProductos.setCantidad_inicial(resultSet.getInt("cantidad_inicial"));

                rowsQuery.add(objListaProductos);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

}
