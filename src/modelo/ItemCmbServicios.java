package modelo;

public class ItemCmbServicios {

    private int ids;
    private String nombre_s;
    private int costo_s;

    public ItemCmbServicios() {
    }

    public ItemCmbServicios(int ids, String nombre_s, int costo_s) {
        this.ids = ids;
        this.nombre_s = nombre_s;
        this.costo_s = costo_s;
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
        return nombre_s;
    }

}
