package modelo;

public class Clientes {

    private int idc;
    private String nombre_c;
    private String apellido_c;
    private String cc_c;
    private String direccion_c;

    public Clientes() {
        this.idc = 0;
        this.nombre_c = "";
        this.apellido_c = "";
        this.cc_c = "";
        this.direccion_c = "";
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNombre_c() {
        return nombre_c;
    }

    public void setNombre_c(String nombre_c) {
        this.nombre_c = nombre_c;
    }

    public String getApellido_c() {
        return apellido_c;
    }

    public void setApellido_c(String apellido_c) {
        this.apellido_c = apellido_c;
    }

    public String getCc_c() {
        return cc_c;
    }

    public void setCc_c(String cc_c) {
        this.cc_c = cc_c;
    }

    public String getDireccion_c() {
        return direccion_c;
    }

    public void setDireccion_c(String direccion_c) {
        this.direccion_c = direccion_c;
    }

    @Override
    public String toString() {
        return "Clientes{" + "idc=" + idc + ", nombre_c=" + nombre_c + ", apellido_c=" + apellido_c
                    + ", cc_c=" + cc_c + ", direccion_c=" + direccion_c + '}';
    }
}
