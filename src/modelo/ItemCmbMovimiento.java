package modelo;

public class ItemCmbMovimiento {

    private int idm;
    private int cantidad_producto;
    private int servicios_ids;
    private int empleados_ide;
    private int vehiculo_idv;
    private int productos_idprod;

    public ItemCmbMovimiento() {
    }

    public ItemCmbMovimiento(int idm, int cantidad_producto, int servicios_ids, int empleados_ide, int vehiculo_idv, int productos_idprod) {
        this.idm = idm;
        this.cantidad_producto = cantidad_producto;
        this.servicios_ids = servicios_ids;
        this.empleados_ide = empleados_ide;
        this.vehiculo_idv = vehiculo_idv;
        this.productos_idprod = productos_idprod;
    }

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public int getServicios_ids() {
        return servicios_ids;
    }

    public void setServicios_ids(int servicios_ids) {
        this.servicios_ids = servicios_ids;
    }

    public int getEmpleados_ide() {
        return empleados_ide;
    }

    public void setEmpleados_ide(int empleados_ide) {
        this.empleados_ide = empleados_ide;
    }

    public int getVehiculo_idv() {
        return vehiculo_idv;
    }

    public void setVehiculo_idv(int vehiculo_idv) {
        this.vehiculo_idv = vehiculo_idv;
    }

    public int getProductos_idprod() {
        return productos_idprod;
    }

    public void setProductos_idprod(int productos_idprod) {
        this.productos_idprod = productos_idprod;
    }

    @Override
    public String toString() {
        return "" + "" + idm + "";
    }
}
