package modelo;

public class ItemCmbMaquinas {

    private int idm;
    private String nombre_m;
    private String referencia_m;
    private int servcios_id_servicio;

    public ItemCmbMaquinas() {
        this.idm = 0;
        this.nombre_m = "";
        this.referencia_m = "";
        this.servcios_id_servicio = 0;
    }

    public ItemCmbMaquinas(int idm, String nombre_m, String referencia_m, int servcios_id_servicio) {
        this.idm = idm;
        this.nombre_m = nombre_m;
        this.referencia_m = referencia_m;
        this.servcios_id_servicio = servcios_id_servicio;
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

    public String getReferencia() {
        return referencia_m;
    }

    public void setReferencia(String referencia_m) {
        this.referencia_m = referencia_m;
    }

    public int getServcios_id_servicio() {
        return servcios_id_servicio;
    }

    public void setServcios_id_servicio(int servcios_id_servicio) {
        this.servcios_id_servicio = servcios_id_servicio;
    }

    @Override
    public String toString() {
        return nombre_m;
    }

}
