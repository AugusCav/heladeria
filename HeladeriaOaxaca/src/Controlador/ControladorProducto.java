
package Controlador;
import Modelo.Producto;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
public class ControladorProducto {

    String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Heladeria;TrustServerCertificate=True";
    String usuario = "";
    String contrasena = "";
    
     public boolean RegistrarProducto(Producto oProducto){
        boolean flag = false;
        
        try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO Productos (nombre, precio, estado) VALUES(?,?,?)");) {
            ps.setString(1, oProducto.getNombre());
            ps.setFloat(2, oProducto.getPrecio());
            ps.setInt(3, 1);
            ps.execute();
            flag = true;
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> list = new ArrayList<>();
        try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Productos")    ) {
            while(rs.next()){
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                int estado = rs.getInt("estado");
                
                Producto p = new Producto(id, nombre, precio, estado);
                list.add(p);
            }
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
