package vistas;

import modelo.AdminMovimientoDB;
import modelo.AdminEmpleadosDB;
import modelo.AdminProductosDB;
import modelo.AdminVehiculoDB;
import modelo.AdminServiciosDB;
import modelo.Empleados;
import modelo.ItemCmbEmpleados;
import modelo.ItemCmbProductos;
import modelo.ItemCmbVehiculo;
import modelo.ItemCmbServicios;
import modelo.Servicios;
import modelo.Movimiento;
import modelo.Productos;
import modelo.Vehiculo;

public class FrmDiagActualizarMovimiento extends javax.swing.JDialog {

    AdminMovimientoDB objAdmComDB = new AdminMovimientoDB();
    private int idmov;

    public FrmDiagActualizarMovimiento(java.awt.Frame parent, boolean modal, int idmov) {
        super(parent, modal);
        initComponents();
        this.idmov = idmov;
        this.cargarMovimiento(idmov);
    }

    private void cargarMovimiento(int idveh) {
        Movimiento objMovimiento = new Movimiento();
        objMovimiento.setIdmov(idveh);

        objMovimiento = (Movimiento) objAdmComDB.listarUno(objMovimiento);

        this.txtCantidad.setText(String.valueOf(objMovimiento.getCantidad_producto()));

        AdminServiciosDB objAdmS = new AdminServiciosDB();

        ItemCmbServicios itemSeleccionado = new ItemCmbServicios();
        for (Object obj : objAdmS.listarTodo()) {
            Servicios objServicios = new Servicios();
            objServicios = (Servicios) obj;

            ItemCmbServicios objItem = new ItemCmbServicios();
            objItem.setIds(objServicios.getIds());
            objItem.setNombre_s(objServicios.getNombre_s());

            this.cmbServicios.addItem(objItem);

            if (objMovimiento.getServicios_ids() == objServicios.getIds()) {
                itemSeleccionado = objItem;
            }
        }

        this.cmbServicios.setSelectedItem(itemSeleccionado);

        AdminEmpleadosDB objAdmEmpleados = new AdminEmpleadosDB();

        ItemCmbEmpleados itemSeleccionado2 = new ItemCmbEmpleados();
        for (Object obj : objAdmEmpleados.listarTodo()) {
            Empleados objEmpleados = new Empleados();
            objEmpleados = (Empleados) obj;

            ItemCmbEmpleados objItem = new ItemCmbEmpleados();
            objItem.setIde(objEmpleados.getIde());
            objItem.setCc_e(objEmpleados.getCc_e());

            this.cmbEmpleados.addItem(objItem);

            if (objMovimiento.getEmpleados_ide() == objEmpleados.getIde()) {
                itemSeleccionado2 = objItem;
            }
        }
        this.cmbEmpleados.setSelectedItem(itemSeleccionado2);

        AdminVehiculoDB objAdmPro = new AdminVehiculoDB();

        ItemCmbVehiculo itemSeleccionado3 = new ItemCmbVehiculo();
        for (Object obj : objAdmPro.listarTodo()) {
            Vehiculo objVehiculo = new Vehiculo();
            objVehiculo = (Vehiculo) obj;

            ItemCmbVehiculo objItem = new ItemCmbVehiculo();
            objItem.setIdv(objVehiculo.getIdv());
            objItem.setPlaca_v(objVehiculo.getPlaca_v());

            this.cmbVehiculo.addItem(objItem);

            if (objMovimiento.getVehiculo_idv() == objVehiculo.getIdv()) {
                itemSeleccionado3 = objItem;
            }
        }

        this.cmbVehiculo.setSelectedItem(itemSeleccionado3);

        AdminProductosDB objAdmCliente = new AdminProductosDB();

        ItemCmbProductos itemSeleccionado4 = new ItemCmbProductos();
        for (Object obj : objAdmCliente.listarTodo()) {
            Productos objProductos = new Productos();
            objProductos = (Productos) obj;

            ItemCmbProductos objItem = new ItemCmbProductos();
            objItem.setIdprod(objProductos.getIdprod());
            objItem.setNombre_prod(objProductos.getNombre_prod());

            this.cmbProductos.addItem(objItem);

            if (objMovimiento.getProductos_idprod() == objProductos.getIdprod()) {
                itemSeleccionado4 = objItem;
            }
        }

        this.cmbProductos.setSelectedItem(itemSeleccionado4);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbVehiculo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbServicios = new javax.swing.JComboBox<>();
        cmbEmpleados = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(206, 237, 237));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Actualizar Movimiento");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        btnAceptar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/aceptar.png"))); // NOI18N
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 40, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 40, 40));

        jPanel2.add(cmbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 212, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Producto:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jPanel2.add(cmbVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 212, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Servicio:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 213, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Vehículo:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Empleado:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jPanel2.add(cmbServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 212, -1));

        jPanel2.add(cmbEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 212, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        int cantidad = Integer.parseInt(this.txtCantidad.getText());

        ItemCmbServicios objItem = (ItemCmbServicios) this.cmbServicios.getSelectedItem();
        int idS = objItem.getIds();

        ItemCmbEmpleados objItem2 = (ItemCmbEmpleados) this.cmbEmpleados.getSelectedItem();
        int idE = objItem2.getIde();

        ItemCmbVehiculo objItem3 = (ItemCmbVehiculo) this.cmbVehiculo.getSelectedItem();
        int idV = objItem3.getIdv();

        ItemCmbProductos objItem4 = (ItemCmbProductos) this.cmbProductos.getSelectedItem();
        int idProd = objItem4.getIdprod();

        AdminMovimientoDB objAdmMovDB = new AdminMovimientoDB();
        Movimiento objMovimiento = new Movimiento();

        objMovimiento.setIdmov(this.idmov);
        objAdmMovDB.listarUno(objMovimiento);

        objMovimiento.setCantidad_producto(cantidad);
        objMovimiento.setServicios_ids(idS);
        objMovimiento.setEmpleados_ide(idE);
        objMovimiento.setVehiculo_idv(idV);
        objMovimiento.setProductos_idprod(idProd);

        objAdmMovDB.actualizar(objMovimiento);

        this.dispose();
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbEmpleados> cmbEmpleados;
    private javax.swing.JComboBox<ItemCmbProductos> cmbProductos;
    private javax.swing.JComboBox<ItemCmbServicios> cmbServicios;
    private javax.swing.JComboBox<ItemCmbVehiculo> cmbVehiculo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
