package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminProveedoresDB extends Conexion implements CRUD {

    public AdminProveedoresDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Proveedores objProveedores = (Proveedores) obj;
        try {
            String sql = "INSERT INTO Proveedores (nombre_prov) VALUES(?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objProveedores.getNombre_prov());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objProveedores.setIdprov(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del proveedor fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el proveedor: " + e.getMessage());
        }
        cerrarConexion();
        return objProveedores;
    }

    @Override
    public boolean actualizar(Object obj) {
        Proveedores objProveedores = (Proveedores) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE Proveedores SET nombre_prov=? WHERE idprov=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objProveedores.getNombre_prov());
            preparedStatement.setInt(2, objProveedores.getIdprov());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el proveedor: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Proveedores objProveedores = (Proveedores) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Proveedores WHERE idprov=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProveedores.getIdprov());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el proveedor: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Proveedores objProveedores;
        try {
            String sql = "SELECT * FROM Proveedores ORDER BY idprov ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProveedores = new Proveedores();
                objProveedores.setIdprov(resultSet.getInt("idprov"));
                objProveedores.setNombre_prov(resultSet.getString("nombre_prov"));
                rowsQuery.add(objProveedores);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de los proveedores: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Proveedores objProveedores = (Proveedores) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM Proveedores WHERE idprov = ? ORDER BY idprov ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProveedores.getIdprov());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProveedores = new Proveedores();
                objProveedores.setIdprov(resultSet.getInt("idprov"));
                objProveedores.setNombre_prov(resultSet.getString("nombre_prov"));
                flag = true;
            }
            if (!flag) {
                objProveedores.setIdprov(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la proveedore: " + e.getMessage());
        }
        cerrarConexion();
        return objProveedores;
    }
}
