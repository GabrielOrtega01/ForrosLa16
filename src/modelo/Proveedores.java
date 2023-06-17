package modelo;

public class Proveedores {

    private int Idprov;
    private String nombre_prov;

    public Proveedores() {
        this.Idprov = 0;
        this.nombre_prov = "";
    }

    public Proveedores(int Idprov, String nombre_prov) {
        this.Idprov = Idprov;
        this.nombre_prov = nombre_prov;
    }

    public int getIdprov() {
        return Idprov;
    }

    public void setIdprov(int Idprov) {
        this.Idprov = Idprov;
    }

    public String getNombre_prov() {
        return nombre_prov;
    }

    public void setNombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "Idprov=" + Idprov + ", nombre_prov=" + nombre_prov + '}';
    }

}
