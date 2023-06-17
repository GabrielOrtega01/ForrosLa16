package modelo;

public class Servicios {

    private int ids;
    private String nombre_s;
    private int costo_s;

    public Servicios() {
        this.ids = 0;
        this.nombre_s = "";
        this.costo_s = 0;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getNombre_s() {
        return nombre_s;
    }

    public void setNombre_s(String nombre_s) {
        this.nombre_s = nombre_s;
    }

    public int getCosto_s() {
        return costo_s;
    }

    public void setCosto_s(int costo_s) {
        this.costo_s = costo_s;
    }

    @Override
    public String toString() {
        return "Servicios{" + "ids=" + ids + ", nombre_s=" + nombre_s + ", costo_s=" + costo_s + '}';
    }
}
