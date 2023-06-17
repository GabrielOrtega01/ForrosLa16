package vistas;

import modelo.AdminFacturaDB;
import modelo.Factura;
import java.time.LocalDate;
import java.time.ZoneId;
import modelo.AdminMovimientoDB;
import modelo.ItemCmbMovimiento;
import modelo.Movimiento;

public class FrmDiagActualizarFactura extends javax.swing.JDialog {

    AdminFacturaDB objAdmVenDB = new AdminFacturaDB();
    private int idf;

    public FrmDiagActualizarFactura(java.awt.Frame parent, boolean modal, int idf) {
        super(parent, modal);
        initComponents();
        this.idf = idf;
        this.cargarFactura(idf);
    }

    private void cargarFactura(int idven) {
        Factura objFactura = new Factura();
        objFactura.setIdf(idven);

        objFactura = (Factura) objAdmVenDB.listarUno(objFactura);

        LocalDate fechaFactura = objFactura.getFecha_f();
        this.jDateFechaFactura.setDate(java.sql.Date.valueOf(fechaFactura));
        this.txtAdmin.setText(objFactura.getAdmin());

        AdminMovimientoDB objAdmPer = new AdminMovimientoDB();

        ItemCmbMovimiento itemSeleccionado = new ItemCmbMovimiento();
        for (Object obj : objAdmPer.listarTodo()) {
            Movimiento objMovimiento = new Movimiento();
            objMovimiento = (Movimiento) obj;

            ItemCmbMovimiento objItem = new ItemCmbMovimiento();
            objItem.setIdm(objMovimiento.getIdmov());
            objItem.setIdm(objMovimiento.getIdmov());

            this.cmbMovimiento.addItem(objItem);

            if (objFactura.getMovimiento_idmov() == objMovimiento.getIdmov()) {
                itemSeleccionado = objItem;
            }
        }
        this.cmbMovimiento.setSelectedItem(itemSeleccionado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtAdmin = new javax.swing.JTextField();
        cmbMovimiento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateFechaFactura = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Factura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 40, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Admin:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txtAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminActionPerformed(evt);
            }
        });
        jPanel1.add(txtAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 150, -1));

        jPanel1.add(cmbMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Movimiento:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Fecha:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        jPanel1.add(jDateFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String admin = this.txtAdmin.getText();
        LocalDate fecha = this.jDateFechaFactura.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        ItemCmbMovimiento objItem = (ItemCmbMovimiento) this.cmbMovimiento.getSelectedItem();
        int idMov = objItem.getIdm();

        AdminFacturaDB objAdmMovDB = new AdminFacturaDB();
        Factura objVenta = new Factura();

        objVenta.setIdf(this.idf);
        objAdmMovDB.listarUno(objVenta);

        objVenta.setAdmin(admin);
        objVenta.setFecha_f(fecha);
        objVenta.setMovimiento_idmov(idMov);

        objAdmMovDB.actualizar(objVenta);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbMovimiento> cmbMovimiento;
    private com.toedter.calendar.JDateChooser jDateFechaFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAdmin;
    // End of variables declaration//GEN-END:variables
}
