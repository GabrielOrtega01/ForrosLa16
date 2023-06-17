package modelo;

import java.time.LocalDate;

public class ComprasherramientasVista {

    private int idch;
    private int valor_ch;
    private LocalDate fecha_ch;
    private float iva_ch;
    private String proveedor;
    private String herramienta;

    public ComprasherramientasVista() {
        this.idch = 0;
        this.valor_ch = 0;
        this.fecha_ch = LocalDate.parse("1900-01-01");
        this.iva_ch = 0;
        this.proveedor = "";
        this.herramienta = "";
    }

    public int getIdch() {
        return idch;
    }

    public void setIdch(int idch) {
        this.idch = idch;
    }

    public int getValor_ch() {
        return valor_ch;
    }

    public void setValor_ch(int valor_ch) {
        this.valor_ch = valor_ch;
    }

    public LocalDate getFecha_ch() {
        return fecha_ch;
    }

    public void setFecha_ch(LocalDate fecha_ch) {
        this.fecha_ch = fecha_ch;
    }

    public float getIva_ch() {
        return iva_ch;
    }

    public void setIva_ch(float iva_ch) {
        this.iva_ch = iva_ch;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    @Override
    public String toString() {
        return "ComprasherramientasVista{" + "idch=" + idch + ", valor_ch=" + valor_ch + ", fecha_ch=" + fecha_ch + ", iva_ch=" + iva_ch + ", proveedor=" + proveedor + ", herramienta=" + herramienta + '}';
    }

}
