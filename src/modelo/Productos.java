package modelo;

public class Productos {

    private int idprod;
    private String nombre_prod;

    public Productos() {
        this.idprod = 0;
        this.nombre_prod = "";
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
        return "Productos{" + "idprod=" + idprod + ", nombre_prod=" + nombre_prod + '}';
    }
}
