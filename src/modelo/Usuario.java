package modelo;

public class Usuario {

    private int idu;
    private String clave_u;
    private int empleados_ide;

    public Usuario() {
        this.idu = 0;
        this.clave_u = "";
        this.empleados_ide = 0;
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

    public int getEmpleados_ide() {
        return empleados_ide;
    }

    public void setEmpleados_ide(int empleados_ide) {
        this.empleados_ide = empleados_ide;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "idu=" + idu + ", clave_u=" + clave_u + ", empleados_ide=" + empleados_ide + '}';
    }

}
