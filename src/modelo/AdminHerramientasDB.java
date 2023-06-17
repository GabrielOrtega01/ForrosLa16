package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminHerramientasDB extends Conexion implements CRUD {

    public AdminHerramientasDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Herramientas objHerramientas = (Herramientas) obj;
        try {
            String sql = "INSERT INTO Herramientas (nombre_h) VALUES(?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objHerramientas.getNombre_h());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objHerramientas.setIdh(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la herramienta fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar las herramientas: " + e.getMessage());
        }
        cerrarConexion();
        return objHerramientas;
    }

    @Override
    public boolean actualizar(Object obj) {
        Herramientas objHerramientas = (Herramientas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {

            String sql = "UPDATE Herramientas SET nombre_h=? WHERE idh=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objHerramientas.getNombre_h());
            preparedStatement.setInt(2, objHerramientas.getIdh());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la herramienta: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Herramientas objHerramientas = (Herramientas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Herramientas WHERE idh=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objHerramientas.getIdh());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la herramienta: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Herramientas objHerramientas;
        try {

            String sql = "SELECT * FROM Herramientas ORDER BY idh ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objHerramientas = new Herramientas();
                objHerramientas.setIdh(resultSet.getInt("idh"));
                objHerramientas.setNombre_h(resultSet.getString("nombre_h"));
                rowsQuery.add(objHerramientas);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las herramientas: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Herramientas objHerramientas = (Herramientas) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM Herramientas WHERE idh = ? ORDER BY idh ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objHerramientas.getIdh());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objHerramientas = new Herramientas();
                objHerramientas.setIdh(resultSet.getInt("idh"));
                objHerramientas.setNombre_h(resultSet.getString("nombre_h"));
                flag = true;
            }
            if (!flag) {
                objHerramientas.setIdh(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la herramienta: " + e.getMessage());
        }
        cerrarConexion();
        return objHerramientas;
    }
}
