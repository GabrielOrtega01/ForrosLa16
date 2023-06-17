package vistas;

public class FrmPrincipalCosedor extends javax.swing.JFrame {

    public FrmPrincipalCosedor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        submenuSalir = new javax.swing.JMenuItem();
        submenuAcceso = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        submenuAdminEmpleados = new javax.swing.JMenuItem();
        submenuAdmClientes = new javax.swing.JMenuItem();
        submenuAdmProveedores = new javax.swing.JMenuItem();
        submenuAdmMaquinas = new javax.swing.JMenuItem();
        submenuAdmProductos = new javax.swing.JMenuItem();
        submenuAdmHerramientas = new javax.swing.JMenuItem();
        submenuAdmServicios = new javax.swing.JMenuItem();
        submenuAdmUsusarios = new javax.swing.JMenuItem();
        submenuAdmVehiculo = new javax.swing.JMenuItem();
        submenuAdmComprasherramientas = new javax.swing.JMenuItem();
        submenuAdmComprasmaquinas = new javax.swing.JMenuItem();
        submenuAdmComprasproductos = new javax.swing.JMenuItem();
        submenuAdmMovimiento = new javax.swing.JMenuItem();
        submenuAdmFactura = new javax.swing.JMenuItem();
        menuReportes4 = new javax.swing.JMenu();
        submenuReportesFacturaCliente4 = new javax.swing.JMenuItem();
        submenuReportesFacturaCliente5 = new javax.swing.JMenuItem();
        submenuReportesFacturaCliente6 = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        submenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondo.setBackground(new java.awt.Color(206, 237, 237));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(1150, 668));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cosedor");
        jPanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Forros la 16");
        jPanelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/forros.png"))); // NOI18N
        jPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuArchivo.setText("Archivo");

        submenuSalir.setText("Salir");
        submenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(submenuSalir);

        submenuAcceso.setText("Acceso");
        submenuAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAccesoActionPerformed(evt);
            }
        });
        menuArchivo.add(submenuAcceso);

        barraDeMenu.add(menuArchivo);

        menuConfiguracion.setText("Configuración");

        submenuAdminEmpleados.setText("Admin empleados");
        submenuAdminEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminEmpleadosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdminEmpleados);

        submenuAdmClientes.setText("Admin clientes");
        submenuAdmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmClientesActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmClientes);

        submenuAdmProveedores.setText("Admin proveedores");
        submenuAdmProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmProveedoresActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmProveedores);

        submenuAdmMaquinas.setText("Admin maquinas");
        submenuAdmMaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmMaquinasActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmMaquinas);

        submenuAdmProductos.setText("Admin productos");
        submenuAdmProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmProductosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmProductos);

        submenuAdmHerramientas.setText("Admin herramientas");
        submenuAdmHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmHerramientasActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmHerramientas);

        submenuAdmServicios.setText("Admin servicios");
        submenuAdmServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmServiciosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmServicios);

        submenuAdmUsusarios.setText("Admin usuarios");
        submenuAdmUsusarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmUsusariosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmUsusarios);

        submenuAdmVehiculo.setText("Admin vehículos");
        submenuAdmVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmVehiculoActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmVehiculo);

        submenuAdmComprasherramientas.setText("Admin compras herramientas");
        submenuAdmComprasherramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmComprasherramientasActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmComprasherramientas);

        submenuAdmComprasmaquinas.setText("Admin compras maquinas");
        submenuAdmComprasmaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmComprasmaquinasActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmComprasmaquinas);

        submenuAdmComprasproductos.setText("Admin compras productos");
        submenuAdmComprasproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmComprasproductosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmComprasproductos);

        submenuAdmMovimiento.setText("Admin movimiento");
        submenuAdmMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmMovimientoActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmMovimiento);

        submenuAdmFactura.setText("Admin facturas");
        submenuAdmFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmFacturaActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmFactura);

        barraDeMenu.add(menuConfiguracion);

        menuReportes4.setText("Reportes");

        submenuReportesFacturaCliente4.setText("Factura por cliente");
        submenuReportesFacturaCliente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesFacturaCliente4ActionPerformed(evt);
            }
        });
        menuReportes4.add(submenuReportesFacturaCliente4);

        submenuReportesFacturaCliente5.setText("Balance productos");
        submenuReportesFacturaCliente5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesFacturaCliente5ActionPerformed(evt);
            }
        });
        menuReportes4.add(submenuReportesFacturaCliente5);

        submenuReportesFacturaCliente6.setText("Dinero invertido");
        submenuReportesFacturaCliente6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesFacturaCliente6ActionPerformed(evt);
            }
        });
        menuReportes4.add(submenuReportesFacturaCliente6);

        barraDeMenu.add(menuReportes4);

        menuAyuda.setText("Ayuda");

        submenuAcercaDe.setText("Acerca de ...");
        submenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAcercaDeActionPerformed(evt);
            }
        });
        menuAyuda.add(submenuAcercaDe);

        barraDeMenu.add(menuAyuda);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_submenuSalirActionPerformed

    private void submenuAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAccesoActionPerformed
        FrmDiagLogin objFrmDiagLogin = new FrmDiagLogin(this, true);
        objFrmDiagLogin.setLocationRelativeTo(null);
        objFrmDiagLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_submenuAccesoActionPerformed

    private void submenuAdminEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdminEmpleadosActionPerformed
        FrmDiagAdminEmpleados objFrmDiagAdmRol = new FrmDiagAdminEmpleados(this, true);
        objFrmDiagAdmRol.setLocationRelativeTo(null);
        objFrmDiagAdmRol.setVisible(true);
    }//GEN-LAST:event_submenuAdminEmpleadosActionPerformed

    private void submenuAdmClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmClientesActionPerformed
        FrmDiagAdminClientes objFrmDiagAdmPer = new FrmDiagAdminClientes(this, true);
        objFrmDiagAdmPer.setLocationRelativeTo(null);
        objFrmDiagAdmPer.setVisible(true);
    }//GEN-LAST:event_submenuAdmClientesActionPerformed

    private void submenuAdmProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmProveedoresActionPerformed
        FrmDiagAdminProveedores objFrmDiagAdmProv = new FrmDiagAdminProveedores(this, true);
        objFrmDiagAdmProv.setLocationRelativeTo(null);
        objFrmDiagAdmProv.setVisible(true);
    }//GEN-LAST:event_submenuAdmProveedoresActionPerformed

    private void submenuAdmMaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmMaquinasActionPerformed
        FrmDiagAdminMaquinas objFrmDiagAdmPer = new FrmDiagAdminMaquinas(this, true);
        objFrmDiagAdmPer.setLocationRelativeTo(null);
        objFrmDiagAdmPer.setVisible(true);
    }//GEN-LAST:event_submenuAdmMaquinasActionPerformed

    private void submenuAdmProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmProductosActionPerformed
        FrmDiagAdminProductos objFrmDiagAdmProd = new FrmDiagAdminProductos(this, true);
        objFrmDiagAdmProd.setLocationRelativeTo(null);
        objFrmDiagAdmProd.setVisible(true);
    }//GEN-LAST:event_submenuAdmProductosActionPerformed

    private void submenuAdmHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmHerramientasActionPerformed
        FrmDiagAdminHerramientas objFrmDiagAdmH = new FrmDiagAdminHerramientas(this, true);
        objFrmDiagAdmH.setLocationRelativeTo(null);
        objFrmDiagAdmH.setVisible(true);
    }//GEN-LAST:event_submenuAdmHerramientasActionPerformed

    private void submenuAdmServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmServiciosActionPerformed
        FrmDiagAdminServicios objFrmDiagAdmS = new FrmDiagAdminServicios(this, true);
        objFrmDiagAdmS.setLocationRelativeTo(null);
        objFrmDiagAdmS.setVisible(true);
    }//GEN-LAST:event_submenuAdmServiciosActionPerformed

    private void submenuAdmUsusariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmUsusariosActionPerformed
        FrmDiagAdminUsuario objFrmDiagAdmUsu = new FrmDiagAdminUsuario(this, true);
        objFrmDiagAdmUsu.setLocationRelativeTo(null);
        objFrmDiagAdmUsu.setVisible(true);
    }//GEN-LAST:event_submenuAdmUsusariosActionPerformed

    private void submenuAdmVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmVehiculoActionPerformed
        FrmDiagAdminVehiculo objFrmDiagAdmPer = new FrmDiagAdminVehiculo(this, true);
        objFrmDiagAdmPer.setLocationRelativeTo(null);
        objFrmDiagAdmPer.setVisible(true);
    }//GEN-LAST:event_submenuAdmVehiculoActionPerformed

    private void submenuAdmComprasherramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmComprasherramientasActionPerformed
        FrmDiagAdminComprasherramientas objFrmDiagAdmPer = new FrmDiagAdminComprasherramientas(this, true);
        objFrmDiagAdmPer.setLocationRelativeTo(null);
        objFrmDiagAdmPer.setVisible(true);
    }//GEN-LAST:event_submenuAdmComprasherramientasActionPerformed

    private void submenuAdmComprasmaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmComprasmaquinasActionPerformed
        FrmDiagAdminComprasmaquinas objFrmDiagAdmCM = new FrmDiagAdminComprasmaquinas(this, true);
        objFrmDiagAdmCM.setLocationRelativeTo(null);
        objFrmDiagAdmCM.setVisible(true);
    }//GEN-LAST:event_submenuAdmComprasmaquinasActionPerformed

    private void submenuAdmComprasproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmComprasproductosActionPerformed
        FrmDiagAdminComprasproductos objFrmDiagAdmCProd = new FrmDiagAdminComprasproductos(this, true);
        objFrmDiagAdmCProd.setLocationRelativeTo(null);
        objFrmDiagAdmCProd.setVisible(true);
    }//GEN-LAST:event_submenuAdmComprasproductosActionPerformed

    private void submenuAdmMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmMovimientoActionPerformed
        FrmDiagAdminMovimiento objFrmDiagAdmMov = new FrmDiagAdminMovimiento(this, true);
        objFrmDiagAdmMov.setLocationRelativeTo(null);
        objFrmDiagAdmMov.setVisible(true);
    }//GEN-LAST:event_submenuAdmMovimientoActionPerformed

    private void submenuAdmFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmFacturaActionPerformed
        FrmDiagAdminFactura objFrmDiagAdmPer = new FrmDiagAdminFactura(this, true);
        objFrmDiagAdmPer.setLocationRelativeTo(null);
        objFrmDiagAdmPer.setVisible(true);
    }//GEN-LAST:event_submenuAdmFacturaActionPerformed

    private void submenuReportesFacturaCliente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesFacturaCliente4ActionPerformed
        FrmDiagReportesFacturaCliente objFrmDiagRepFC = new FrmDiagReportesFacturaCliente(this, true);
        objFrmDiagRepFC.setLocationRelativeTo(null);
        objFrmDiagRepFC.setVisible(true);
    }//GEN-LAST:event_submenuReportesFacturaCliente4ActionPerformed

    private void submenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAcercaDeActionPerformed
        FrmDiagAcercaDe objFrmDiagAcerca = new FrmDiagAcercaDe(this, true);
        objFrmDiagAcerca.setLocationRelativeTo(null);
        objFrmDiagAcerca.setVisible(true);
    }//GEN-LAST:event_submenuAcercaDeActionPerformed

    private void submenuReportesFacturaCliente5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesFacturaCliente5ActionPerformed
        FrmDiagReportesBalanceProductos objFrmDiagRepFC = new FrmDiagReportesBalanceProductos(this, true);
        objFrmDiagRepFC.setLocationRelativeTo(null);
        objFrmDiagRepFC.setVisible(true);
    }//GEN-LAST:event_submenuReportesFacturaCliente5ActionPerformed

    private void submenuReportesFacturaCliente6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesFacturaCliente6ActionPerformed
        FrmDiagReportesDineroInvertido objFrmDiagRepFC = new FrmDiagReportesDineroInvertido(this, true);
        objFrmDiagRepFC.setLocationRelativeTo(null);
        objFrmDiagRepFC.setVisible(true);
    }//GEN-LAST:event_submenuReportesFacturaCliente6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenu menuReportes4;
    private javax.swing.JMenuItem submenuAcceso;
    private javax.swing.JMenuItem submenuAcercaDe;
    private javax.swing.JMenuItem submenuAdmClientes;
    private javax.swing.JMenuItem submenuAdmComprasherramientas;
    private javax.swing.JMenuItem submenuAdmComprasmaquinas;
    private javax.swing.JMenuItem submenuAdmComprasproductos;
    private javax.swing.JMenuItem submenuAdmFactura;
    private javax.swing.JMenuItem submenuAdmHerramientas;
    private javax.swing.JMenuItem submenuAdmMaquinas;
    private javax.swing.JMenuItem submenuAdmMovimiento;
    private javax.swing.JMenuItem submenuAdmProductos;
    private javax.swing.JMenuItem submenuAdmProveedores;
    private javax.swing.JMenuItem submenuAdmServicios;
    private javax.swing.JMenuItem submenuAdmUsusarios;
    private javax.swing.JMenuItem submenuAdmVehiculo;
    private javax.swing.JMenuItem submenuAdminEmpleados;
    private javax.swing.JMenuItem submenuReportesFacturaCliente4;
    private javax.swing.JMenuItem submenuReportesFacturaCliente5;
    private javax.swing.JMenuItem submenuReportesFacturaCliente6;
    private javax.swing.JMenuItem submenuSalir;
    // End of variables declaration//GEN-END:variables
}
