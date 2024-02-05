
package Dto;

public class DtoFacturas {
    private int idFactura;
    private String fecha;
    private String cliente;

    public DtoFacturas() {
    }

    public DtoFacturas(int idFactura, String fecha, String cliente) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "DtoFacturas{" + "idFactura=" + idFactura + ", fecha=" + fecha + ", cliente=" + cliente + '}';
    }
    
    
}
