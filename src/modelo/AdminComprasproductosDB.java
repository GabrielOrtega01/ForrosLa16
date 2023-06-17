package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminComprasproductosDB extends Conexion implements CRUD {

    public AdminComprasproductosDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Comprasproductos objCompras = (Comprasproductos) obj;
        try {
            String sql = "INSERT INTO comprasproductos (valor_cp, fecha_cp, cantidad_cp, iva_cp, proveedores_idprov, productos_idprod) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objCompras.getValor_cp());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objCompras.getFecha_cp()));
            preparedStatement.setInt(3, objCompras.getCantidad_cp());
            preparedStatement.setFloat(4, objCompras.getIva_cp());
            preparedStatement.setInt(5, objCompras.getProveedores_idprov());
            preparedStatement.setInt(6, objCompras.getProductos_idprod());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                objCompras.setIdcp(rs.getInt(1));
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
        Comprasproductos objCompras = (Comprasproductos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE comprasproductos SET valor_cp=?, fecha_cp=?, cantidad_cp=?, iva_cp=?, proveedores_idprov=?, productos_idprod=? WHERE idcp=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getValor_cp());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objCompras.getFecha_cp()));
            preparedStatement.setInt(3, objCompras.getCantidad_cp());
            preparedStatement.setFloat(4, objCompras.getIva_cp());
            preparedStatement.setInt(5, objCompras.getProveedores_idprov());
            preparedStatement.setInt(6, objCompras.getProductos_idprod());
            preparedStatement.setInt(7, objCompras.getIdcp());
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
        Comprasproductos objCompras = (Comprasproductos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM comprasproductos WHERE idcp=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getIdcp());
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
        Comprasproductos objCompras;
        try {
            String sql = "SELECT * FROM comprasproductos ORDER BY idcp ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new Comprasproductos();
                objCompras.setIdcp(resultSet.getInt("idcp"));
                objCompras.setValor_cp(resultSet.getInt("valor_cp"));
                objCompras.setFecha_cp(resultSet.getDate("fecha_cp").toLocalDate());
                objCompras.setIva_cp(resultSet.getFloat("iva_cp"));
                objCompras.setCantidad_cp(resultSet.getInt("cantidad_cp"));
                objCompras.setProveedores_idprov(resultSet.getInt("proveedores_idprov"));
                objCompras.setProductos_idprod(resultSet.getInt("productos_idprod"));

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
        Comprasproductos objCompras = (Comprasproductos) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM comprasproductos WHERE idcp = ? ORDER BY idcp ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getIdcp());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new Comprasproductos();
                objCompras.setIdcp(resultSet.getInt("idcp"));
                objCompras.setValor_cp(resultSet.getInt("valor_cp"));
                objCompras.setFecha_cp(resultSet.getDate("fecha_cp").toLocalDate());
                objCompras.setCantidad_cp(resultSet.getInt("cantidad_cp"));
                objCompras.setIva_cp(resultSet.getFloat("iva_cp"));
                objCompras.setProveedores_idprov(resultSet.getInt("proveedores_idprov"));
                objCompras.setProductos_idprod(resultSet.getInt("productos_idprod"));
                flag = true;
            }
            if (!flag) {
                objCompras.setIdcp(0);
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
        ComprasproductosVista objCompras;
        try {
            String sql = "Select idcp, valor_cp, fecha_cp, cantidad_cp, iva_cp, nombre_prov as proveedor, nombre_prod as producto \n"
                        + "from comprasproductos as c  inner join proveedores as prov\n"
                        + "on prov.idprov = c.proveedores_idprov inner join \n"
                        + "productos as prod on prod.idprod = c.productos_idprod \n"
                        + "ORDER BY idcp ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new ComprasproductosVista();
                objCompras.setIdcp(resultSet.getInt("idcp"));
                objCompras.setValor_cp(resultSet.getInt("valor_cp"));
                objCompras.setFecha_cp(resultSet.getDate("fecha_cp").toLocalDate());
                objCompras.setCantidad_cp(resultSet.getInt("cantidad_cp"));
                objCompras.setIva_cp(resultSet.getFloat("iva_cp"));
                objCompras.setProveedor(resultSet.getString("proveedor"));
                objCompras.setProducto(resultSet.getString("producto"));

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
