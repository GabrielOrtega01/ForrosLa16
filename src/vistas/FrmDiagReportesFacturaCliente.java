package vistas;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.ReporteFacturaCliente;

public class FrmDiagReportesFacturaCliente extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB = new RelacionesDB();

    public FrmDiagReportesFacturaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"Producto", "Costo servicio", "Precio unitario", "Cantidad", "Iva", "Total"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblReporteFactura.setModel(this.modeloTabla);
    }

    private void refrescarTabla(LocalDate fecha, String placa) {

        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[6];
        BigDecimal TotalFactura = BigDecimal.ZERO;

        for (Object obj : objRelDB.consultarFacturaCliente(fecha, placa)) {
            ReporteFacturaCliente objFacturaCliente = (ReporteFacturaCliente) obj;
            
            filaDeTabla[0] = objFacturaCliente.getProducto();
            filaDeTabla[1] = Integer.toString(objFacturaCliente.getCosto_servicio());
            filaDeTabla[2] = Integer.toString(objFacturaCliente.getPrecio_unitario());
            filaDeTabla[3] = Integer.toString(objFacturaCliente.getCantidad());
            filaDeTabla[4] = Float.toString(objFacturaCliente.getIva());
            filaDeTabla[5] = objFacturaCliente.getTotal().toString();

            this.modeloTabla.addRow(filaDeTabla);
            TotalFactura = TotalFactura.add(objFacturaCliente.getTotal());

            String administrador = objFacturaCliente.getAdmin();
            this.labAdministrador.setText(administrador);

            String nombreCliente = objFacturaCliente.getCliente();
            this.labCliente.setText(nombreCliente);

            String Documento = objFacturaCliente.getDocumento();
            this.labDocumento.setText(Documento);

            String Direccion = objFacturaCliente.getDireccion();
            this.labDireccion.setText(Direccion);

            String Placa = objFacturaCliente.getVehiculo();
            this.labPlaca.setText(Placa);

            String Color = objFacturaCliente.getColor();
            this.labColor.setText(Color);

            String Marca = objFacturaCliente.getMarca();
            this.labMarca.setText(Marca);            
            
            String Mecanico = objFacturaCliente.getEmpleado();
            this.labMecanico.setText(Mecanico);

            String Fecha = objFacturaCliente.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.labFecha.setText(Fecha);

            String numeroFactura = Integer.toString(objFacturaCliente.getIdf());
            this.labFactura.setText(numeroFactura);

        }
        // Formatear el total invertido con separadores de miles
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String totalInvertidoFormateado = decimalFormat.format(TotalFactura);
        this.labTotalFactura.setText(totalInvertidoFormateado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteFactura = new javax.swing.JTable();
        btnConsultarDineroTotal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        labTotalFactura = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labDocumento = new javax.swing.JLabel();
        labCliente = new javax.swing.JLabel();
        labFecha = new javax.swing.JLabel();
        labMecanico = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labDireccion = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labPlaca = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labFactura = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labAdministrador = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labMarca = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labColor = new javax.swing.JLabel();
        logoJL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Forros la 16 ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        tblReporteFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Producto", "Costo servicio", "Precio unitario", "Cantidad", "Iva", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblReporteFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 614, 140));

        btnConsultarDineroTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarDineroTotal.setText("Consultar");
        btnConsultarDineroTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDineroTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarDineroTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 630, -1, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Placa del vehículo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, -1, -1));

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 630, 126, -1));
        jPanel1.add(jDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 103, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Total de la factura:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, -1));

        labTotalFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labTotalFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTotalFactura.setText("0");
        jPanel1.add(labTotalFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 106, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cliente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Fecha:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 70, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Direccion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Documento:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        labDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDocumento.setText("0");
        jPanel1.add(labDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 156, -1));

        labCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCliente.setText("0");
        jPanel1.add(labCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 220, -1));

        labFecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFecha.setText("0");
        jPanel1.add(labFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 130, -1));

        labMecanico.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labMecanico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labMecanico.setText("0");
        jPanel1.add(labMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 160, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Empleado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 110, -1));

        labDireccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDireccion.setText("0");
        jPanel1.add(labDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 220, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Placa:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 70, -1));

        labPlaca.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPlaca.setText("0");
        jPanel1.add(labPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 130, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Factura#:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 110, -1));

        labFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFactura.setText("0");
        jPanel1.add(labFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 160, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Nit 123456789-8");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Admin:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        labAdministrador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labAdministrador.setText("0");
        jPanel1.add(labAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 202, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Dirección: Cl 16 22-23");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Teléfono: +576076347345");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("---------------------------------------------------------------------------------");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("---------------------------------------------------------------------------------");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Marca:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 70, -1));

        labMarca.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labMarca.setText("0");
        jPanel1.add(labMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 130, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Color:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 70, -1));

        labColor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labColor.setText("0");
        jPanel1.add(labColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 130, -1));

        logoJL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/logo_la16.png"))); // NOI18N
        jPanel1.add(logoJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarDineroTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDineroTotalActionPerformed

        String placa = this.txtPlaca.getText();
        LocalDate fecha = null;

        if (this.jDateFecha.getDate() != null) {
            fecha = this.jDateFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        if (fecha == null && placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡Los campos no pueden estar vacíos!");
        } else if (fecha == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha no debe estar vacía!");
        } else if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡La placa no debe estar vacía!");
        } else {
            this.refrescarTabla(fecha, placa);
        }

    }//GEN-LAST:event_btnConsultarDineroTotalActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarDineroTotal;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labAdministrador;
    private javax.swing.JLabel labCliente;
    private javax.swing.JLabel labColor;
    private javax.swing.JLabel labDireccion;
    private javax.swing.JLabel labDocumento;
    private javax.swing.JLabel labFactura;
    private javax.swing.JLabel labFecha;
    private javax.swing.JLabel labMarca;
    private javax.swing.JLabel labMecanico;
    private javax.swing.JLabel labPlaca;
    private javax.swing.JLabel labTotalFactura;
    private javax.swing.JLabel logoJL;
    private javax.swing.JTable tblReporteFactura;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
