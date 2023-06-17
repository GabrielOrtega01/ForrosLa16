package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import modelo.AdminComprasproductosDB;
import modelo.AdminProductosDB;
import modelo.AdminProveedoresDB;
import modelo.Productos;
import modelo.ItemCmbProductos;
import modelo.ItemCmbProveedores;
import modelo.Proveedores;
import modelo.Comprasproductos;

public class FrmDiagActualizarComprasproductos extends javax.swing.JDialog {

    AdminComprasproductosDB objAdmComDB = new AdminComprasproductosDB();
    private int idcp;

    public FrmDiagActualizarComprasproductos(java.awt.Frame parent, boolean modal, int idcp) {
        super(parent, modal);
        initComponents();
        this.idcp = idcp;
        this.cargarCompras(idcp);
    }

    private void cargarCompras(int idveh) {
        Comprasproductos objCompras = new Comprasproductos();
        objCompras.setIdcp(idveh);

        objCompras = (Comprasproductos) objAdmComDB.listarUno(objCompras);

        LocalDate fechaCompras = objCompras.getFecha_cp();
        this.jDateFechaCompra.setDate(java.sql.Date.valueOf(fechaCompras));
        this.txtValor.setText(String.valueOf(objCompras.getValor_cp()));
        this.txtCantidad.setText(String.valueOf(objCompras.getCantidad_cp()));
        this.txtIva.setText(String.valueOf(objCompras.getIva_cp()));

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

        AdminProductosDB objAdmCliente = new AdminProductosDB();

        ItemCmbProductos itemSeleccionado2 = new ItemCmbProductos();
        for (Object obj : objAdmCliente.listarTodo()) {
            Productos objProductos = new Productos();
            objProductos = (Productos) obj;

            ItemCmbProductos objItem = new ItemCmbProductos();
            objItem.setIdprod(objProductos.getIdprod());
            objItem.setNombre_prod(objProductos.getNombre_prod());

            this.cmbProductos.addItem(objItem);

            if (objCompras.getProductos_idprod() == objProductos.getIdprod()) {
                itemSeleccionado2 = objItem;
            }
        }

        this.cmbProductos.setSelectedItem(itemSeleccionado2);
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
        jLabel8 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(206, 237, 237));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Actualizar Compras Productos");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        btnAceptar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Valor:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        jPanel2.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 213, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("fecha:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPanel2.add(cmbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Productos:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jPanel2.add(cmbProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Proveedores:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        jPanel2.add(jDateFechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 215, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 213, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Iva:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 30, -1));

        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        jPanel2.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed

        int valor = Integer.parseInt(this.txtValor.getText());
        LocalDate fecha = this.jDateFechaCompra.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int cantidad = Integer.parseInt(this.txtCantidad.getText());
        float iva = Float.parseFloat(this.txtIva.getText());

        ItemCmbProveedores objItem = (ItemCmbProveedores) this.cmbProveedores.getSelectedItem();
        int idProv = objItem.getIdprov();

        ItemCmbProductos objItem2 = (ItemCmbProductos) this.cmbProductos.getSelectedItem();
        int idP = objItem2.getIdprod();

        AdminComprasproductosDB objAdmMovDB = new AdminComprasproductosDB();
        Comprasproductos objCompras = new Comprasproductos();
        
        objCompras.setIdcp(this.idcp);
        objAdmMovDB.listarUno(objCompras);

        objCompras.setValor_cp(valor);
        objCompras.setFecha_cp(fecha);
        objCompras.setCantidad_cp(cantidad);
        objCompras.setIva_cp(iva);
        objCompras.setProveedores_idprov(idProv);
        objCompras.setProductos_idprod(idP);
        

        objAdmMovDB.actualizar(objCompras);

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
