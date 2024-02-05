
package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private int id;
    private String fecha;
    private Cliente cliente;
    private Usuario cajero;
    private ArrayList<DetalleFactura> detalles;
    private String medioDePago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getCajero() {
        return cajero;
    }

    public void setCajero(Usuario cajero) {
        this.cajero = cajero;
    }

    public ArrayList<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Factura() {
    }

    public Factura(int id, String fecha, Cliente cliente, Usuario cajero, ArrayList<DetalleFactura> detalles) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cajero = cajero;
        this.detalles = detalles;
    }
    
    public Factura(int id, String fecha, Cliente cliente, Usuario cajero, ArrayList<DetalleFactura> detalles, String medioDePago) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cajero = cajero;
        this.detalles = detalles;
        this.medioDePago=medioDePago;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", cajero=" + cajero + ", detalles=" + detalles + '}';
    }
    
    
}
