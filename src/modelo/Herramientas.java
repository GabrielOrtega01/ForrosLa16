package modelo;

public class Herramientas {

    private int idh;
    private String nombre_h;

    public Herramientas() {
        this.idh = 0;
        this.nombre_h = "";
    }

    public int getIdh() {
        return idh;
    }

    public void setIdh(int idh) {
        this.idh = idh;
    }

    public String getNombre_h() {
        return nombre_h;
    }

    public void setNombre_h(String nombre_h) {
        this.nombre_h = nombre_h;
    }

    @Override
    public String toString() {
        return "Herramientas{" + "idh=" + idh + ", nombre_h=" + nombre_h + '}';
    }

}
