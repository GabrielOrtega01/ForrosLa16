package modelo;

import java.time.LocalDate;

public class ComprasmaquinasVista {

    private int idcm;
    private int valor_cm;
    private LocalDate fecha_cm;
    private float iva_cm;
    private String proveedor;
    private String maquina;

    public ComprasmaquinasVista() {
        this.idcm = 0;
        this.valor_cm = 0;
        this.fecha_cm = LocalDate.parse("1900-01-01");
        this.iva_cm = 0;
        this.proveedor = "";
        this.maquina = "";
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    @Override
    public String toString() {
        return "ComprasmaquinasVista{" + "idcm=" + idcm + ", valor_cm=" + valor_cm + ", fecha_cm=" + fecha_cm + ", iva_cm=" + iva_cm + ", proveedor=" + proveedor + ", maquina=" + maquina + '}';
    }

}
