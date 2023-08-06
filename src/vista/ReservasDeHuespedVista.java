/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtlReserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Reserva;

/**
 *
 * @author Jopcion
 */
public class ReservasDeHuespedVista extends javax.swing.JInternalFrame {

    private int cedula;

    CtlReserva controlReserva;
    List<Reserva> lista;
    private int idReserva;
    private boolean seleccionar = false;

    /**
     * Creates new form VerfacturaVista
     */
    public ReservasDeHuespedVista() {
        initComponents();
        setVisible(true);
        setMaximizable(false);
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
    }

    public ReservasDeHuespedVista(int cedula) {
        initComponents();
        setVisible(true);
        setMaximizable(false);
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
        this.cedula = cedula;
        controlReserva = new CtlReserva();
        listarReservasHuesped();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableReservas = new javax.swing.JTable();
        btnCancelarReserva = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableReservasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableReservas);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 518, 310));

        btnCancelarReserva.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCancelarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Multiply_32px.png"))); // NOI18N
        btnCancelarReserva.setText("CANCELAR RESERVA");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MIS RESERVAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(329, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(324, 324, 324))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        System.out.println("id"+idReserva);
        if (seleccionar == false) {
            JOptionPane.showMessageDialog(this, "debe seleccionar una fila para poder saber cual quiere eliminar");
        }else {
            Reserva reserva= null;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getIdReserva() == idReserva) {
                    reserva = lista.get(i);
                }
            }
            
            if (reserva != null) {
                
                Date actual;
                actual = new Date();
                actual.setHours(0);
                actual.setMinutes(0);
                actual.setSeconds(0);
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date inicio = null;
                try {
                    String a = sdf.format(reserva.getFechaInicio());
                    inicio = sdf.parse(a);
                } catch (ParseException e1) {
                }
                
                int numeroDias = numeroDiasEntreDosFechas(actual, inicio);
                
                if (numeroDias > 2) {
                    reserva.setEstado("cancelada");
                    if (controlReserva.cambiarEstadoReserva(reserva)) {
                        JOptionPane.showMessageDialog(this, "se cancelo con exito la reserva");
                        listarReservasHuesped();
                    }else {
                        JOptionPane.showMessageDialog(this, "error al cancelar la reserva");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "se le acabo el timepo para cancelar la reserva debe ser dos dias antes de que inicie");
                }
            }
            seleccionar = false;
        }
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void tableReservasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReservasMousePressed
        int fila = tableReservas.getSelectedRow();
        if (fila > -1) {
            seleccionar = true;
            idReserva = (int) tableReservas.getValueAt(fila, 0);
        }
    }//GEN-LAST:event_tableReservasMousePressed

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
            java.util.logging.Logger.getLogger(ReservasDeHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservasDeHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservasDeHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservasDeHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservasDeHuespedVista().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableReservas;
    // End of variables declaration//GEN-END:variables

    private void listarReservasHuesped() {
        lista = controlReserva.listarReservasHuesped(cedula);

        if (lista.size() > 0) {
            
        } else {
            JOptionPane.showMessageDialog(this, "no se han hecho reservas");
        }
        DefaultTableModel modelotabla;
            String[] nombreColumnas = {"id", "nombreHuesped", "apellidoHuesped", "fechaInicio", "fechaSalida"};
            modelotabla = new DefaultTableModel(null, nombreColumnas);
            for (int i = 0; i < lista.size(); i++) {
                modelotabla.addRow(new Object[]{lista.get(i).getIdReserva(), lista.get(i).getNombreHuesped(), lista.get(i).getApellidoHuesped(),
                    lista.get(i).getFechaInicio().toString(), lista.get(i).getFechaSalida().toString()});
            }
            tableReservas.setModel(modelotabla);
    }

    public int numeroDiasEntreDosFechas(Date fecha1, Date fecha2) {
        long startTime = fecha1.getTime();
        long endTime = fecha2.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return (int) diffDays;
    }
}
