
package Controlador;
import Modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorCliente {

    String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Heladeria;TrustServerCertificate=True";
    String usuario = "";
    String contrasena = "";
    
    public boolean RegistrarCliente(Cliente oCliente){
        boolean flag = false;
        try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO CLIENTES(dni, nombre, apellido, email, telefono, estado) VALUES(?,?,?,?,?,?)");) {
            ps.setString(1, oCliente.getDni());
            ps.setString(2, oCliente.getNombre());
            ps.setString(3, oCliente.getApellido());
            ps.setString(4, oCliente.getEmail());
            ps.setString(5, oCliente.getTelefono());
            ps.setInt(6, 1);
            ps.execute();
            flag = true;
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
     public int generarIdCliente(){
        int nro = 0;
         try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery("select COUNT(*)+1 FROM Clientes");) {
            
             rs.next();
             nro = rs.getInt(1);
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nro;
    }
    
    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> list = new ArrayList<>();
        try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Clientes WHERE estado = 1")    ) {
            while(rs.next()){
                int id = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int estado = rs.getInt("estado");
                String dni = rs.getString("dni");
                
                Cliente c = new Cliente(id, nombre, apellido, email, telefono, estado, dni);
                list.add(c);
            }
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean eliminarCliente(int id){
        boolean flag = false;
        try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            PreparedStatement st = cnn.prepareStatement("Update Clientes set estado = ? where id_cliente = ?");){
            st.setInt(1, 0);
            st.setInt(2, id);
            st.execute();
            flag = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
    public boolean EditarCliente(Cliente c){
        boolean flag = false;
        try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            PreparedStatement ps = cnn.prepareStatement("UPDATE CLIENTES SET dni=" + c.getDni() +",nombre='"+c.getNombre()+"',apellido='" + c.getApellido() +"', email ='" + c.getEmail()+"',telefono ='" + c.getTelefono() + "' WHERE id_cliente =" + c.getId());) {
           
            ps.execute();
            flag = true;
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
