package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminClientesDB extends Conexion implements CRUD {

    public AdminClientesDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Clientes objClientes = (Clientes) obj;
        try {
            String sql = "INSERT INTO clientes (nombre_c, apellido_c, cc_c, direccion_c) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objClientes.getNombre_c());
            preparedStatement.setString(2, objClientes.getApellido_c());
            preparedStatement.setString(3, objClientes.getCc_c());
            preparedStatement.setString(4, objClientes.getDireccion_c());

             preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objClientes.setIdc(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del articulo fue exitoso. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar el articulo: " + e.getMessage());

        }
        cerrarConexion();
        return objClientes;
    }
    

    @Override
    public boolean actualizar(Object obj) {
        Clientes objClientes = (Clientes) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {

            String sql = "UPDATE Clientes SET nombre_c=?, apellido_c=?, cc_c=?, direccion_c=? WHERE idc=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objClientes.getNombre_c());
            preparedStatement.setString(2, objClientes.getApellido_c());
            preparedStatement.setString(3, objClientes.getCc_c());
            preparedStatement.setString(4, objClientes.getDireccion_c());
            preparedStatement.setInt(5, objClientes.getIdc());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el servicio: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Clientes objClientes = (Clientes) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Clientes WHERE idc=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objClientes.getIdc());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el servicio: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Clientes objClientes;
        try {

            String sql = "SELECT * FROM Clientes ORDER BY idc ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objClientes = new Clientes();
                objClientes.setIdc(resultSet.getInt("idc"));
                objClientes.setNombre_c(resultSet.getString("nombre_c"));
                objClientes.setApellido_c(resultSet.getString("apellido_c"));
                objClientes.setCc_c(resultSet.getString("cc_c"));
                objClientes.setDireccion_c(resultSet.getString("direccion_c"));

                rowsQuery.add(objClientes);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las clientes: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Clientes objClientes = (Clientes) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM Clientes WHERE idc = ? ORDER BY idc ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objClientes.getIdc());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objClientes = new Clientes();
                objClientes.setIdc(resultSet.getInt("idc"));
                objClientes.setNombre_c(resultSet.getString("nombre_c"));
                objClientes.setApellido_c(resultSet.getString("apellido_c"));
                objClientes.setCc_c(resultSet.getString("cc_c"));
                objClientes.setDireccion_c(resultSet.getString("direccion_c"));
                flag = true;
            }
            if (!flag) {
                objClientes.setIdc(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la cita pendiente: " + e.getMessage());
        }
        cerrarConexion();
        return objClientes;
    }
}
