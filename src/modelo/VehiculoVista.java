package modelo;

public class VehiculoVista {

    private int idv;
    private String marca_v;
    private String color_v;
    private String placa_v;
    private String cliente;

    public VehiculoVista() {
        this.idv = 0;
        this.marca_v = "";
        this.color_v = "";
        this.placa_v = "";
        this.cliente = "";
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public String getMarca_v() {
        return marca_v;
    }

    public void setMarca_v(String marca_v) {
        this.marca_v = marca_v;
    }

    public String getColor_v() {
        return color_v;
    }

    public void setColor_v(String color_v) {
        this.color_v = color_v;
    }

    public String getPlaca_v() {
        return placa_v;
    }

    public void setPlaca_v(String placa_v) {
        this.placa_v = placa_v;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "VehiculoVista{" + "idv=" + idv + ", marca_v=" + marca_v + ", color_v=" + color_v + ", placa_v=" + placa_v + ", cliente=" + cliente + '}';
    }

}
