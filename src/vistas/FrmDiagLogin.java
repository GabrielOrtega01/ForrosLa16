package vistas;

import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmDiagLogin extends javax.swing.JDialog {

    public FrmDiagLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Acceso al sistema");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 53, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Clave:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 88, -1, 29));
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 57, 80, -1));

        btnAcceder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAcceder.setText("Acceder");
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });
        jPanel1.add(btnAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 139, -1, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 139, -1, -1));

        txtClave.setText("123");
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 95, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        String USUARIO = txtIdentificacion.getText();
        String contra_usua = txtClave.getText();

        String url = "SELECT e.cargo_e, e.ide ,U.clave_u FROM Empleados e \n"
                    + "INNER JOIN Usuario U ON e.ide = U.empleados_ide \n"
                    + "WHERE e.ide = ?";

        try {
            Connection con = Conexion.abrirConexion();
            PreparedStatement ps = con.prepareStatement(url);
            ps.setString(1, USUARIO);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si existe el usuario
                String u = rs.getString("cargo_e");
                String p = rs.getString("clave_u");

                if (contra_usua.equals(p)) {

                    if (u.equals("Administrador")) {
                        FrmPrincipal objFrmPrincipal = new FrmPrincipal();
                        objFrmPrincipal.setLocationRelativeTo(null);
                        objFrmPrincipal.setVisible(true);
                    } else if (u.equals("Contador")) {
                        FrmPrincipalContador objAdminn = new FrmPrincipalContador();
                        objAdminn.setLocationRelativeTo(null);
                        objAdminn.setVisible(true);
                    } else if (u.equals("Cortador")) {
                        FrmPrincipalCortador objAdminn = new FrmPrincipalCortador();
                        objAdminn.setLocationRelativeTo(null);
                        objAdminn.setVisible(true);
                    } else if (u.equals("Cosedor")) {
                        FrmPrincipalCosedor objAdminn = new FrmPrincipalCosedor();
                        objAdminn.setLocationRelativeTo(null);
                        objAdminn.setVisible(true);
                    } else if (u.equals("Instalador")) {
                        FrmPrincipalInstalador objAdminn = new FrmPrincipalInstalador();
                        objAdminn.setLocationRelativeTo(null);
                        objAdminn.setVisible(true);
                    }
                    this.dispose();
/*cargo     usuario    clave
Administrador	1	123
Contador	2	123
Instalador	3	123
Instalador      4	123
Instalador	5	123
Instalador	6	123
Cosedor	        7	123
Cosedor	        8	123
Cosedor 	9	123
Cosedor	        10	123
Cosedor   	11	123
Cortador        12	123
Cortador 	13	123
Cortador	14	123
Cortador	15	123
Cortador 	16	123*/
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña no es correcta");
                }
            } else {
                // El usuario no existe
                JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAccederActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtIdentificacion;
    // End of variables declaration//GEN-END:variables
}
