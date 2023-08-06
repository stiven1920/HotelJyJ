/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtlConfirmarSalida;
import controlador.CtlConfirmarreserva;
import controlador.CtlHabitacion;
import controlador.CtlPedido;
import controlador.CtlRegistroPedidoHuesped;
import controlador.CtlReserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConfirmarReserva;
import modelo.ConfirmarSalida;
import modelo.Habitacion;
import modelo.RegistroPedido;
import modelo.Reserva;

/**
 *
 * @author Jopcion
 */
public class CheckOutVista extends javax.swing.JInternalFrame {

    private CtlConfirmarreserva controlConfirmarReserva;
    private CtlConfirmarSalida controlConfirmarSalida;
    private CtlReserva controlReserva;
    private Reserva active = null;
    private CtlHabitacion controlHabitacion;
    private CtlRegistroPedidoHuesped controlRegistroPedido;
    private CtlPedido controlPedido;
    private List<RegistroPedido> pedidos;

    public CheckOutVista() {
        setVisible(true);
        setMaximizable(false);
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
        initComponents();
        controlConfirmarReserva = new CtlConfirmarreserva();
        controlReserva = new CtlReserva();
        controlHabitacion = new CtlHabitacion();
        controlRegistroPedido = new CtlRegistroPedidoHuesped();
        controlPedido = new CtlPedido();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtFechaLlegada = new javax.swing.JTextField();
        TxtFechaSalida = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtIdReservaActivada = new javax.swing.JTextField();
        TxtIdRecepcionista = new javax.swing.JTextField();
        btnBuscarHuesped = new javax.swing.JButton();
        btnCheckut = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTotalHabitacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtTotalPedido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, -1));

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel1.add(TxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 190, -1));

        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jLabel5.setText("Fecha Salida:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        jLabel6.setText("Fecha llegada");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        jPanel1.add(TxtFechaLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));
        jPanel1.add(TxtFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 120, -1));

        jLabel7.setText("N° Reserva:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel8.setText("Id Recepcionista");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        TxtIdReservaActivada.setText("                   ");
        jPanel1.add(TxtIdReservaActivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        TxtIdRecepcionista.setText("               ");
        jPanel1.add(TxtIdRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        btnBuscarHuesped.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBuscarHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Search_32px_1.png"))); // NOI18N
        btnBuscarHuesped.setText("Buscar Huesped");
        btnBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarHuesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        btnCheckut.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCheckut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/travel.png"))); // NOI18N
        btnCheckut.setText("check-out");
        btnCheckut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckutActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheckut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, -1));

        btnPdf.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnPdf.setText("PDF");
        jPanel1.add(btnPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 490, 310));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHECK OUT");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check-out.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 70));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Total habitacion:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        txtTotalHabitacion.setForeground(new java.awt.Color(0, 0, 255));
        txtTotalHabitacion.setText("               ");
        jPanel3.add(txtTotalHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 100, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Total pedido:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        TxtTotalPedido.setForeground(new java.awt.Color(0, 0, 255));
        TxtTotalPedido.setText("                      ");
        jPanel3.add(TxtTotalPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 100, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Total a pagar:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        TxtTotal.setForeground(new java.awt.Color(0, 255, 51));
        jPanel3.add(TxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 100, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Gastos de hospedaje");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Firma.jpeg"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 120, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 220, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHuespedActionPerformed
        String id = JOptionPane.showInputDialog("ingrese la cedula del huesped");

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "debe ingresar un valor numerico");
        } else {
            List<ConfirmarReserva> lista = controlConfirmarReserva.listarConfirmarReservasActivasHuesped(Integer.parseInt(id));
            if (lista.size() > 0) {
                active = controlReserva.reservaConfirmada(lista.get(0).getReservaId());
                Habitacion habitacion = controlHabitacion.buscarHabitacion(active.getHabitacionId());
                CargarDatosReservaHuesped(lista.get(0));
                int numeroDias = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date llegada = null;
                try {
                    String a = sdf.format(lista.get(0).getFechaLlegada());
                    llegada = sdf.parse(a);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Date actual;
                actual = new Date();
                actual.setHours(0);
                actual.setMinutes(0);
                actual.setSeconds(0);
                numeroDias = numeroDiasEntreDosFechas(actual, llegada);
                int totalHabitacion = ((numeroDias * habitacion.getValor())) == 0 ? habitacion.getValor() : (numeroDias * habitacion.getValor());
                txtTotalHabitacion.setText(totalHabitacion + "");
                pedidos = controlRegistroPedido.listarPedidoHuespedHabitacion(Integer.parseInt(id), habitacion.getIdHabitacion());
                if (pedidos.size() > 0) {
                    int totalPedido = 0;
                    for (RegistroPedido pedido : pedidos) {
                        totalPedido += pedido.getTotal();
                    }
                    TxtTotalPedido.setText(totalPedido + "");
                    TxtTotal.setText("" + (totalHabitacion + totalPedido));
                }
            } else {
                JOptionPane.showMessageDialog(this, "el huesped no tiene reservas activas");
            }

        }
    }//GEN-LAST:event_btnBuscarHuespedActionPerformed

    private void btnCheckutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckutActionPerformed

        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");

        String nombre = TxtNombre.getText().trim();
        String apellido = TxtApellido.getText().trim();
        java.sql.Date fechaSalida = null;
        java.sql.Date fechallegada = null;
        int reservaSalida = Integer.parseInt(TxtIdReservaActivada.getText().trim());
        int recepccionista = Integer.parseInt(TxtIdReservaActivada.getText().trim());
        try {
            fechallegada = (java.sql.Date) formato1.parse(TxtFechaSalida.getText().trim());
            fechaSalida = (java.sql.Date) formato2.parse(TxtFechaSalida.getText().trim());
        } catch (ParseException ex) {
            Logger.getLogger(CheckOutVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConfirmarSalida salida = new ConfirmarSalida(nombre, apellido, fechaSalida, fechallegada, reservaSalida, recepccionista);

        if (active == null) {
            JOptionPane.showMessageDialog(this, "debe buscar");
        } else {
            active.setEstado("terminado");

            if (controlReserva.cambiarEstadoReserva(active)) {
                controlConfirmarSalida.guardarSalida(salida);
                for (RegistroPedido pedido : pedidos) {
                    controlRegistroPedido.eliminar(pedido.getIdRegistroPedido());
                }
                JOptionPane.showMessageDialog(this, "se hizo el check out");
            } else {
                JOptionPane.showMessageDialog(this, "error al hacer checkOut");
            }
        }
    }//GEN-LAST:event_btnCheckutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckOutVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOutVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOutVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOutVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOutVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtFechaLlegada;
    private javax.swing.JTextField TxtFechaSalida;
    private javax.swing.JTextField TxtIdRecepcionista;
    private javax.swing.JTextField TxtIdReservaActivada;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JTextField TxtTotalPedido;
    private javax.swing.JButton btnBuscarHuesped;
    private javax.swing.JButton btnCheckut;
    private javax.swing.JButton btnPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtTotalHabitacion;
    // End of variables declaration//GEN-END:variables

    private void CargarDatosReservaHuesped(ConfirmarReserva reserva) {
        TxtApellido.setText(reserva.getApellido() + "");
        TxtNombre.setText(reserva.getNombre() + "");
        TxtIdReservaActivada.setText(reserva.getReservaId() + "");
        TxtFechaLlegada.setText(reserva.getFechaLlegada().toString());
        TxtFechaSalida.setText(reserva.getFechaSalida().toString());
        TxtIdRecepcionista.setText(reserva.getRecepcionistaId() + "");
    }

    public int numeroDiasEntreDosFechas(Date fecha1, Date fecha2) {
        long startTime = fecha1.getTime();
        long endTime = fecha2.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return (int) diffDays;
    }

}