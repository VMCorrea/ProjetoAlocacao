/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SugarConnect;
import java.awt.TextField;
import static javafx.application.Platform.exit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


/**
 *
 * @author Beatriz.aurelio
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameAutentica = new javax.swing.JInternalFrame();
        lblLogin = new javax.swing.JLabel();
        txtField = new java.awt.TextField();
        lblSenha = new javax.swing.JLabel();
        botaoCancel = new java.awt.Button();
        passwordField = new javax.swing.JPasswordField();
        botaoEnviar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jFrameAutentica.setClosable(true);
        jFrameAutentica.setResizable(true);
        jFrameAutentica.setTitle("Autenticacao");
        jFrameAutentica.setVisible(true);
        jFrameAutentica.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLogin.setText("Login");
        jFrameAutentica.getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 43, 27));

        txtField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldActionPerformed(evt);
            }
        });
        jFrameAutentica.getContentPane().add(txtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 10, 139, 30));

        lblSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSenha.setText("Senha");
        jFrameAutentica.getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, 23));

        botaoCancel.setBackground(new java.awt.Color(204, 204, 204));
        botaoCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.E_RESIZE_CURSOR));
        botaoCancel.setLabel("Cancelar");
        botaoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelActionPerformed(evt);
            }
        });
        jFrameAutentica.getContentPane().add(botaoCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 123, -1, -1));
        botaoCancel.getAccessibleContext().setAccessibleDescription("");

        passwordField.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jFrameAutentica.getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 64, 139, 30));

        botaoEnviar.setActionCommand("buttonEnviar");
        botaoEnviar.setBackground(new java.awt.Color(204, 204, 204));
        botaoEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.E_RESIZE_CURSOR));
        botaoEnviar.setLabel("Enviar");
        botaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarActionPerformed(evt);
            }
        });
        botaoEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEnviarKeyPressed(evt);
            }
        });
        jFrameAutentica.getContentPane().add(botaoEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 123, -1, -1));

        getContentPane().add(jFrameAutentica);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelActionPerformed
      dispose(); 
    }//GEN-LAST:event_botaoCancelActionPerformed

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        String name = txtField.getText();
        String pwd = passwordField.getText();
          
                 
        if(name.equals("lifetime") && pwd.equals("lifetime")){
            JOptionPane.showMessageDialog(null, "Bem-vindo.");
            TelaMenu menu = new TelaMenu();
            menu.setVisible(true);
            dispose();

        } else{
            JOptionPane.showMessageDialog(null, "Credencias invalidas.");
            dispose();
        }
    }//GEN-LAST:event_botaoEnviarActionPerformed

    private void botaoEnviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEnviarKeyPressed
        
    }//GEN-LAST:event_botaoEnviarKeyPressed

    private void txtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldActionPerformed

    }//GEN-LAST:event_txtFieldActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button botaoCancel;
    private java.awt.Button botaoEnviar;
    private javax.swing.JInternalFrame jFrameAutentica;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField passwordField;
    private java.awt.TextField txtField;
    // End of variables declaration//GEN-END:variables
}
