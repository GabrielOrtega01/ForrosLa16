package modelo;

public class UsuarioVista {

    private int idu;
    private String clave_u;
    private String empleado;

    public UsuarioVista() {
        this.idu = 0;
        this.clave_u = "";
        this.empleado = "";
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getClave_u() {
        return clave_u;
    }

    public void setClave_u(String clave_u) {
        this.clave_u = clave_u;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "UsuariosVista{" + "idu=" + idu + ", clave_u=" + clave_u + ", empleado=" + empleado + '}';
    }

}
