package modelo;

import java.time.LocalDate;

public class Comprasherramientas {

    private int idch;
    private int valor_ch;
    private LocalDate fecha_ch;
    private float iva_ch;
    private int proveedores_idprov;
    private int herramientas_idh;

    public Comprasherramientas() {
        this.idch = 0;
        this.valor_ch = 0;
        this.fecha_ch = LocalDate.parse("1900-01-01");
        this.iva_ch = 0;
        this.proveedores_idprov = 0;
        this.herramientas_idh = 0;

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

    public int getProveedores_idprov() {
        return proveedores_idprov;
    }

    public void setProveedores_idprov(int proveedores_idprov) {
        this.proveedores_idprov = proveedores_idprov;
    }

    public int getHerramientas_idh() {
        return herramientas_idh;
    }

    public void setHerramientas_idh(int herramientas_idh) {
        this.herramientas_idh = herramientas_idh;
    }

    @Override
    public String toString() {
        return "Comprasherramientas{" + "idch=" + idch + ", valor_ch=" + valor_ch + ", fecha_ch=" + fecha_ch + ", iva_ch=" + iva_ch + ", proveedores_idprov=" + proveedores_idprov + ", herramientas_idh=" + herramientas_idh + '}';
    }

}
