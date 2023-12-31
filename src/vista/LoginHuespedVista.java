/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtlHuesped;
import controlador.CtlRecepcion;
import excepciones.EmpleadoNoexistenteException;
import excepciones.PersonaExistenteException;
import excepciones.PersonaNoEncontradaException;
import javax.swing.JOptionPane;
import modelo.Huesped;
import modelo.Recepcionista;

/**
 *
 * @author Jopcion
 */
public class LoginHuespedVista extends javax.swing.JFrame {

    CtlHuesped controlHuesped;
    CtlRecepcion controlRecepcion;

    public LoginHuespedVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("HUESPED");
        controlHuesped = new CtlHuesped();
        controlRecepcion = new CtlRecepcion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jpingreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtxCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jtxContrasenia = new javax.swing.JPasswordField();

        jTextField1.setText("jTextField1");

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpingreso.setBackground(new java.awt.Color(51, 70, 90));
        jpingreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpingreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(238, 112, 82));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cedula:");
        jpingreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel3.setBackground(new java.awt.Color(238, 112, 82));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jpingreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jtxNombre.setForeground(new java.awt.Color(51, 51, 51));
        jpingreso.add(jtxNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 142, 27));

        jLabel5.setBackground(new java.awt.Color(238, 112, 82));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido:");
        jpingreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jtxApellido.setForeground(new java.awt.Color(51, 51, 51));
        jpingreso.add(jtxApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 139, 27));

        jLabel7.setBackground(new java.awt.Color(238, 112, 82));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono:");
        jpingreso.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jtxTelefono.setForeground(new java.awt.Color(51, 51, 51));
        jtxTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxTelefonoKeyTyped(evt);
            }
        });
        jpingreso.add(jtxTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 139, 30));

        jLabel8.setBackground(new java.awt.Color(238, 112, 82));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección:");
        jpingreso.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jtxDireccion.setForeground(new java.awt.Color(51, 51, 51));
        jpingreso.add(jtxDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 139, 30));

        jLabel9.setBackground(new java.awt.Color(238, 112, 82));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo:");
        jpingreso.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jtxCorreo.setForeground(new java.awt.Color(51, 51, 51));
        jpingreso.add(jtxCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 139, 30));

        btnGuardar.setBackground(new java.awt.Color(153, 153, 255));
        btnGuardar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("REGISTAR");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jpingreso.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 140, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cedula.png"))); // NOI18N
        jpingreso.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jtxCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxCedulaKeyTyped(evt);
            }
        });
        jpingreso.add(jtxCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        jpingreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        jpingreso.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 280, 480));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Siguenos en");
        jpingreso.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 110, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Facebook_1.png"))); // NOI18N
        jpingreso.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 40, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Youtube_1.png"))); // NOI18N
        jpingreso.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 40, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Instagram_1.png"))); // NOI18N
        jpingreso.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 40, 30));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("REGISTRO");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 120, -1));

        btnLogin.setBackground(new java.awt.Color(51, 70, 90));
        btnLogin.setForeground(new java.awt.Color(51, 70, 90));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit.png"))); // NOI18N
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 30, 30));

        jpingreso.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 60));
        jpingreso.add(jtxContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 140, 30));

        getContentPane().add(jpingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here: if (jtxTelefono.getText().isEmpty() || jtxNombre.getText().isEmpty() || jtxCedula.getText().isEmpty() || jtxCorreo.getText().isEmpty()
        if (jtxTelefono.getText().isEmpty() || jtxNombre.getText().isEmpty() || jtxCedula.getText().isEmpty() || jtxCorreo.getText().isEmpty()
                || jtxDireccion.getText().isEmpty() || jtxTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Son requeridos los campos vacios", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            int cedula = Integer.parseInt(jtxCedula.getText());
            String nombre = jtxNombre.getText();
            String apellido = jtxTelefono.getText();
            int telefono = Integer.parseInt(jtxTelefono.getText());
            String direccion = jtxDireccion.getText();
            String correo = jtxCorreo.getText();
            String contrasenia = jtxContrasenia.getText();
            try {
                Recepcionista recepcion = controlRecepcion.buscarRecepcionista(cedula);
                if (recepcion == null) {
                     Huesped huesped = new Huesped(cedula, nombre, apellido, telefono, direccion, correo, contrasenia);
                    controlHuesped.guardarHuesped(huesped);
//                    JOptionPane.showMessageDialog(this, "registro guardado correctamente");
                    refrescar();
                   
                } else {
                    JOptionPane.showMessageDialog(this, "Persona registrada en otro lado");
                    refrescar();
                }
            } catch (PersonaExistenteException | PersonaNoEncontradaException | EmpleadoNoexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jtxCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxCedulaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jtxCedulaKeyTyped

    private void jtxTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxTelefonoKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jtxTelefonoKeyTyped

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        Login lv = new Login();
        lv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginHuespedVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</edit

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginHuespedVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JPanel jpingreso;
    private javax.swing.JTextField jtxApellido;
    private javax.swing.JTextField jtxCedula;
    private javax.swing.JPasswordField jtxContrasenia;
    private javax.swing.JTextField jtxCorreo;
    private javax.swing.JTextField jtxDireccion;
    private javax.swing.JTextField jtxNombre;
    private javax.swing.JTextField jtxTelefono;
    // End of variables declaration//GEN-END:variables

    private void refrescar() {
        jtxTelefono.setText("");
        jtxCedula.setText("");
        jtxDireccion.setText("");
        jtxCorreo.setText("");
        jtxTelefono.setText("");
        jtxNombre.setText("");
        jtxApellido.setText("");

    }
}
