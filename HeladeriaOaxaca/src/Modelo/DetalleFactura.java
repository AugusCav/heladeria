
package Modelo;

public class DetalleFactura {
    private int id;
    private Producto producto;
    private float precio;
    private int cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DetalleFactura() {
    }

    public DetalleFactura(int id, Producto producto, float precio, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "id=" + id + ", producto=" + producto + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
    
}
