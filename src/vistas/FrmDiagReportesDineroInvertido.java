package vistas;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.ReporteDineroInvertido;

public class FrmDiagReportesDineroInvertido extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB = new RelacionesDB();

    public FrmDiagReportesDineroInvertido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"Producto", "Maquina", "Herramienta", "Proveedor", "Total"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera);
        this.tblReporteReporteDineroInvertido.setModel(this.modeloTabla);
    }

    private void refrescarTabla() {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[5];
        int ReporteDineroInvertido = 0;

        for (Object obj : objRelDB.consultarDatos2()) {
            ReporteDineroInvertido objReporteDineroInvertido = (ReporteDineroInvertido) obj;
            filaDeTabla[0] = objReporteDineroInvertido.getProducto();
            filaDeTabla[1] = objReporteDineroInvertido.getMaquina();
            filaDeTabla[2] = objReporteDineroInvertido.getHerramienta();
            filaDeTabla[3] = objReporteDineroInvertido.getProveedor();
            filaDeTabla[4] = Integer.toString(objReporteDineroInvertido.getTotal());

            this.modeloTabla.addRow(filaDeTabla);
            
            ReporteDineroInvertido += objReporteDineroInvertido.getTotal();
        }

        // Formatear el total invertido con separadores de miles
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String totalInvertidoFormateado = decimalFormat.format(ReporteDineroInvertido);
        this.labTotalInventario.setText(totalInvertidoFormateado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteReporteDineroInvertido = new javax.swing.JTable();
        btnConsultarDineroNuevosArticulos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labTotalInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 342));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Balance dinero invertido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 11, -1, -1));

        tblReporteReporteDineroInvertido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Maquina", "Herramienta", "Proveedor", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblReporteReporteDineroInvertido);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 908, 208));

        btnConsultarDineroNuevosArticulos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarDineroNuevosArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/buscar.png"))); // NOI18N
        btnConsultarDineroNuevosArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDineroNuevosArticulosActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarDineroNuevosArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 40, 40));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 40, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Dinero total en inventarito:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        labTotalInventario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labTotalInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTotalInventario.setText("0");
        jPanel1.add(labTotalInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarDineroNuevosArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDineroNuevosArticulosActionPerformed
        this.refrescarTabla();
    }//GEN-LAST:event_btnConsultarDineroNuevosArticulosActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarDineroNuevosArticulos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labTotalInventario;
    private javax.swing.JTable tblReporteReporteDineroInvertido;
    // End of variables declaration//GEN-END:variables
}
