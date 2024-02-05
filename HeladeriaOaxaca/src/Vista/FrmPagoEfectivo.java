
package Vista;

import Controlador.ControladorVenta;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.Producto;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmPagoEfectivo extends javax.swing.JFrame {

    ControladorVenta controllerVenta = new ControladorVenta();
    Factura nuevaFactura;
    DefaultTableModel model;
    JComboBox clientes;
    JTextField cantidad;
    JTable tblDetalles;
    float totalFactura;
    public FrmPagoEfectivo(Factura f, float total, DefaultTableModel m, JComboBox c, JTextField cant, JTable d) {
        initComponents();
        nuevaFactura = f;
        txtMontoTotal.setText(String.valueOf(total));
        txtMontoTotal.setEnabled(false);
        txtVuelto.setEnabled(false);
        model = m;
        clientes = c;
        cantidad = cant; 
        tblDetalles = d;
        totalFactura = total;
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtMontoTotal = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        txtVuelto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Monto Total");

        jLabel2.setText("Efectivo");

        jLabel3.setText("Vuelto");

        jButton1.setText("CONFIRMAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 114, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (controllerVenta.RegistrarFactura(nuevaFactura)) {
                JOptionPane.showMessageDialog(null, "Se ha registrado la venta");
                try {
                    generarFactura();
                } catch (DocumentException ex) {
                    Logger.getLogger(FrmPagoEfectivo.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.setRowCount(0);
                clientes.setSelectedIndex(-1);
                cantidad.setText("");
                this.hide();
            }  else{
                 JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmVenta.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void calcularVuelto(){
        float total = Float.parseFloat(txtMontoTotal.getText());
        float eft = Float.parseFloat(txtEfectivo.getText());
        float vuelto = eft - total;
        
        txtVuelto.setText(String.valueOf(vuelto));
    }
    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtEfectivoKeyTyped

    private void txtEfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyPressed

    }//GEN-LAST:event_txtEfectivoKeyPressed

    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased
        calcularVuelto();
    }//GEN-LAST:event_txtEfectivoKeyReleased
    private void generarFactura() throws DocumentException{
        
        String path = "/";
        JFileChooser j= new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x =j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path=j.getSelectedFile().getPath();
        }
        
        Document doc = new Document();
           
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"/factura.pdf"));
            doc.open();
            doc.add(new Paragraph("Fecha: " + nuevaFactura.getFecha(),
            FontFactory.getFont("arial",22)));
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("Producto");
            tbl.addCell("Precio");
            tbl.addCell("Cantidad");
            tbl.addCell("Subtotal");
            tbl.setSpacingAfter(20);
            tbl.setSpacingBefore(10);
            for (int i=0; i<tblDetalles.getRowCount(); i++) {              
                Producto producto = (Producto) tblDetalles.getValueAt(i,1);
                String descripcion = producto.getNombre();
                String precio = tblDetalles.getValueAt(i,2).toString();
                String cantidad = tblDetalles.getValueAt(i,3).toString();
                String subtotal =  tblDetalles.getValueAt(i,4).toString();
                
                tbl.addCell(descripcion);
                tbl.addCell(precio);
                tbl.addCell(cantidad);
                tbl.addCell(subtotal);
            }
            doc.add(tbl);
            doc.add(new Paragraph("Total a pagar: "+ "$ " +totalFactura,FontFactory.getFont("arial",30)));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPagoEfectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
        
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JTextField txtVuelto;
    // End of variables declaration//GEN-END:variables
}
