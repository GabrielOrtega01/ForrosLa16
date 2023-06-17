package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMovimientoDB extends Conexion implements CRUD {

    public AdminMovimientoDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Movimiento objMovimiento = (Movimiento) obj;
        try {
            String sql = "INSERT INTO movimiento (cantidad_producto, servicios_ids, empleados_ide, vehiculo_idv, productos_idprod) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objMovimiento.getCantidad_producto());
            preparedStatement.setInt(2, objMovimiento.getServicios_ids());
            preparedStatement.setInt(3, objMovimiento.getEmpleados_ide());
            preparedStatement.setInt(4, objMovimiento.getVehiculo_idv());
            preparedStatement.setInt(5, objMovimiento.getProductos_idprod());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                objMovimiento.setIdmov(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del movimiento fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar los movimientos: " + e.getMessage());
        }
        cerrarConexion();
        return objMovimiento;
    }

    @Override
    public boolean actualizar(Object obj) {
        Movimiento objMovimiento = (Movimiento) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE movimiento SET cantidad_producto=?, servicios_ids=?, empleados_ide=?, vehiculo_idv=?, productos_idprod=? WHERE idmov=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMovimiento.getCantidad_producto());
            preparedStatement.setInt(2, objMovimiento.getServicios_ids());
            preparedStatement.setInt(3, objMovimiento.getEmpleados_ide());
            preparedStatement.setInt(4, objMovimiento.getVehiculo_idv());
            preparedStatement.setInt(5, objMovimiento.getProductos_idprod());
            preparedStatement.setInt(6, objMovimiento.getIdmov());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el movimiento: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Movimiento objMovimiento = (Movimiento) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM movimiento WHERE idmov=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMovimiento.getIdmov());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el movimiento: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Movimiento objMovimiento;
        try {
            String sql = "SELECT * FROM movimiento ORDER BY idmov ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMovimiento = new Movimiento();
                objMovimiento.setIdmov(resultSet.getInt("idmov"));
                objMovimiento.setCantidad_producto(resultSet.getInt("cantidad_producto"));
                objMovimiento.setServicios_ids(resultSet.getInt("servicios_ids"));
                objMovimiento.setEmpleados_ide(resultSet.getInt("empleados_ide"));
                objMovimiento.setVehiculo_idv(resultSet.getInt("vehiculo_idv"));
                objMovimiento.setProductos_idprod(resultSet.getInt("productos_idprod"));

                rowsQuery.add(objMovimiento);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de los movimientos: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Movimiento objMovimiento = (Movimiento) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM movimiento WHERE idmov = ? ORDER BY idmov ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMovimiento.getIdmov());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMovimiento = new Movimiento();
                objMovimiento.setIdmov(resultSet.getInt("idmov"));
                objMovimiento.setCantidad_producto(resultSet.getInt("cantidad_producto"));
                objMovimiento.setServicios_ids(resultSet.getInt("servicios_ids"));
                objMovimiento.setEmpleados_ide(resultSet.getInt("empleados_ide"));
                objMovimiento.setVehiculo_idv(resultSet.getInt("vehiculo_idv"));
                objMovimiento.setProductos_idprod(resultSet.getInt("productos_idprod"));
                flag = true;
            }
            if (!flag) {
                objMovimiento.setIdmov(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el movimiento: " + e.getMessage());
        }
        cerrarConexion();
        return objMovimiento;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        MovimientoVista objMovimiento;
        try {
            String sql = "Select idmov, cantidad_producto, nombre_s as servicio, concat(nombre_e,' ',apellido_e) as empleado,\n"
                        + "placa_v as vehiculo, nombre_prod as producto from movimiento as m  inner join servicios as s\n"
                        + "on m.servicios_ids = s.ids inner join empleados as e on m.empleados_ide = e.ide inner join\n"
                        + "vehiculo as v on m.vehiculo_idv = v.idv inner join productos as prod on \n"
                        + "m.productos_idprod = prod.idprod ORDER BY idmov ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMovimiento = new MovimientoVista();
                objMovimiento.setIdmov(resultSet.getInt("idmov"));
                objMovimiento.setCantidad_producto(resultSet.getInt("cantidad_producto"));
                objMovimiento.setServicio(resultSet.getString("servicio"));
                objMovimiento.setEmpleado(resultSet.getString("empleado"));
                objMovimiento.setVehiculo(resultSet.getString("vehiculo"));
                objMovimiento.setProducto(resultSet.getString("producto"));

                rowsQuery.add(objMovimiento);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de los movimientos: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
