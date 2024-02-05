
package Dto;

public class DtoDetalles {
    private int idFactura;
    private String producto;
    private int cantidad;
    private float subtotal;

    public DtoDetalles() {
    }

    public DtoDetalles(int idFactura, String producto, int cantidad, float subtotal) {
        this.idFactura = idFactura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DtoDetalles{" + "idFactura=" + idFactura + ", producto=" + producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }
    
}
