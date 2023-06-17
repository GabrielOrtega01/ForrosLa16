package modelo;

import java.time.LocalDate;

public class Comprasproductos {

    private int idcp;
    private int valor_cp;
    private LocalDate fecha_cp;
    private int cantidad_cp;
    private float iva_cp;
    private int proveedores_idprov;
    private int productos_idprod;

    public Comprasproductos() {
        this.idcp = 0;
        this.valor_cp = 0;
        this.fecha_cp = LocalDate.parse("1900-01-01");
        this.cantidad_cp = 0;
        this.iva_cp = 0;
        this.proveedores_idprov = 0;
        this.productos_idprod = 0;

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

    public int getProveedores_idprov() {
        return proveedores_idprov;
    }

    public void setProveedores_idprov(int proveedores_idprov) {
        this.proveedores_idprov = proveedores_idprov;
    }

    public int getProductos_idprod() {
        return productos_idprod;
    }

    public void setProductos_idprod(int productos_idprod) {
        this.productos_idprod = productos_idprod;
    }

    @Override
    public String toString() {
        return "Comprasproductos{" + "idcp=" + idcp + ", valor_cp=" + valor_cp + ", fecha_cp=" + fecha_cp + ", cantidad_cp=" + cantidad_cp + ", iva_cp=" + iva_cp + ", proveedores_idprov=" + proveedores_idprov + ", productos_idprod=" + productos_idprod + '}';
    }

}
