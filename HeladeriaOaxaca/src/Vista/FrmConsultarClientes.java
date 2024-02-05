
package Vista;

import Controlador.ControladorCliente;
import Modelo.Cliente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrmConsultarClientes extends javax.swing.JFrame {
    DefaultComboBoxModel modelCliente;
    ControladorCliente controller = new ControladorCliente();
    JComboBox combo;
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter trs;
    ControladorCliente controllerCliente = new ControladorCliente();  
    public FrmConsultarClientes(DefaultComboBoxModel m, JComboBox c ) {
        initComponents();
        cargarTabla();
        modelCliente = m;
        combo = c;
    }
     private void cargarTabla(){
        limpiarTabla();
        ArrayList<Cliente> productos = controller.getClientes();
        model.setColumnIdentifiers(new String[]{"#", "Nombre", "Apellido", "Email", "Teléfono", "DNI"});
        for (Cliente c : productos) {
            model.addRow(new Object[]{c.getId(),c.getNombre(),c.getApellido(), c.getEmail(), c.getTelefono(), c.getDni()});
        }
        tblClientes.setModel(model);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        btnGuardarCambios = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Filtrar por apellido");

        tblClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setMinWidth(5);
            tblClientes.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblClientes.getColumnModel().getColumn(0).setMaxWidth(5);
            tblClientes.getColumnModel().getColumn(1).setMinWidth(150);
            tblClientes.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblClientes.getColumnModel().getColumn(1).setMaxWidth(150);
            tblClientes.getColumnModel().getColumn(2).setMinWidth(150);
            tblClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblClientes.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNuevoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
          txtFiltro.addKeyListener(new KeyAdapter(){
           @Override
           public void keyReleased(final KeyEvent evt){
               trs.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), 2));
           }
           
       });
        trs = new TableRowSorter(model);
        tblClientes.setRowSorter(trs);
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        FrmAltaCliente frm = new FrmAltaCliente(model, combo, modelCliente);
        frm.setVisible(true);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void limpiarTabla(){
        DefaultTableModel modelos=(DefaultTableModel) tblClientes.getModel();
        modelos.setRowCount(0);
     }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row = tblClientes.getSelectedRow();
        int id = (int) tblClientes.getValueAt(row, 0);
        int result =JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el cliente?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            controller.eliminarCliente(id);
            cargarTabla();
        }
        modelCliente.removeElementAt(row);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        int row = tblClientes.getSelectedRow();
        int id = (int) tblClientes.getValueAt(row, 0);
        String nombre = (String) tblClientes.getValueAt(row, 1);
        String apellido = (String) tblClientes.getValueAt(row, 2);
        String email = (String) tblClientes.getValueAt(row, 3);
        String telefono = (String) tblClientes.getValueAt(row, 4);
        String dni = (String) tblClientes.getValueAt(row, 5);
        Cliente oCliente = new Cliente(id, nombre, apellido, email, telefono,1, dni);
        
         int result =JOptionPane.showConfirmDialog(null, "Guardar Cambio", "Actualizar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if(controller.EditarCliente(oCliente)){
                JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
                cargarTabla();
            }
        }
        modelCliente.removeAllElements();
        ArrayList<Cliente> listClientes = controllerCliente.getClientes();
        for (Cliente c : listClientes) {
            modelCliente.addElement(c);
        }
        
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
