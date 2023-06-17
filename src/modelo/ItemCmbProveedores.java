package modelo;

public class ItemCmbProveedores {

    private int idprov;
    private String nombre_prov;

    public ItemCmbProveedores() {
        this.idprov = 0;
        this.nombre_prov = "";
    }

    public ItemCmbProveedores(int idprov, String nombre_prov) {
        this.idprov = idprov;
        this.nombre_prov = nombre_prov;
    }

    public int getIdprov() {
        return idprov;
    }

    public void setIdprov(int idprov) {
        this.idprov = idprov;
    }

    public String getNombre_prov() {
        return nombre_prov;
    }

    public void setNombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }

    @Override
    public String toString() {
        return nombre_prov;
    }

}
