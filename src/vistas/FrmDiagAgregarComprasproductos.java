package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import modelo.AdminProductosDB;
import modelo.AdminProveedoresDB;
import modelo.AdminComprasproductosDB;
import modelo.Productos;
import modelo.ItemCmbProductos;
import modelo.ItemCmbProveedores;
import modelo.Proveedores;
import modelo.Comprasproductos;

public class FrmDiagAgregarComprasproductos extends javax.swing.JDialog {

    public FrmDiagAgregarComprasproductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cargarProductos();
    }

    private void cargarProductos() {

        AdminProveedoresDB objAdmPer = new AdminProveedoresDB();
        AdminProductosDB objAdmCli = new AdminProductosDB();

        for (Object obj : objAdmPer.listarTodo()) {
            Proveedores objProveedores = new Proveedores();
            objProveedores = (Proveedores) obj;

            ItemCmbProveedores objItem = new ItemCmbProveedores();
            objItem.setIdprov(objProveedores.getIdprov());
            objItem.setNombre_prov(objProveedores.getNombre_prov());

            this.cmbProveedores.addItem(objItem);

        }

        for (Object obj : objAdmCli.listarTodo()) {
            Productos objProductos = new Productos();
            objProductos = (Productos) obj;

            ItemCmbProductos objItem = new ItemCmbProductos();
            objItem.setIdprod(objProductos.getIdprod());
            objItem.setNombre_prod(objProductos.getNombre_prod());

            this.cmbProductos.addItem(objItem);

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbProveedores = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDateFechaCompra = new com.toedter.calendar.JDateChooser();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(206, 237, 237));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Agregar Compras Productos");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        btnAceptar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Valor:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        jPanel2.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 180, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Fecha:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jPanel2.add(cmbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Productos:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jPanel2.add(cmbProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 180, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Proveedores:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel2.add(jDateFechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        jPanel2.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Iva:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 30, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPersonaActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed

        int valor = Integer.parseInt(this.txtValor.getText());
        LocalDate fecha = this.jDateFechaCompra.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int cantidad = Integer.parseInt(this.txtCantidad.getText());
        float iva = Float.parseFloat(this.txtIva.getText());

        ItemCmbProveedores objItem = (ItemCmbProveedores) this.cmbProveedores.getSelectedItem();
        int idProv = objItem.getIdprov();

        ItemCmbProductos objItem3 = (ItemCmbProductos) this.cmbProductos.getSelectedItem();
        int idProd = objItem3.getIdprod();

        AdminComprasproductosDB objAdmMovDB = new AdminComprasproductosDB();
        Comprasproductos objCompras = new Comprasproductos();

        objCompras.setValor_cp(valor);
        objCompras.setFecha_cp(fecha);
        objCompras.setCantidad_cp(cantidad);
        objCompras.setIva_cp(iva);
        objCompras.setProveedores_idprov(idProv);
        objCompras.setProductos_idprod(idProd);

        objAdmMovDB.insertar(objCompras);

        this.dispose();
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarComprasproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarComprasproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarComprasproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarComprasproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDiagAgregarComprasproductos dialog = new FrmDiagAgregarComprasproductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbProductos> cmbProductos;
    private javax.swing.JComboBox<ItemCmbProveedores> cmbProveedores;
    private com.toedter.calendar.JDateChooser jDateFechaCompra;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
