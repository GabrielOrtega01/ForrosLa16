package modelo;

public class ReporteDineroInvertido {

    private String producto;
    private String maquina;
    private String herramienta;
    private String proveedor;
    private int total;

    public ReporteDineroInvertido() {
        this.producto = "";
        this.maquina = "";
        this.herramienta = "";
        this.proveedor = "";
        this.total = 0;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ReporteDineroInvertido{" + "producto=" + producto + ", maquina=" + maquina + ", herramienta=" + herramienta + ", proveedor=" + proveedor + ", total=" + total + '}';
    }

}
