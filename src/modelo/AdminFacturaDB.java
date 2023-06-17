package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminFacturaDB extends Conexion implements CRUD {

    public AdminFacturaDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Factura objFactura = (Factura) obj;
        try {
            String sql = "INSERT INTO Factura (admin, fecha_f, movimiento_idmov) VALUES(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objFactura.getAdmin());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objFactura.getFecha_f()));
            preparedStatement.setInt(3, objFactura.getMovimiento_idmov());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objFactura.setIdf(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la venta fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar las ventas: " + e.getMessage());
        }
        cerrarConexion();
        return objFactura;
    }

    @Override
    public boolean actualizar(Object obj) {
        Factura objFactura = (Factura) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE Factura SET admin=?, fecha_f=?, movimiento_idmov=? WHERE idf=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objFactura.getAdmin());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objFactura.getFecha_f()));
            preparedStatement.setInt(3, objFactura.getMovimiento_idmov());
            preparedStatement.setInt(4, objFactura.getIdf());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la venta: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Factura objFactura = (Factura) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Factura WHERE idf=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objFactura.getIdf());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la venta: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Factura objFactura;
        try {

            String sql = "SELECT * FROM Factura ORDER BY idf ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objFactura = new Factura();
                objFactura.setIdf(resultSet.getInt("idf"));
                objFactura.setAdmin(resultSet.getString("admin"));
                objFactura.setFecha_f(resultSet.getDate("fecha_f").toLocalDate());
                objFactura.setMovimiento_idmov(resultSet.getInt("movimiento_idmov"));
                rowsQuery.add(objFactura);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las ventas: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Factura objFactura = (Factura) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM Factura WHERE idf = ? ORDER BY idf ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objFactura.getIdf());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objFactura = new Factura();
                objFactura.setIdf(resultSet.getInt("idf"));
                objFactura.setAdmin(resultSet.getString("admin"));
                objFactura.setFecha_f(resultSet.getDate("fecha_f").toLocalDate());
                objFactura.setMovimiento_idmov(resultSet.getInt("movimiento_idmov"));
                flag = true;
            }
            if (!flag) {
                objFactura.setIdf(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la venta: " + e.getMessage());
        }
        cerrarConexion();
        return objFactura;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        FacturaVista objFactura;
        try {

            String sql = "Select idf, nombre_servicio as servicio, nombre_productos as producto, \n"
                    + "concat(nombre_c,\" \",apellido_c) as cliente, \n"
                    + "concat (nombre_e,\" \",apellido_e) as empleado, fecha_f, movimiento_idmov\n"
                    + "from factura as f  inner join servicios as s\n"
                    + "on s.id_servicio = f.admin inner join \n"
                    + "productos as p on p.id_productos = v.productos_id_productos inner join\n"
                    + "clientes as c on c.id_clientes = v.clientes_id_clientes inner join\n"
                    + "empleados as e on e.id_empleados = v.empleados_id_empleados\n"
                    + "ORDER BY idf ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objFactura = new FacturaVista();
                objFactura.setIdf(resultSet.getInt("idf"));
                objFactura.setServicio(resultSet.getString("servicio"));
                objFactura.setProducto(resultSet.getString("producto"));
                objFactura.setCliente(resultSet.getString("cliente"));
                objFactura.setEmpleado(resultSet.getString("empleado"));
                objFactura.setFecha_f(resultSet.getDate("fecha_f").toLocalDate());
                objFactura.setValor_f(resultSet.getInt("valor_f"));
                rowsQuery.add(objFactura);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las ventas: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
