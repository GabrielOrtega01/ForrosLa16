package vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.Productos;
import modelo.AdminProductosDB;
import modelo.ReporteBalanceProductos;
import modelo.ItemCmbProductos;

public class FrmDiagReportesBalanceProductos extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB = new RelacionesDB();

    public FrmDiagReportesBalanceProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
        this.cargarAdministrarInventarioProductoss();
    }

    private void cargarAdministrarInventarioProductoss() {
        AdminProductosDB objAdmArt = new AdminProductosDB();

        for (Object obj : objAdmArt.listarTodo()) {
            Productos objProductos = new Productos();
            objProductos = (Productos) obj;

            ItemCmbProductos objItem = new ItemCmbProductos();
            objItem.setIdprod(objProductos.getIdprod());
            objItem.setNombre_prod(objProductos.getNombre_prod());

            this.cmbProductos.addItem(objItem);
        }
    }

    private void configurarTabla() {
        String cabecera[] = {"No", "Fecha de compra", "Fecha de factura", "Responsable de la operación"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera);
        this.tblReporteAdministrarInventarioProductos.setModel(this.modeloTabla);

    }

    private void refrescarTabla(LocalDate fechaInicio9, LocalDate fechaFin9, String nombreArt) {

        // Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        // Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[4];
        int contador = 1; // Variable autoincrementable
        int Cantidad_inicial = 0;
        int Cantidad_utilizada = 0;
        int Cantidad_final = 0;

        // Asignar valores a los atributos de objListaAticulo
        for (Object obj : objRelDB.consultarDatos9(fechaInicio9, fechaFin9, nombreArt)) {
            ReporteBalanceProductos objListaProductos = (ReporteBalanceProductos) obj;
            filaDeTabla[0] = Integer.toString(contador); // Asignar el valor del contador
            contador++; // Incrementar el contador para el siguiente registro
            filaDeTabla[1] = objListaProductos.getFecha_de_compra().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            filaDeTabla[2] = objListaProductos.getFecha_factura().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            filaDeTabla[3] = objListaProductos.getEmpleado_responsable();
            
            Cantidad_final = objListaProductos.getCantidad_actual();
            Cantidad_utilizada = objListaProductos.getCantidad_utilizada();
            Cantidad_inicial = objListaProductos.getCantidad_inicial();

            this.modeloTabla.addRow(filaDeTabla);
        }
        this.labCantidadInicial.setText(Integer.toString(Cantidad_inicial));
        this.labCantidadUtilizada.setText(Integer.toString(Cantidad_utilizada));
        this.labCantidadFinal.setText(Integer.toString(Cantidad_final));

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labCantidadInicial = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteAdministrarInventarioProductos = new javax.swing.JTable();
        btnConsultarProductos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbProductos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labCantidadFinal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labCantidadUtilizada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(206, 237, 237));
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 357));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labCantidadInicial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCantidadInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCantidadInicial.setText("0");
        jPanel1.add(labCantidadInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 106, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar inventario de Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 0, -1, -1));

        tblReporteAdministrarInventarioProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Fecha de compra", "Fecha factura", "Responsable de la operación"
            }
        ));
        jScrollPane1.setViewportView(tblReporteAdministrarInventarioProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 909, 298));

        btnConsultarProductos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/buscar.png"))); // NOI18N
        btnConsultarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 428, 40, 40));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 428, 40, 40));
        jPanel1.add(jDateFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 448, 103, -1));
        jPanel1.add(jDateFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 448, 103, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha inicio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 425, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fecha fin");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 425, -1, -1));

        jPanel1.add(cmbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Producto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad inicial:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cantidad final:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, -1, -1));

        labCantidadFinal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCantidadFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCantidadFinal.setText("0");
        jPanel1.add(labCantidadFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 106, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Cantidad utilizada:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        labCantidadUtilizada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCantidadUtilizada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCantidadUtilizada.setText("0");
        jPanel1.add(labCantidadUtilizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 106, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProductosActionPerformed

        
        ItemCmbProductos objItem2 = (ItemCmbProductos) this.cmbProductos.getSelectedItem();
        String nombreProd = objItem2.getNombre_prod();

        LocalDate fechaInicio9 = this.jDateFechaInicio.getDate() != null ? this.jDateFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate fechaFin9 = this.jDateFechaFin.getDate() != null ? this.jDateFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        if (fechaInicio9 == null && fechaFin9 == null) {
            JOptionPane.showMessageDialog(this, "¡Los campos no pueden estar vacíos!");
        } else if (fechaInicio9 == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha inicial no debe estar vacía!");
        } else if (fechaFin9 == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha final no debe estar vacía!");
        } else if (fechaInicio9.isBefore(fechaFin9) || fechaInicio9.equals(fechaFin9)) {
            this.refrescarTabla(fechaInicio9, fechaFin9,nombreProd);
        } else {
            JOptionPane.showMessageDialog(this, "¡¡¡ Rango de fechas incorrecto !!!");
        }
    }//GEN-LAST:event_btnConsultarProductosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarProductos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<ItemCmbProductos> cmbProductos;
    private com.toedter.calendar.JDateChooser jDateFechaFin;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labCantidadFinal;
    private javax.swing.JLabel labCantidadInicial;
    private javax.swing.JLabel labCantidadUtilizada;
    private javax.swing.JTable tblReporteAdministrarInventarioProductos;
    // End of variables declaration//GEN-END:variables
}
