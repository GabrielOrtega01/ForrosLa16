package vistas;

import modelo.AdminEmpleadosDB;
import modelo.AdminUsuarioDB;
import modelo.Usuario;
import modelo.ItemCmbEmpleados;
import modelo.Empleados;

public class FrmDiagActualizarUsuario extends javax.swing.JDialog {

    AdminUsuarioDB objAdmUsuDB = new AdminUsuarioDB();
    private int idu;

    public FrmDiagActualizarUsuario(java.awt.Frame parent, boolean modal, int idu) {
        super(parent, modal);
        initComponents();
        this.idu = idu;
        this.cargarUsuario(idu);
    }

    private void cargarUsuario(int idmeq) {
        Usuario objUsuario = new Usuario();
        objUsuario.setIdu(idmeq);

        objUsuario = (Usuario) objAdmUsuDB.listarUno(objUsuario);

        this.txtClave.setText(objUsuario.getClave_u());

        AdminEmpleadosDB objAdmServicio = new AdminEmpleadosDB();

        ItemCmbEmpleados itemSeleccionado = new ItemCmbEmpleados();
        for (Object obj : objAdmServicio.listarTodo()) {
            Empleados objEmpleados = new Empleados();
            objEmpleados = (Empleados) obj;

            ItemCmbEmpleados objItem = new ItemCmbEmpleados();
            objItem.setIde(objEmpleados.getIde());
            objItem.setCc_e(objEmpleados.getCc_e());

            this.cmbEmpleados.addItem(objItem);

            if (objUsuario.getEmpleados_ide() == objEmpleados.getIde()) {
                itemSeleccionado = objItem;
            }
        }

        this.cmbEmpleados.setSelectedItem(itemSeleccionado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbEmpleados = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Clave:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Empleado:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPanel1.add(cmbEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String clave = this.txtClave.getText();

        ItemCmbEmpleados objItem = (ItemCmbEmpleados) this.cmbEmpleados.getSelectedItem();
        int idser = objItem.getIde();

        AdminUsuarioDB objAdmCliDB = new AdminUsuarioDB();
        Usuario objUsuario = new Usuario();
        
        objUsuario.setIdu(this.idu);
        objAdmCliDB.listarUno(objUsuario);

        objUsuario.setClave_u(clave);
        objUsuario.setEmpleados_ide(idser);

        objAdmCliDB.actualizar(objUsuario);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbEmpleados> cmbEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtClave;
    // End of variables declaration//GEN-END:variables
}
