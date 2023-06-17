package modelo;

public class ItemCmbVehiculo {

    private int idv;
    private String marca_v;
    private String color_v;
    private String placa_v;
    private int clientes_idc;

    public ItemCmbVehiculo() {
    }

    public ItemCmbVehiculo(int idv, String marca_v, String color_v, String placa_v, int clientes_idc) {
        this.idv = idv;
        this.marca_v = marca_v;
        this.color_v = color_v;
        this.placa_v = placa_v;
        this.clientes_idc = clientes_idc;
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

    public int getClientes_idc() {
        return clientes_idc;
    }

    public void setClientes_idc(int clientes_idc) {
        this.clientes_idc = clientes_idc;
    }

    @Override
    public String toString() {
        return placa_v;
    }
}
