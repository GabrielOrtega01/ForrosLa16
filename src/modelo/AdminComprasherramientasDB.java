package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminComprasherramientasDB extends Conexion implements CRUD {

    public AdminComprasherramientasDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Comprasherramientas objCompras = (Comprasherramientas) obj;
        try {
            String sql = "INSERT INTO comprasherramientas (valor_ch, fecha_ch, iva_ch, proveedores_idprov, herramientas_idh) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objCompras.getValor_ch());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objCompras.getFecha_ch()));
            preparedStatement.setFloat(3, objCompras.getIva_ch());
            preparedStatement.setInt(4, objCompras.getProveedores_idprov());
            preparedStatement.setInt(5, objCompras.getHerramientas_idh());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                objCompras.setIdch(rs.getInt(1));
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
        Comprasherramientas objCompras = (Comprasherramientas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE comprasherramientas SET valor_ch=?, fecha_ch=?, iva_ch=?, proveedores_idprov=?, herramientas_idh=? WHERE idch=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getValor_ch());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objCompras.getFecha_ch()));
            preparedStatement.setFloat(3, objCompras.getIva_ch());
            preparedStatement.setInt(4, objCompras.getProveedores_idprov());
            preparedStatement.setInt(5, objCompras.getHerramientas_idh());
            preparedStatement.setInt(6, objCompras.getIdch());
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
        Comprasherramientas objCompras = (Comprasherramientas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM comprasherramientas WHERE idch=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getIdch());
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
        Comprasherramientas objCompras;
        try {
            String sql = "SELECT * FROM comprasherramientas ORDER BY idch ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new Comprasherramientas();
                objCompras.setIdch(resultSet.getInt("idch"));
                objCompras.setValor_ch(resultSet.getInt("valor_ch"));
                objCompras.setFecha_ch(resultSet.getDate("fecha_ch").toLocalDate());
                objCompras.setIva_ch(resultSet.getFloat("iva_ch"));
                objCompras.setProveedores_idprov(resultSet.getInt("proveedores_idprov"));
                objCompras.setHerramientas_idh(resultSet.getInt("herramientas_idh"));

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
        Comprasherramientas objCompras = (Comprasherramientas) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM comprasherramientas WHERE idch = ? ORDER BY idch ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCompras.getIdch());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new Comprasherramientas();
                objCompras.setIdch(resultSet.getInt("idch"));
                objCompras.setValor_ch(resultSet.getInt("valor_ch"));
                objCompras.setFecha_ch(resultSet.getDate("fecha_ch").toLocalDate());
                objCompras.setIva_ch(resultSet.getFloat("iva_ch"));
                objCompras.setProveedores_idprov(resultSet.getInt("proveedores_idprov"));
                objCompras.setHerramientas_idh(resultSet.getInt("herramientas_idh"));
                flag = true;
            }
            if (!flag) {
                objCompras.setIdch(0);
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
        ComprasherramientasVista objCompras;
        try {
            String sql = "Select idch, valor_ch, fecha_ch, iva_ch, nombre_prov as proveedor, nombre_h as herramienta\n"
                        + "from comprasherramientas as c  inner join proveedores as p\n"
                        + "on p.idprov = c.proveedores_idprov inner join \n"
                        + "herramientas as h on h.idh = c.herramientas_idh\n"
                        + "ORDER BY idch ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCompras = new ComprasherramientasVista();
                objCompras.setIdch(resultSet.getInt("idch"));
                objCompras.setValor_ch(resultSet.getInt("valor_ch"));
                objCompras.setFecha_ch(resultSet.getDate("fecha_ch").toLocalDate());
                objCompras.setIva_ch(resultSet.getFloat("iva_ch"));
                objCompras.setProveedor(resultSet.getString("proveedor"));
                objCompras.setHerramienta(resultSet.getString("herramienta"));

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
