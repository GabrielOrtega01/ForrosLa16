package modelo;

public class ItemCmbEmpleados {

    private int ide;
    private String nombre_e;
    private String apellido_e;
    private String cc_e;
    private String cargo_e;
    private int salario_e;

    public ItemCmbEmpleados() {
    }

    public ItemCmbEmpleados(int ide, String nombre_e, String apellido_e, String cc_e, String cargo_e, int salario_e) {
        this.ide = ide;
        this.nombre_e = nombre_e;
        this.apellido_e = apellido_e;
        this.cc_e = cc_e;
        this.cargo_e = cargo_e;
        this.salario_e = salario_e;
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getNombre_e() {
        return nombre_e;
    }

    public void setNombre_e(String nombre_e) {
        this.nombre_e = nombre_e;
    }

    public String getApellido_e() {
        return apellido_e;
    }

    public void setApellido_e(String apellido_e) {
        this.apellido_e = apellido_e;
    }

    public String getCc_e() {
        return cc_e;
    }

    public void setCc_e(String cc_e) {
        this.cc_e = cc_e;
    }

    public String getCargo_e() {
        return cargo_e;
    }

    public void setCargo_e(String cargo_e) {
        this.cargo_e = cargo_e;
    }

    public int getSalario_e() {
        return salario_e;
    }

    public void setSalario_e(int salario_e) {
        this.salario_e = salario_e;
    }

    @Override
    public String toString() {
        return cc_e;
    }

}
