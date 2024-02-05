
package Modelo;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int estado; //1-activo, 2-inactivo

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Producto() {
    }

    public Producto(int id, String nombre, float precio, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
