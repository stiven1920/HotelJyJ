/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtlConfirmarreserva;
import controlador.CtlHabitacion;
import controlador.CtlMultas;
import controlador.CtlReserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ConfirmarReserva;
import modelo.Habitacion;
import modelo.Multa;
import modelo.Reserva;

/**
 *
 * @author MI PC
 */
public class ActivarReservaVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ActivarReservaVista
     */
    private CtlReserva controlReserva;
    private CtlMultas controlMulta;
    private CtlHabitacion controlHabitacion;
    private CtlConfirmarreserva controlConfirmarRserva;
    private int idRecepcionista;
    private int cedulaHuespedCargado;
    private Reserva reservaCargada = null;

    public ActivarReservaVista() {
        initComponents();
        setVisible(true);
        setMaximizable(false);
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
        controlReserva = new CtlReserva();
        controlMulta = new CtlMultas();
        controlHabitacion = new CtlHabitacion();
        controlConfirmarRserva = new CtlConfirmarreserva();
    }

    public ActivarReservaVista(int idRecepcionista) {
        initComponents();
        setVisible(true);
        setMaximizable(false);
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
        this.idRecepcionista = idRecepcionista;
        controlReserva = new CtlReserva();
        controlMulta = new CtlMultas();
        controlHabitacion = new CtlHabitacion();
        controlConfirmarRserva = new CtlConfirmarreserva();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnBuscarReserva = new javax.swing.JButton();
        btnActivarReserva = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        lblNReserva = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaSalida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHECK IN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 140, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check-in.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 60, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 80));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("N° Reserva");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, -1, -1));

        jLabel9.setText("Cedula:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel11.setText("Nombre:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel3.setText("Fecha Salida:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jLabel4.setText("Fecha Inicio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel12.setText("Apellido:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        btnBuscarReserva.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBuscarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Search_32px_1.png"))); // NOI18N
        btnBuscarReserva.setText("Buscar Reserva");
        btnBuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarReservaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 150, -1));

        btnActivarReserva.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnActivarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Reserva.png"))); // NOI18N
        btnActivarReserva.setText("Activar Reserva");
        btnActivarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarReservaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActivarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));
        jPanel1.add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 136, 20));
        jPanel1.add(lblNReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 136, 20));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 136, 20));
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 136, 20));
        jPanel1.add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 136, 20));
        jPanel1.add(lblFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 136, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 660, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarReservaActionPerformed
        String input = JOptionPane.showInputDialog("ingrese la cedula del huesped");
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "debe ingresar el valor obligatoriamente");
        } else {
            cedulaHuespedCargado = Integer.parseInt(input);
            List<Reserva> reservas = controlReserva.listarReservasHuesped(cedulaHuespedCargado);
            if (reservas.size() > 0) {
                for (int i = 0; i < reservas.size(); i++) {
                    reservaCargada = reservas.get(i);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date parsed = null;
                try {
                    String a = sdf.format(reservaCargada.getFechaInicio());
                    parsed = sdf.parse(a);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                lblNReserva.setText(reservaCargada.getIdReserva() + "");
                lblNombre.setText(reservaCargada.getNombreHuesped());
                lblApellido.setText(reservaCargada.getApellidoHuesped());
                lblCedula.setText(reservaCargada.getHuespedId() + "");
                lblFechaInicio.setText(reservaCargada.getFechaInicio().toString());
                lblFechaSalida.setText(reservaCargada.getFechaSalida().toString());
                Date actual;
                actual = new Date();
                actual.setHours(0);
                actual.setMinutes(0);
                actual.setSeconds(0);
                int r = actual.compareTo(parsed);
                if (sdf.format(actual).equals(sdf.format(parsed))) {
                    JOptionPane.showMessageDialog(this, "Se puede activar perfectamente la reserva el huesped llego el dia que es!");
                } else if (r > 0) {
                    java.util.Date salida = null;
                    try {
                        String a = sdf.format(reservaCargada.getFechaSalida());
                        salida = sdf.parse(a);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    int v = actual.compareTo(salida);
                    Multa multa = new Multa();
                    multa.setEstado("activo");
                    multa.setConfirmaReservaId(reservaCargada.getIdReserva());
                    Habitacion habitacionUtilizar = controlHabitacion.buscarHabitacion(reservaCargada.getHabitacionId());
                    int numeroDias = 0;
                    String mensaje = "";
                    if (v > 0) {
                        //multa se cancela reserva
                        numeroDias = numeroDiasEntreDosFechas(parsed, salida);
                        multa.setValor(habitacionUtilizar.getValor() * numeroDias);
                        //hacer multa"
                        mensaje = controlMulta.guardarMultaReserva(multa) + " porque se sobre paso de la fecha final de la reserve , se le cancela la reserva";
                        reservaCargada.setEstado("cancelada");
                        controlReserva.cambiarEstadoReserva(reservaCargada);
                        limpiar();
                        reservaCargada = null;
                    } else {
                        numeroDias = numeroDiasEntreDosFechas(parsed, actual);
                        multa.setValor(habitacionUtilizar.getValor() * numeroDias);
                        mensaje = controlMulta.guardarMultaReserva(multa) + " porque se sobre paso de los dias de la fecha inicio que pido la reserva y podra activar la reserva";
                    }
                    JOptionPane.showMessageDialog(this, mensaje);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Este huesped no ha realizado reserva");
            }

        }
    }//GEN-LAST:event_btnBuscarReservaActionPerformed

    private void btnActivarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarReservaActionPerformed

        if (reservaCargada != null) {
            Date actual = new Date();
            reservaCargada.setEstado("iniciada");
            controlReserva.cambiarEstadoReserva(reservaCargada);
            ConfirmarReserva c = new ConfirmarReserva();
            c.setNombre(reservaCargada.getNombreHuesped());
            c.setApellido(reservaCargada.getApellidoHuesped());
            c.setFechInicio(reservaCargada.getFechaInicio());
            c.setFechaSalida(reservaCargada.getFechaSalida());
            c.setReservaId(reservaCargada.getIdReserva());
            c.setRecepcionistaId(idRecepcionista);
            java.sql.Date a = new java.sql.Date(actual.getTime());
            c.setFechaLlegada(a);
            controlConfirmarRserva.guardar(c);
            limpiar();
            reservaCargada = null;
            JOptionPane.showMessageDialog(this, "se activo perfectamente la reserva");
        } else {
            JOptionPane.showMessageDialog(this, "Debe primero buscar la reserva para poderla activar");
        }
    }//GEN-LAST:event_btnActivarReservaActionPerformed

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
            java.util.logging.Logger.getLogger(ActivarReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivarReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivarReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivarReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivarReservaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarReserva;
    private javax.swing.JButton btnBuscarReserva;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblNReserva;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables

    public int numeroDiasEntreDosFechas(Date fecha1, Date fecha2) {
        long startTime = fecha1.getTime();
        long endTime = fecha2.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return (int) diffDays;
    }

    public void limpiar() {
        lblApellido.setText("");
        lblCedula.setText("");
        lblFechaInicio.setText("");
        lblFechaSalida.setText("");
        lblNReserva.setText("");
        lblNombre.setText("");
    }
}
