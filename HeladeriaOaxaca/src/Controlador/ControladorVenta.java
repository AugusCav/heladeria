
package Controlador;
import Dto.DtoDetalles;
import Dto.DtoFacturas;
import Modelo.DetalleFactura;
import Modelo.Factura;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorVenta {

    String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Heladeria;TrustServerCertificate=True";
    String usuario = "";
    String contrasena = "";
    
    public int generarNroFactura(){
        int nro = 0;
         try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery("select MAX(id_factura)+1 FROM Facturas");) {
            
             rs.next();
             nro = rs.getInt(1);
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nro;
    }
     public boolean RegistrarFactura(Factura oFactura) throws SQLException{
        boolean flag = false;
        Connection cnn = null;
        try{
            cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            cnn.setAutoCommit(false);
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO Facturas (id_factura, fecha, id_cliente, id_usuario, medio_de_pago) VALUES(?,?,?,?,?)");
            ps.setInt(1, oFactura.getId());
            ps.setString(2, oFactura.getFecha());
            if ( oFactura.getCliente() != null) {
                ps.setInt(3, oFactura.getCliente().getId());
            } else{
                 ps.setNull(3, java.sql.Types.NULL);
            }
            ps.setInt(4, oFactura.getCajero().getId());
            ps.setString(5, oFactura.getMedioDePago());
            ps.execute();
            ps.close();
           
            for (DetalleFactura detalle : oFactura.getDetalles()) {
                PreparedStatement ps2 = cnn.prepareStatement("INSERT INTO Detalles_Factura (id_factura, id_producto, precio, cantidad) VALUES(?,?,?,?)");
                ps2.setInt(1, oFactura.getId());
                ps2.setInt(2, detalle.getProducto().getId());
                ps2.setFloat(3, detalle.getPrecio());
                ps2.setInt(4, detalle.getCantidad());
                
                ps2.execute();
            }                    
            cnn.commit();
            flag = true;
        } catch (SQLException ex) {
            cnn.rollback();
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return flag;
    }
     
    public ArrayList<DtoFacturas> getVentas(){
        ArrayList<DtoFacturas> list = new ArrayList<>();
         try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
             Statement st = cnn.createStatement();
             ResultSet rs = st.executeQuery("select id_factura, fecha, CONCAT(nombre, ' ', apellido) as Cliente\n" +
"from Facturas f left join Clientes c on f.id_cliente = c.id_cliente order by fecha desc ");) {
            
             while(rs.next()){
                 int id = rs.getInt("id_factura");
                 String fecha = rs.getString("fecha");
                 String cliente = rs.getString("Cliente");
                 
                 DtoFacturas d = new DtoFacturas(id, fecha, cliente);
                 list.add(d);
             }
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public ArrayList<DtoDetalles> getDetallePorVenta(int id){
        ArrayList<DtoDetalles> list = new ArrayList<>();
         try(Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
             Statement st = cnn.createStatement();
             ResultSet rs = st.executeQuery("select id_factura, p.nombre as Producto, cantidad, d.precio*cantidad 'Subtotal'\n" +
                                            "from Detalles_Factura d join Productos p on d.id_producto = p.id_producto\n" +
                                            "where id_factura =" + id);) {
            
             while(rs.next()){
                 int idF = rs.getInt("id_factura");
                 String producto = rs.getString("Producto");
                 int cantidad = rs.getInt("cantidad");
                 float subtotal = rs.getFloat("Subtotal");
                 
                 DtoDetalles d = new DtoDetalles(idF,producto, cantidad, subtotal);
                 list.add(d);
             }
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public boolean DeleteFactura(int id) throws SQLException{
        boolean flag = false;
        Connection cnn = null;
        try{
            cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
            cnn.setAutoCommit(false);
            PreparedStatement ps = cnn.prepareStatement("delete Detalles_Factura where id_factura = ?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
           
            PreparedStatement ps2 = cnn.prepareStatement("delete Facturas where id_factura = ?");
            ps2.setInt(1, id);
            ps2.execute();
            cnn.commit();
            cnn.close();
            flag = true;
        } catch (SQLException ex) {
            cnn.rollback();
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return flag;
    }
}
