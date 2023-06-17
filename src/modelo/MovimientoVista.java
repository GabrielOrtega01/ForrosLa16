package modelo;

public class MovimientoVista {

    private int idmov;
    private int cantidad_producto;
    private String servicio;
    private String empleado;
    private String vehiculo;
    private String producto;

    public MovimientoVista() {

        this.idmov = 0;
        this.cantidad_producto = 0;
        this.servicio = "";
        this.empleado = "";
        this.vehiculo = "";
        this.producto = "";

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

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "MovimientoVista{" + "idmov=" + idmov + ", cantidad_producto=" + cantidad_producto + ", servicio=" + servicio + ", empleado=" + empleado + ", vehiculo=" + vehiculo + ", producto=" + producto + '}';
    }

}
