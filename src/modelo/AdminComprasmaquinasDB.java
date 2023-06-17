package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminComprasmaquinasDB extends Conexion implements CRUD {

    public AdminComprasmaquinasDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Comprasmaquinas objCompras = (Comprasmaquinas) obj;
        try {
            String sql = "INSERT INTO comprasmaquinas (valor_cm, fecha_cm, iva_cm, proveedores_idprov, maquinas_idm) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objCompras.getValor_cm());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objCompras.getFecha_cm()));
            preparedStatement.setFloat(3, objCompras.getIva_cm());
            preparedStatement.setInt(4, objCompras.getProveedores_idprov());
            preparedStatement.setInt(5, objCompras.getMaquinas_idm());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                objCompras.setIdcm(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la compra fue exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al insertar las compras: " + e.getMessage());
        }
        cerrarConexion();
        return objCompras;
    }

    @Override
    public boolean actualizar(Object obj) {
        Comprasmaquinas objCompras = (Comprasmaquinas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE comprasmaquinas SET valor_cm=?, fecha_cm=?, iva_cm=?, proveedores_idprov=?, maquinas_idm=? WHERE idcm=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getValor_cm());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objCompras.getFecha_cm()));
            preparedStatement.setFloat(3, objCompras.getIva_cm());
            preparedStatement.setInt(4, objCompras.getProveedores_idprov());
            preparedStatement.setInt(5, objCompras.getMaquinas_idm());
            preparedStatement.setInt(6, objCompras.getIdcm());
            int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la compra: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Comprasmaquinas objCompras = (Comprasmaquinas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM comprasmaquinas WHERE idcm=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getIdcm());
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
        Comprasmaquinas objCompras;
        try {
            String sql = "SELECT * FROM comprasmaquinas ORDER BY idcm ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new Comprasmaquinas();
                objCompras.setIdcm(resultSet.getInt("idcm"));
                objCompras.setValor_cm(resultSet.getInt("valor_cm"));
                objCompras.setFecha_cm(resultSet.getDate("fecha_cm").toLocalDate());
                objCompras.setIva_cm(resultSet.getFloat("iva_cm"));
                objCompras.setProveedores_idprov(resultSet.getInt("proveedores_idprov"));
                objCompras.setMaquinas_idm(resultSet.getInt("maquinas_idm"));

                rowsQuery.add(objCompras);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las compras: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Comprasmaquinas objCompras = (Comprasmaquinas) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM comprasmaquinas WHERE idcm = ? ORDER BY idcm ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getIdcm());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new Comprasmaquinas();
                objCompras.setIdcm(resultSet.getInt("idcm"));
                objCompras.setValor_cm(resultSet.getInt("valor_cm"));
                objCompras.setFecha_cm(resultSet.getDate("fecha_cm").toLocalDate());
                objCompras.setIva_cm(resultSet.getFloat("iva_cm"));
                objCompras.setProveedores_idprov(resultSet.getInt("proveedores_idprov"));
                objCompras.setMaquinas_idm(resultSet.getInt("maquinas_idm"));
                flag = true;
            }
            if (!flag) {
                objCompras.setIdcm(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la compra: " + e.getMessage());
        }
        cerrarConexion();
        return objCompras;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        ComprasmaquinasVista objCompras;
        try {
            String sql = "Select idcm, valor_cm, fecha_cm, iva_cm, nombre_prov as proveedor, nombre_m as maquina \n"
                        + "from comprasmaquinas as c  inner join proveedores as p\n"
                        + "on p.idprov = c.proveedores_idprov inner join \n"
                        + "maquinas as m on m.idm = c.maquinas_idm \n"
                        + "ORDER BY idcm ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new ComprasmaquinasVista();
                objCompras.setIdcm(resultSet.getInt("idcm"));
                objCompras.setValor_cm(resultSet.getInt("valor_cm"));
                objCompras.setFecha_cm(resultSet.getDate("fecha_cm").toLocalDate());
                objCompras.setIva_cm(resultSet.getFloat("iva_cm"));
                objCompras.setProveedor(resultSet.getString("proveedor"));
                objCompras.setMaquina(resultSet.getString("maquina"));

                rowsQuery.add(objCompras);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de las compras: " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
