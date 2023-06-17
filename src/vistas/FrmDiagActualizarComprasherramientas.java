package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import modelo.AdminComprasherramientasDB;
import modelo.AdminHerramientasDB;
import modelo.AdminProveedoresDB;
import modelo.Herramientas;
import modelo.ItemCmbHerramientas;
import modelo.ItemCmbProveedores;
import modelo.Proveedores;
import modelo.Comprasherramientas;

public class FrmDiagActualizarComprasherramientas extends javax.swing.JDialog {

    AdminComprasherramientasDB objAdmComDB = new AdminComprasherramientasDB();
    private int idch;

    public FrmDiagActualizarComprasherramientas(java.awt.Frame parent, boolean modal, int idch) {
        super(parent, modal);
        initComponents();
        this.idch = idch;
        this.cargarCompras(idch);
    }

    private void cargarCompras(int idveh) {
        Comprasherramientas objCompras = new Comprasherramientas();
        objCompras.setIdch(idveh);

        objCompras = (Comprasherramientas) objAdmComDB.listarUno(objCompras);

        LocalDate fechaCompras = objCompras.getFecha_ch();
        this.jDateFechaCompra.setDate(java.sql.Date.valueOf(fechaCompras));
        this.txtValor.setText(String.valueOf(objCompras.getValor_ch()));
        this.txtIva.setText(String.valueOf(objCompras.getIva_ch()));

        AdminProveedoresDB objAdmPro = new AdminProveedoresDB();

        ItemCmbProveedores itemSeleccionado = new ItemCmbProveedores();
        for (Object obj : objAdmPro.listarTodo()) {
            Proveedores objProveedores = new Proveedores();
            objProveedores = (Proveedores) obj;

            ItemCmbProveedores objItem = new ItemCmbProveedores();
            objItem.setIdprov(objProveedores.getIdprov());
            objItem.setNombre_prov(objProveedores.getNombre_prov());

            this.cmbProveedores.addItem(objItem);

            if (objCompras.getProveedores_idprov() == objProveedores.getIdprov()) {
                itemSeleccionado = objItem;
            }
        }

        this.cmbProveedores.setSelectedItem(itemSeleccionado);

        AdminHerramientasDB objAdmCliente = new AdminHerramientasDB();

        ItemCmbHerramientas itemSeleccionado2 = new ItemCmbHerramientas();
        for (Object obj : objAdmCliente.listarTodo()) {
            Herramientas objHerramientas = new Herramientas();
            objHerramientas = (Herramientas) obj;

            ItemCmbHerramientas objItem = new ItemCmbHerramientas();
            objItem.setIdh(objHerramientas.getIdh());
            objItem.setNombre_h(objHerramientas.getNombre_h());

            this.cmbHerramientas.addItem(objItem);

            if (objCompras.getHerramientas_idh() == objHerramientas.getIdh()) {
                itemSeleccionado2 = objItem;
            }
        }

        this.cmbHerramientas.setSelectedItem(itemSeleccionado2);
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
        cmbHerramientas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbProveedores = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDateFechaCompra = new com.toedter.calendar.JDateChooser();
        txtIva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(206, 237, 237));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Actualizar Compras Herramienta");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btnAceptar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Valor:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        jPanel2.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("fecha:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jPanel2.add(cmbHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Herramienta:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jPanel2.add(cmbProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Proveedores:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));
        jPanel2.add(jDateFechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        jPanel2.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Iva:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        int valor = Integer.parseInt(this.txtValor.getText());
        LocalDate fecha = this.jDateFechaCompra.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        float iva = Float.parseFloat(this.txtIva.getText());

        ItemCmbProveedores objItem = (ItemCmbProveedores) this.cmbProveedores.getSelectedItem();
        int idProv = objItem.getIdprov();

        ItemCmbHerramientas objItem2 = (ItemCmbHerramientas) this.cmbHerramientas.getSelectedItem();
        int idH = objItem2.getIdh();

        AdminComprasherramientasDB objAdmCHDB = new AdminComprasherramientasDB();
        Comprasherramientas objComprasH = new Comprasherramientas();
        
        objComprasH.setIdch(this.idch);
        objAdmCHDB.listarUno(objComprasH);

        objComprasH.setValor_ch(valor);
        objComprasH.setFecha_ch(fecha);
        objComprasH.setIva_ch(iva);
        objComprasH.setProveedores_idprov(idProv);
        objComprasH.setHerramientas_idh(idH);

        objAdmCHDB.actualizar(objComprasH);

        this.dispose();
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbHerramientas> cmbHerramientas;
    private javax.swing.JComboBox<ItemCmbProveedores> cmbProveedores;
    private com.toedter.calendar.JDateChooser jDateFechaCompra;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
