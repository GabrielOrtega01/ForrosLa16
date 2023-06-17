package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminUsuarioDB extends Conexion implements CRUD {

    public AdminUsuarioDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Usuario objUsuario = (Usuario) obj;
        try {
            String sql = "INSERT INTO Usuario (clave_u, empleados_ide) VALUES(?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objUsuario.getClave_u());
            preparedStatement.setInt(2, objUsuario.getEmpleados_ide());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objUsuario.setIdu(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del usuario fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar los usuario: " + e.getMessage());
        }
        cerrarConexion();
        return objUsuario;
    }

    @Override
    public boolean actualizar(Object obj) {
        Usuario objUsuario = (Usuario) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE Usuario SET clave_u=?, empleados_ide=? WHERE idu=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objUsuario.getClave_u());
            preparedStatement.setInt(2, objUsuario.getEmpleados_ide());
            preparedStatement.setInt(3, objUsuario.getIdu());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Usuario objUsuario = (Usuario) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Usuario WHERE idu=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objUsuario.getIdu());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la compra: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Usuario objUsuario;
        try {

            String sql = "SELECT * FROM Usuario ORDER BY idu ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objUsuario = new Usuario();
                objUsuario.setIdu(resultSet.getInt("idu"));
                objUsuario.setClave_u(resultSet.getString("clave_u"));
                objUsuario.setEmpleados_ide(resultSet.getInt("empleados_ide"));

                rowsQuery.add(objUsuario);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de los usuario: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Usuario objUsuario = (Usuario) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM Usuario WHERE idu = ? ORDER BY idu ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objUsuario.getIdu());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objUsuario = new Usuario();
                objUsuario.setIdu(resultSet.getInt("idu"));
                objUsuario.setClave_u(resultSet.getString("clave_u"));
                objUsuario.setEmpleados_ide(resultSet.getInt("empleados_ide"));
            }
            if (!flag) {
                objUsuario.setIdu(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la compra: " + e.getMessage());
        }
        cerrarConexion();
        return objUsuario;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        UsuarioVista objUsuario;
        try {
            String sql = "SELECT idu, clave_u, concat (nombre_e,\" \",apellido_e) as empleado \n"
                        + "FROM Usuario as u inner join empleados as e on u.empleados_ide = e.ide \n"
                        + "ORDER BY idu ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objUsuario = new UsuarioVista();
                objUsuario.setIdu(resultSet.getInt("idu"));
                objUsuario.setClave_u(resultSet.getString("clave_u"));
                objUsuario.setEmpleado(resultSet.getString("empleado"));

                rowsQuery.add(objUsuario);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de los usuario: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
