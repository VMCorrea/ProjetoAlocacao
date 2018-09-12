package view;

import controller.SugarConnect;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import static javafx.application.Platform.exit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import model.Usuario;
import controller.ConexaoBD;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Beatriz.aurelio
 */
public class TelaLogin extends javax.swing.JFrame {

    private String login; 
    private String pwd;
    
    public TelaLogin() {
        
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameAutentica = new javax.swing.JInternalFrame();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new java.awt.TextField();
        lblSenha = new javax.swing.JLabel();
        botaoCancel = new java.awt.Button();
        txtSenha = new javax.swing.JPasswordField();
        botaoEnviar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jFrameAutentica.setClosable(true);
        jFrameAutentica.setResizable(true);
        jFrameAutentica.setTitle("Autenticacao");
        jFrameAutentica.setVisible(true);
        jFrameAutentica.getContentPane().setLayout(null);

        lblLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLogin.setText("Login");
        jFrameAutentica.getContentPane().add(lblLogin);
        lblLogin.setBounds(10, 13, 43, 27);

        txtLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        jFrameAutentica.getContentPane().add(txtLogin);
        txtLogin.setBounds(86, 10, 139, 30);

        lblSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSenha.setText("Senha");
        jFrameAutentica.getContentPane().add(lblSenha);
        lblSenha.setBounds(10, 67, 36, 23);

        botaoCancel.setBackground(new java.awt.Color(204, 204, 204));
        botaoCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.E_RESIZE_CURSOR));
        botaoCancel.setLabel("Cancelar");
        botaoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelActionPerformed(evt);
            }
        });
        jFrameAutentica.getContentPane().add(botaoCancel);
        botaoCancel.setBounds(155, 123, 66, 24);
        botaoCancel.getAccessibleContext().setAccessibleDescription("");

        txtSenha.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        jFrameAutentica.getContentPane().add(txtSenha);
        txtSenha.setBounds(86, 64, 139, 30);

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
        jFrameAutentica.getContentPane().add(botaoEnviar);
        botaoEnviar.setBounds(86, 123, 50, 24);

        getContentPane().add(jFrameAutentica);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelActionPerformed
      dispose(); 
    }//GEN-LAST:event_botaoCancelActionPerformed

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        
        setLogin(txtLogin.getText());
        setPwd(txtSenha.getPassword());
          
        if (this.checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Bem vindo!");
                new TelaPrincipal().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dados invalidos!");
            }
        
    }//GEN-LAST:event_botaoEnviarActionPerformed

    private void botaoEnviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEnviarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Bem vindo!");
                new TelaPrincipal().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dados invalidos!");
            }
        }
    }//GEN-LAST:event_botaoEnviarKeyPressed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed

    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

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
    private java.awt.TextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void setLogin(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setPwd(char[] password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean checkLogin(String login, String senha){
        
        return login.equals("lifetime") && senha.equals("lifetime");
    }
   
}
