package modelo;

public class Maquinas {

    private int idm;
    private String nombre_m;
    private String referencia_m;

    public Maquinas() {
        this.idm = 0;
        this.nombre_m = "";
        this.referencia_m = "";
    }

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public String getNombre_m() {
        return nombre_m;
    }

    public void setNombre_m(String nombre_m) {
        this.nombre_m = nombre_m;
    }

    public String getReferencia_m() {
        return referencia_m;
    }

    public void setReferencia_m(String referencia_m) {
        this.referencia_m = referencia_m;

    }

    @Override
    public String toString() {
        return "Maquinas{" + "idm=" + idm + ", nombre_m=" + nombre_m + ", referencia_m=" + referencia_m + '}';
    }

}
