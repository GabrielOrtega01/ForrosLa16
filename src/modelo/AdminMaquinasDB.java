package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMaquinasDB extends Conexion implements CRUD {

    public AdminMaquinasDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Maquinas objMaquinas = (Maquinas) obj;
        try {

            String sql = "INSERT INTO Maquinas (nombre_m, referencia_m) VALUES(?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objMaquinas.getNombre_m());
            preparedStatement.setString(2, objMaquinas.getReferencia_m());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objMaquinas.setIdm(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la maquina fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el maquina: " + e.getMessage());
        }
        cerrarConexion();
        return objMaquinas;
    }

    @Override
    public boolean actualizar(Object obj) {
        Maquinas objMaquinas = (Maquinas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {

            String sql = "UPDATE Maquinas SET nombre_m=?, referencia_m=? WHERE idm=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objMaquinas.getNombre_m());
            preparedStatement.setString(2, objMaquinas.getReferencia_m());
            preparedStatement.setInt(3, objMaquinas.getIdm());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la maquina: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Maquinas objMaquinas = (Maquinas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Maquinas WHERE idm=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMaquinas.getIdm());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la maquina: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Maquinas objMaquinas;
        try {

            String sql = "SELECT * FROM maquinas ORDER BY idm ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMaquinas = new Maquinas();
                objMaquinas.setIdm(resultSet.getInt("idm"));
                objMaquinas.setNombre_m(resultSet.getString("nombre_m"));
                objMaquinas.setReferencia_m(resultSet.getString("referencia_m"));

                rowsQuery.add(objMaquinas);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las maquinas: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Maquinas objMaquinas = (Maquinas) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM maquinas WHERE idm = ? ORDER BY idm ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMaquinas.getIdm());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMaquinas = new Maquinas();
                objMaquinas.setIdm(resultSet.getInt("idm"));
                objMaquinas.setNombre_m(resultSet.getString("nombre_m"));
                objMaquinas.setReferencia_m(resultSet.getString("referencia_m"));
                flag = true;
            }
            if (!flag) {
                objMaquinas.setIdm(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la cita pendiente: " + e.getMessage());
        }
        cerrarConexion();
        return objMaquinas;
    }

}
