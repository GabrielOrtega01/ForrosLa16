package modelo;

public class ItemCmbProductos {

    private int idprod;
    private String nombre_prod;

    public ItemCmbProductos() {
    }

    public ItemCmbProductos(int idprod, String nombre_prod) {
        this.idprod = idprod;
        this.nombre_prod = nombre_prod;

    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    @Override
    public String toString() {
        return nombre_prod;
    }
}
