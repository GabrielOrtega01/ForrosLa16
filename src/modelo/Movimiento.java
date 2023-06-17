package modelo;

public class Movimiento {

    private int idmov;
    private int cantidad_producto;
    private int servicios_ids;
    private int empleados_ide;
    private int vehiculo_idv;
    private int productos_idprod;

    public Movimiento() {
        this.idmov = 0;
        this.cantidad_producto = 0;
        this.servicios_ids = 0;
        this.empleados_ide = 0;
        this.vehiculo_idv = 0;
        this.productos_idprod = 0;

    }

    public int getIdmov() {
        return idmov;
    }

    public void setIdmov(int idmov) {
        this.idmov = idmov;
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
        return "Movimiento{" + "idmov=" + idmov + ", cantidad_producto=" + cantidad_producto + ", servicios_ids=" + servicios_ids + ", empleados_ide=" + empleados_ide + ", vehiculo_idv=" + vehiculo_idv + ", productos_idprod=" + productos_idprod + '}';
    }

}
