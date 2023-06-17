package modelo;

import java.time.LocalDate;

public class ReporteBalanceProductos {

    private int cantidad_utilizada;
    private LocalDate fecha_de_compra;
    private LocalDate fecha_factura;
    private String empleado_responsable;
    private int cantidad_actual;
    private int cantidad_inicial;

    public ReporteBalanceProductos() {

        this.cantidad_utilizada = 0;
        this.fecha_de_compra = LocalDate.parse("1900-01-01");
        this.fecha_factura = LocalDate.parse("1900-01-01");
        this.empleado_responsable = "";
        this.cantidad_actual = 0;
        this.cantidad_inicial = 0;
    }

    public int getCantidad_utilizada() {
        return cantidad_utilizada;
    }

    public void setCantidad_utilizada(int cantidad_utilizada) {
        this.cantidad_utilizada = cantidad_utilizada;
    }

    public LocalDate getFecha_de_compra() {
        return fecha_de_compra;
    }

    public void setFecha_de_compra(LocalDate fecha_de_compra) {
        this.fecha_de_compra = fecha_de_compra;
    }

    public LocalDate getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(LocalDate fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getEmpleado_responsable() {
        return empleado_responsable;
    }

    public void setEmpleado_responsable(String empleado_responsable) {
        this.empleado_responsable = empleado_responsable;
    }

    public int getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(int cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public int getCantidad_inicial() {
        return cantidad_inicial;
    }

    public void setCantidad_inicial(int cantidad_inicial) {
        this.cantidad_inicial = cantidad_inicial;
    }

    @Override
    public String toString() {
        return "AdministrarListaInventarioProductos{" + "cantidad_utilizada=" + cantidad_utilizada + ", fecha_de_compra=" + fecha_de_compra + ", fecha_factura=" + fecha_factura + ", empleado_responsable=" + empleado_responsable + ", cantidad_actual=" + cantidad_actual + ", cantidad_inicial=" + cantidad_inicial + '}';
    }

}
