package Vista;

import Vista.FrmPagoEfectivo;
import Controlador.ControladorCliente;
import Controlador.ControladorProducto;
import Controlador.ControladorVenta;
import Modelo.Usuario;
import Modelo.Cliente;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.Producto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrmVenta extends javax.swing.JFrame {

    ControladorProducto controllerProducto = new ControladorProducto();
    ControladorCliente controllerCliente = new ControladorCliente();
    ControladorVenta controllerVenta = new ControladorVenta();
    DefaultTableModel modelTable = new DefaultTableModel();
    ArrayList<DetalleFactura> detalles = new ArrayList<>();
    Factura facturaNueva;
    DefaultComboBoxModel modelCliente = new DefaultComboBoxModel();
    DefaultComboBoxModel modelProducto = new DefaultComboBoxModel();

    public FrmVenta(Usuario user) {
        initComponents();
        txtFecha.setText(LocalDate.now().toString());
        txtFecha.setEnabled(false);
        facturaNueva = new Factura();
        facturaNueva.setCajero(user);
        cargarCombos();
        configurarTabla();
        autoCompletar();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        cboClientes.setSelectedIndex(-1);
    }

    ;

    public FrmVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void configurarTabla() {
        modelTable.setColumnIdentifiers(new String[]{"Id", "Producto", "Precio", "Cantidad", "Subtotal"});
        tblDetalles.setModel(modelTable);
    }

    private void cargarCombos() {
        ArrayList<Producto> listProductos = controllerProducto.getProductos();
        ArrayList<Cliente> listClientes = controllerCliente.getClientes();

        for (Cliente c : listClientes) {
            modelCliente.addElement(c);
        }
        for (Producto p : listProductos) {
            modelProducto.addElement(p);
        }
        cboClientes.setModel(modelCliente);
        cboProductos.setModel(modelProducto);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cboClientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalles = new javax.swing.JTable();
        txtFecha = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        btnEfectivo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnFrmClientes = new javax.swing.JButton();
        btnConsultarVentas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnPagoTarjeta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Producto");

        cboProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad");

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cboClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Fecha");

        tblDetalles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText("Importe Total");

        btnEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEfectivo.setText("Efectivo");
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });

        jButton1.setText("Productos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFrmClientes.setText("Clientes");
        btnFrmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrmClientesActionPerformed(evt);
            }
        });

        btnConsultarVentas.setText("Ventas");
        btnConsultarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarVentasActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Quitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnPagoTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPagoTarjeta.setText("Tarjeta");
        btnPagoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoTarjetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFrmClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addComponent(btnConsultarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPagoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(58, 58, 58)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnFrmClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnConsultarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad");
            return;
        }
        Producto p = (Producto) cboProductos.getSelectedItem();
        int id = p.getId();
        float precio = p.getPrecio();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        float subtotal = (precio * cantidad);

        DetalleFactura d = new DetalleFactura(0, p, precio, cantidad);

        modelTable.addRow(new Object[]{id, d.getProducto(), d.getPrecio(), d.getCantidad(), subtotal});
        detalles.add(d);
        CalcularTotal();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        if (validarCampos()) {
            facturaNueva.setDetalles(detalles);
            String fecha = txtFecha.getText();
            Cliente c = (Cliente) cboClientes.getSelectedItem();
            facturaNueva.setFecha(fecha);
            facturaNueva.setCliente(c);
            facturaNueva.setDetalles(detalles);
            facturaNueva.setId(controllerVenta.generarNroFactura());

            float total = CalcularTotal();
            FrmPagoEfectivo frm = new FrmPagoEfectivo(facturaNueva, total, modelTable, cboClientes, txtCantidad, tblDetalles);
            frm.setVisible(true);
        }

    }//GEN-LAST:event_btnEfectivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmProductos frm = new FrmProductos();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFrmClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrmClientesActionPerformed
        FrmConsultarClientes frm = new FrmConsultarClientes(modelCliente, cboClientes);
        frm.setVisible(true);
    }//GEN-LAST:event_btnFrmClientesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tblDetalles.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un detalle");
        } else {
            modelTable.removeRow(row);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnConsultarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarVentasActionPerformed
        ConsultarVentas frm = new ConsultarVentas();
        frm.setVisible(true);
    }//GEN-LAST:event_btnConsultarVentasActionPerformed

    private void btnPagoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoTarjetaActionPerformed
        // TODO add your handling code here:
        if (validarCampos()) {
            facturaNueva.setDetalles(detalles);
            String fecha = txtFecha.getText();
            Cliente c = (Cliente) cboClientes.getSelectedItem();
            facturaNueva.setFecha(fecha);
            facturaNueva.setCliente(c);
            facturaNueva.setDetalles(detalles);
            facturaNueva.setId(controllerVenta.generarNroFactura());


            float total = CalcularTotal();
           

            try {
                FrmPagoTarjeta frm = new FrmPagoTarjeta(facturaNueva, total, modelTable, cboClientes, txtCantidad, tblDetalles);
                frm.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnPagoTarjetaActionPerformed

    private float CalcularTotal() {
        float total = 0;
        for (DetalleFactura detalle : detalles) {
            total += detalle.getPrecio() * detalle.getCantidad();
        }
        lblTotal.setText("Importe total $ " + " " + total);
        return total;
    }

    private void autoCompletar() {
        AutoCompleteDecorator.decorate(cboProductos);
        AutoCompleteDecorator.decorate(cboClientes);
    }

    private boolean validarCampos() {
        if (tblDetalles.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione al menos un producto");
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultarVentas;
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnFrmClientes;
    private javax.swing.JButton btnPagoTarjeta;
    private javax.swing.JComboBox<String> cboClientes;
    private javax.swing.JComboBox<String> cboProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblDetalles;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
