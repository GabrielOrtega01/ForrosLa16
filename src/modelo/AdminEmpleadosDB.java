package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminEmpleadosDB extends Conexion implements CRUD {

    public AdminEmpleadosDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Empleados objEmpleados = (Empleados) obj;
        try {
            String sql = "INSERT INTO empleados (nombre_e, apellido_e, cc_e, cargo_e, salario_e ) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objEmpleados.getNombre_e());
            preparedStatement.setString(2, objEmpleados.getApellido_e());
            preparedStatement.setString(3, objEmpleados.getCc_e());
            preparedStatement.setString(4, objEmpleados.getCargo_e());
            preparedStatement.setInt(5, objEmpleados.getSalario_e());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objEmpleados.setIde(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del empleados fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar la empleados: " + e.getMessage());
        }
        cerrarConexion();
        return objEmpleados;

    }

    @Override
    public boolean actualizar(Object obj) {
        Empleados objEmpleados = (Empleados) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE empleados SET nombre_e=?,apellido_e=?,cc_e=?,cargo_e=?, salario_e=? WHERE ide=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objEmpleados.getNombre_e());
            preparedStatement.setString(2, objEmpleados.getApellido_e());
            preparedStatement.setString(3, objEmpleados.getCc_e());
            preparedStatement.setString(4, objEmpleados.getCargo_e());
            preparedStatement.setInt(5, objEmpleados.getSalario_e());
            preparedStatement.setInt(6, objEmpleados.getIde());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la Empleados: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Empleados objEmpleados = (Empleados) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Empleados WHERE ide =?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objEmpleados.getIde());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar a la empleados: "+e.getMessage());
            System.out.println("Error al eliminar el empleados: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Empleados objEmpleados;
        try {
            String sql = "SELECT * FROM empleados ORDER BY ide ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objEmpleados = new Empleados();
                objEmpleados.setIde(resultSet.getInt("ide"));
                objEmpleados.setNombre_e(resultSet.getString("nombre_e"));
                objEmpleados.setApellido_e(resultSet.getString("apellido_e"));
                objEmpleados.setCc_e(resultSet.getString("cc_e"));
                objEmpleados.setCargo_e(resultSet.getString("cargo_e"));
                objEmpleados.setSalario_e(resultSet.getInt("salario_e"));

                rowsQuery.add(objEmpleados);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos. " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Empleados objEmpleados = (Empleados) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM empleados WHERE ide  = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objEmpleados.getIde ());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objEmpleados.setIde(resultSet.getInt("ide"));
                objEmpleados.setNombre_e(resultSet.getString("nombre_e"));
                objEmpleados.setApellido_e(resultSet.getString("apellido_e"));
                objEmpleados.setCc_e(resultSet.getString("cc_e"));
                objEmpleados.setCargo_e(resultSet.getString("cargo_e"));
                objEmpleados.setSalario_e(resultSet.getInt("salario_e"));
                flag = true;
            }
            if (!flag) {
                objEmpleados.setIde(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la Empleados: " + e.getMessage());
        }
        cerrarConexion();
        return objEmpleados;
    }

    public boolean puedeAccederAlsistema(String nombre_e, String clave_u) {
        Connection conex = abrirConexion();
        boolean flag = false;
        int total = 0;
        
        try {
            String sql = "SELECT count(*) total FROM empleados WHERE nombre_e=? AND clave_u=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, nombre_e);
            preparedStatement.setString(2, clave_u);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                total = resultSet.getInt("total"); 

            }

            if (total> 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error al validar el acceso al sistema: " + ex.getMessage());
        }

        cerrarConexion();

        return flag;
    }

}
