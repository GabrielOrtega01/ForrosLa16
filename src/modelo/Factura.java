package modelo;

import java.time.LocalDate;

public class Factura {

    private int idf;
    private String admin;
    private LocalDate fecha_f;
    private int movimiento_idmov;

    public Factura() {
        this.idf = 0;
        this.admin = "";
        this.fecha_f = LocalDate.parse("1900-01-01");
        this.movimiento_idmov = 0;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public LocalDate getFecha_f() {
        return fecha_f;
    }

    public void setFecha_f(LocalDate fecha_f) {
        this.fecha_f = fecha_f;
    }

    public int getMovimiento_idmov() {
        return movimiento_idmov;
    }

    public void setMovimiento_idmov(int movimiento_idmov) {
        this.movimiento_idmov = movimiento_idmov;
    }

    @Override
    public String toString() {
        return "Factura{" + "idf=" + idf + ", admin=" + admin + ", fecha_f=" + fecha_f + ", movimiento_idmov=" + movimiento_idmov + '}';
    }

}
