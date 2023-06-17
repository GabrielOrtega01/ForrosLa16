package modelo;

public class ItemCmbHerramientas {

    private int idh;
    private String nombre_h;

    public ItemCmbHerramientas() {
    }

    public ItemCmbHerramientas(int idh, String nombre_h) {
        this.idh = idh;
        this.nombre_h = nombre_h;
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
        return nombre_h;
    }

}
