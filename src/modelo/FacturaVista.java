package modelo;

import java.time.LocalDate;

public class FacturaVista {

    private int idf;
    private String servicio;
    private String producto;
    private String cliente;
    private String empleado;
    private LocalDate fecha_f;
    private int valor_f;

    public FacturaVista() {
        this.idf = 0;
        this.servicio = "";
        this.producto = "";
        this.cliente = "";
        this.empleado = "";
        this.fecha_f = LocalDate.parse("1900-01-01");
        this.valor_f = 0;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFecha_f() {
        return fecha_f;
    }

    public void setFecha_f(LocalDate fecha_f) {
        this.fecha_f = fecha_f;
    }

    public int getValor_f() {
        return valor_f;
    }

    public void setValor_f(int valor_f) {
        this.valor_f = valor_f;
    }

    @Override
    public String toString() {
        return "VentaVista{" + "idf=" + idf + ", servicio=" + servicio + ", producto=" + producto + ", cliente=" + cliente + ", empleado=" + empleado + ", fecha_f=" + fecha_f + ", valor_f=" + valor_f + '}';
    }

}
