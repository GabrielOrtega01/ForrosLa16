package modelo;

import java.time.LocalDate;

public class Comprasmaquinas {

    private int idcm;
    private int valor_cm;
    private LocalDate fecha_cm;
    private float iva_cm;
    private int proveedores_idprov;
    private int maquinas_idm;

    public Comprasmaquinas() {
        this.idcm = 0;
        this.valor_cm = 0;
        this.fecha_cm = LocalDate.parse("1900-01-01");
        this.iva_cm = 0;
        this.proveedores_idprov = 0;
        this.maquinas_idm = 0;

    }

    public int getIdcm() {
        return idcm;
    }

    public void setIdcm(int idcm) {
        this.idcm = idcm;
    }

    public int getValor_cm() {
        return valor_cm;
    }

    public void setValor_cm(int valor_cm) {
        this.valor_cm = valor_cm;
    }

    public LocalDate getFecha_cm() {
        return fecha_cm;
    }

    public void setFecha_cm(LocalDate fecha_cm) {
        this.fecha_cm = fecha_cm;
    }

    public float getIva_cm() {
        return iva_cm;
    }

    public void setIva_cm(float iva_cm) {
        this.iva_cm = iva_cm;
    }

    public int getProveedores_idprov() {
        return proveedores_idprov;
    }

    public void setProveedores_idprov(int proveedores_idprov) {
        this.proveedores_idprov = proveedores_idprov;
    }

    public int getMaquinas_idm() {
        return maquinas_idm;
    }

    public void setMaquinas_idm(int maquinas_idm) {
        this.maquinas_idm = maquinas_idm;
    }

    @Override
    public String toString() {
        return "Comprasmaquinas{" + "idcm=" + idcm + ", valor_cm=" + valor_cm + ", fecha_cm=" + fecha_cm + ", iva_cm=" + iva_cm + ", proveedores_idprov=" + proveedores_idprov + ", maquinas_idm=" + maquinas_idm + '}';
    }

}
