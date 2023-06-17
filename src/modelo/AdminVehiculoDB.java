package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminVehiculoDB extends Conexion implements CRUD {

    public AdminVehiculoDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Vehiculo objVehiculo = (Vehiculo) obj;
        try {

            String sql = "INSERT INTO vehiculo (marca_v, color_v, placa_v, clientes_idc) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objVehiculo.getMarca_v());
            preparedStatement.setString(2, objVehiculo.getColor_v());
            preparedStatement.setString(3, objVehiculo.getPlaca_v());
            preparedStatement.setInt(4, objVehiculo.getClientes_idc());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objVehiculo.setIdv(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del vehículo fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar la vehículo: " + e.getMessage());
        }
        cerrarConexion();
        return objVehiculo;

    }

    @Override
    public boolean actualizar(Object obj) {
        Vehiculo objVehiculo = (Vehiculo) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE vehiculo SET marca_v=?, color_v=?, placa_v=?, clientes_idc=? WHERE idv=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objVehiculo.getMarca_v());
            preparedStatement.setString(2, objVehiculo.getColor_v());
            preparedStatement.setString(3, objVehiculo.getPlaca_v());
            preparedStatement.setInt(4, objVehiculo.getClientes_idc());
            preparedStatement.setInt(5, objVehiculo.getIdv());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el vehiculo: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Vehiculo objVehiculo = (Vehiculo) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {

            String sql = "DELETE FROM Vehiculo WHERE idv=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objVehiculo.getIdv());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el vehiculo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Vehiculo objVehiculo;
        try {

            String sql = "SELECT * FROM Vehiculo ORDER BY idv ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVehiculo = new Vehiculo();
                objVehiculo.setIdv(resultSet.getInt("idv"));
                objVehiculo.setMarca_v(resultSet.getString("marca_v"));
                objVehiculo.setColor_v(resultSet.getString("color_v"));
                objVehiculo.setPlaca_v(resultSet.getString("placa_v"));
                objVehiculo.setClientes_idc(resultSet.getInt("clientes_idc"));

                rowsQuery.add(objVehiculo);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de los usuarios: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Vehiculo objVehiculo = (Vehiculo) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM vehiculo WHERE idv = ? ORDER BY idv ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objVehiculo.getIdv());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVehiculo = new Vehiculo();
                objVehiculo.setIdv(resultSet.getInt("idv"));
                objVehiculo.setMarca_v(resultSet.getString("marca_v"));
                objVehiculo.setColor_v(resultSet.getString("color_v"));
                objVehiculo.setPlaca_v(resultSet.getString("placa_v"));
                objVehiculo.setClientes_idc(resultSet.getInt("clientes_idc"));
            }
            if (!flag) {
                objVehiculo.setIdv(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el vehiculo: " + e.getMessage());
        }
        cerrarConexion();
        return objVehiculo;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        VehiculoVista objVehiculo;
        try {

            String sql = "Select idv, marca_v, color_v, placa_v, concat(nombre_c,' ',apellido_c) as cliente from \n"
                        + "vehiculo as v  inner join clientes as c\n"
                        + "on c.idc = v.clientes_idc\n"
                        + "ORDER BY idv ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVehiculo = new VehiculoVista();
                objVehiculo.setIdv(resultSet.getInt("idv"));
                objVehiculo.setMarca_v(resultSet.getString("marca_v"));
                objVehiculo.setColor_v(resultSet.getString("color_v"));
                objVehiculo.setPlaca_v(resultSet.getString("placa_v"));
                objVehiculo.setCliente(resultSet.getString("cliente"));

                rowsQuery.add(objVehiculo);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de los usuarios: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
