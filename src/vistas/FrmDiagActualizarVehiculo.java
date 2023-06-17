package vistas;

import modelo.AdminVehiculoDB;
import modelo.AdminClientesDB;
import modelo.ItemCmbClientes;
import modelo.Vehiculo;
import modelo.Clientes;

public class FrmDiagActualizarVehiculo extends javax.swing.JDialog {

    AdminVehiculoDB objAdmVehDB = new AdminVehiculoDB();
    private int idv;

    public FrmDiagActualizarVehiculo(java.awt.Frame parent, boolean modal, int idv) {
        super(parent, modal);
        initComponents();
        this.idv = idv;
        this.cargarVehiculo(idv);
    }

    private void cargarVehiculo(int idveh) {
        Vehiculo objVehiculo = new Vehiculo();
        objVehiculo.setIdv(idveh);

        objVehiculo = (Vehiculo) objAdmVehDB.listarUno(objVehiculo);

        this.txtMarca.setText(objVehiculo.getMarca_v());
        this.txtColor.setText(objVehiculo.getColor_v());
        this.txtPlaca.setText(objVehiculo.getPlaca_v());

        AdminClientesDB objAdmCliente = new AdminClientesDB();

        ItemCmbClientes itemSeleccionado = new ItemCmbClientes();
        for (Object obj : objAdmCliente.listarTodo()) {
            Clientes objCliente = new Clientes();
            objCliente = (Clientes) obj;

            ItemCmbClientes objItem = new ItemCmbClientes();
            objItem.setIdc(objCliente.getIdc());
            objItem.setCc_c(objCliente.getCc_c());

            this.cmbClientes.addItem(objItem);

            if (objVehiculo.getClientes_idc() == objCliente.getIdc()) {
                itemSeleccionado = objItem;
            }
        }

        this.cmbClientes.setSelectedItem(itemSeleccionado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Vehículo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Clientes:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jPanel1.add(cmbClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Color:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });
        jPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Placa:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String marca = this.txtMarca.getText();
        String color = this.txtColor.getText();
        String placa = this.txtPlaca.getText();

        ItemCmbClientes objItem = (ItemCmbClientes) this.cmbClientes.getSelectedItem();
        int idcli = objItem.getIdc();

        AdminVehiculoDB objAdmCliDB = new AdminVehiculoDB();
        Vehiculo objVehiculo = new Vehiculo();

        objVehiculo.setIdv(this.idv);
        objAdmCliDB.listarUno(objVehiculo);

        objVehiculo.setMarca_v(marca);
        objVehiculo.setColor_v(color);
        objVehiculo.setPlaca_v(placa);
        objVehiculo.setClientes_idc(idcli);

        objAdmCliDB.actualizar(objVehiculo);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbClientes> cmbClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
