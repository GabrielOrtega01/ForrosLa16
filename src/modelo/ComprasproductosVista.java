package modelo;

import java.time.LocalDate;

public class ComprasproductosVista {

    private int idcp;
    private int valor_cp;
    private LocalDate fecha_cp;
    private int cantidad_cp;
    private float iva_cp;
    private String proveedor;
    private String producto;

    public ComprasproductosVista() {
        this.idcp = 0;
        this.valor_cp = 0;
        this.fecha_cp = LocalDate.parse("1900-01-01");
        this.cantidad_cp = 0;
        this.iva_cp = 0;
        this.proveedor = "";
        this.producto = "";
    }

    public int getIdcp() {
        return idcp;
    }

    public void setIdcp(int idcp) {
        this.idcp = idcp;
    }

    public int getValor_cp() {
        return valor_cp;
    }

    public void setValor_cp(int valor_cp) {
        this.valor_cp = valor_cp;
    }

    public LocalDate getFecha_cp() {
        return fecha_cp;
    }

    public void setFecha_cp(LocalDate fecha_cp) {
        this.fecha_cp = fecha_cp;
    }

    public int getCantidad_cp() {
        return cantidad_cp;
    }

    public void setCantidad_cp(int cantidad_cp) {
        this.cantidad_cp = cantidad_cp;
    }

    public float getIva_cp() {
        return iva_cp;
    }

    public void setIva_cp(float iva_cp) {
        this.iva_cp = iva_cp;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ComprasproductosVista{" + "idcp=" + idcp + ", valor_cp=" + valor_cp + ", fecha_cp=" + fecha_cp + ", cantidad_cp=" + cantidad_cp + ", iva_cp=" + iva_cp + ", proveedor=" + proveedor + ", producto=" + producto + '}';
    }

}
