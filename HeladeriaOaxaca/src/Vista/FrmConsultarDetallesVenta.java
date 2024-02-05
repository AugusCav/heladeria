
package Vista;

import Controlador.ControladorVenta;
import Dto.DtoDetalles;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrmConsultarDetallesVenta extends javax.swing.JFrame {
    
    int idVenta;
    DefaultTableModel model = new DefaultTableModel();
    ControladorVenta controller = new ControladorVenta();
    public FrmConsultarDetallesVenta(int id) {
        initComponents();
        idVenta = id;
        cargarTabla();
    }
    
    private void cargarTabla(){
        ArrayList<DtoDetalles> list = controller.getDetallePorVenta(idVenta);
        model.setColumnIdentifiers(new String[]{"idFactura", "Producto", "Cantidad", "Subtotal"});
        for (DtoDetalles dto : list) {
            model.addRow(new Object[]{dto.getIdFactura(), dto.getProducto(), dto.getCantidad(), dto.getSubtotal()});
        }
        tblDetalles.setModel(model);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDetalles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalles;
    // End of variables declaration//GEN-END:variables
}
