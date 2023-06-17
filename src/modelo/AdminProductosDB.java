package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminProductosDB extends Conexion implements CRUD {

    public AdminProductosDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Productos objProductos = (Productos) obj;
        try {
            String sql = "INSERT INTO Productos (nombre_prod) VALUES(?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objProductos.getNombre_prod());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objProductos.setIdprod(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de el producto fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
        cerrarConexion();
        return objProductos;
    }

    @Override
    public boolean actualizar(Object obj) {
        Productos objProductos = (Productos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE Productos SET nombre_prod=? WHERE idprod=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objProductos.getNombre_prod());
            preparedStatement.setInt(2, objProductos.getIdprod());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la producto: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Productos objProductos = (Productos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Productos WHERE idprod=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProductos.getIdprod());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Productos objProductos;
        try {
            /*private int idprod;
    private String nombre_prod;
    private int valor_productos;
    private String medida_productos;
    private int vehiculo_id_vehiculo;
             */
            String sql = "SELECT * FROM Productos ORDER BY idprod ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProductos = new Productos();
                objProductos.setIdprod(resultSet.getInt("idprod"));
                objProductos.setNombre_prod(resultSet.getString("nombre_prod"));
                rowsQuery.add(objProductos);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las productos: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Productos objProductos = (Productos) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM Productos WHERE idprod = ? ORDER BY idprod ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProductos.getIdprod());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProductos = new Productos();
                objProductos.setIdprod(resultSet.getInt("idprod"));
                objProductos.setNombre_prod(resultSet.getString("nombre_prod"));
                flag = true;
            }
            if (!flag) {
                objProductos.setIdprod(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e.getMessage());
        }
        cerrarConexion();
        return objProductos;
    }
}
