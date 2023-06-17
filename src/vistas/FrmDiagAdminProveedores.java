package vistas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdminProveedoresDB;
import modelo.Proveedores;

public class FrmDiagAdminProveedores extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    AdminProveedoresDB objAdminProveedoresDB = new AdminProveedoresDB();

    public FrmDiagAdminProveedores(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        this.configurarTabla();
        this.refrescarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"ID", "Nombre"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblListaDeProveedores.setModel(this.modeloTabla);
    }

    private void refrescarTabla() {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[2];

        for (Object obj : objAdminProveedoresDB.listarTodo()) {
            Proveedores objProveedores = (Proveedores) obj;
            filaDeTabla[0] = Integer.toString(objProveedores.getIdprov());
            filaDeTabla[1] = objProveedores.getNombre_prov();

            this.modeloTabla.addRow(filaDeTabla);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaDeProveedores = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        logoJL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Proveedores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 11, -1, -1));

        tblListaDeProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(tblListaDeProveedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 44, 696, 420));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/agragar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 129, 34));

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/actualizar.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 90, 34));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 115, 34));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 37, 34));

        logoJL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/logo_la16.png"))); // NOI18N
        jPanel1.add(logoJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmDiagAgregarProveedores FrmDiagAgregarProveedores = new FrmDiagAgregarProveedores(null, true);
        FrmDiagAgregarProveedores.setLocationRelativeTo(null);
        FrmDiagAgregarProveedores.setVisible(true);

        this.refrescarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = this.tblListaDeProveedores.getSelectedRow();

        if (fila > -1) {
            int id = Integer.parseInt(this.tblListaDeProveedores.getValueAt(fila, 0).toString());

            FrmDiagActualizarProveedores objFrmDiagUpdArts = new FrmDiagActualizarProveedores(null, true, id);
            objFrmDiagUpdArts.setLocationRelativeTo(null);
            objFrmDiagUpdArts.setVisible(true);

            this.refrescarTabla();

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione el proveedor que quiere actualizar.");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListaDeProveedores.getSelectedRow();

        if (fila > -1) {
            int idprov = Integer.parseInt(this.tblListaDeProveedores.getValueAt(fila, 0).toString());

            Proveedores objProveedores = new Proveedores();
            objProveedores.setIdprov(idprov);

            if (objAdminProveedoresDB.eliminar(objProveedores)) {
                JOptionPane.showMessageDialog(this, "El proveedor fue eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "El proveedor no pudo ser eliminado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione el proveedor que quiere eliminar.");
        }
        this.refrescarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoJL;
    private javax.swing.JTable tblListaDeProveedores;
    // End of variables declaration//GEN-END:variables
}
