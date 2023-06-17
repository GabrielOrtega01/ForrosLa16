package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiciosDB extends Conexion implements CRUD {

    public AdminServiciosDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Servicios objServicios = (Servicios) obj;
        try {
            String sql = "INSERT INTO Servicios (nombre_s, costo_s) VALUES(?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objServicios.getNombre_s());
            preparedStatement.setInt(2, objServicios.getCosto_s());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objServicios.setIds(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de el servicio fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el servicio: " + e.getMessage());
        }
        cerrarConexion();
        return objServicios;
    }

    @Override
    public boolean actualizar(Object obj) {
        Servicios objServicios = (Servicios) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {

            String sql = "UPDATE Servicios SET nombre_s=?, costo_s=? WHERE ids=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objServicios.getNombre_s());
            preparedStatement.setInt(2, objServicios.getCosto_s());
            preparedStatement.setInt(3, objServicios.getIds());
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
        Servicios objServicios = (Servicios) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Servicios WHERE ids=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objServicios.getIds());
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
        Servicios objServicios;
        try {

            String sql = "SELECT * FROM Servicios ORDER BY ids ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objServicios = new Servicios();
                objServicios.setIds(resultSet.getInt("ids"));
                objServicios.setNombre_s(resultSet.getString("nombre_s"));
                objServicios.setCosto_s(resultSet.getInt("costo_s"));
                rowsQuery.add(objServicios);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las servicios: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Servicios objServicios = (Servicios) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM Servicios WHERE ids = ? ORDER BY ids ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objServicios.getIds());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objServicios = new Servicios();
                objServicios.setIds(resultSet.getInt("ids"));
                objServicios.setNombre_s(resultSet.getString("nombre_s"));
                objServicios.setCosto_s(resultSet.getInt("costo_s"));
                flag = true;
            }
            if (!flag) {
                objServicios.setIds(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el servicio: " + e.getMessage());
        }
        cerrarConexion();
        return objServicios;
    }
}
