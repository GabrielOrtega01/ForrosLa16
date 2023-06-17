package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReporteFacturaCliente {

    private String cliente;
    private String documento;
    private String direccion;
    private String vehiculo;
    private String marca;
    private String color;
    private String servicio;
    private int costo_servicio;
    private String producto;
    private int precio_unitario;
    private int cantidad;
    private float iva;
    private BigDecimal total;
    private LocalDate fecha;
    private String empleado;
    private int idf;
    private String admin;

    public ReporteFacturaCliente() {
        this.cliente = "";
        this.documento = "";
        this.direccion = "";
        this.vehiculo = "";
        this.marca = "";
        this.color = "";
        this.servicio = "";
        this.costo_servicio = 0;
        this.producto = "";
        this.precio_unitario = 0;
        this.cantidad = 0;
        this.iva = 0;
        this.total = BigDecimal.ZERO;
        this.fecha = LocalDate.parse("1900-01-01");
        this.empleado = "";
        this.idf = 0;
        this.admin = "";
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(int costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "FacturaCliente{" + "cliente=" + cliente + ", documento=" + documento + ", direccion=" + direccion + ", vehiculo=" + vehiculo + ", marca=" + marca + ", color=" + color + ", servicio=" + servicio + ", costo_servicio=" + costo_servicio + ", producto=" + producto + ", precio_unitario=" + precio_unitario + ", cantidad=" + cantidad + ", iva=" + iva + ", total=" + total + ", fecha=" + fecha + ", empleado=" + empleado + ", idf=" + idf + ", admin=" + admin + '}';
    }

}
