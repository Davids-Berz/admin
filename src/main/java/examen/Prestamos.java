package examen;

public class Prestamos {

    private Integer id;
    private Integer cliente;
    private String fecha;
    private double monto;
    private String estado;
    private double pago;

    public Prestamos(Integer id, Integer cliente, String fecha, Double monto, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }


    public Integer getId() {
        return id;
    }

    public Integer getCliente() {
        return cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", fecha='" + fecha + '\'' +
                ", monto=" + monto +
                ", estado='" + estado + '\'' +
                ", pago=" + pago +
                '}';
    }
}
