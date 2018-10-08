/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.ConexaoBD;
import controller.ConexaoException;
import controller.PosicaoCliente;
import controller.SugarConnection;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import model.Posicao;


/**
 *
 * @author Beatriz.aurelio
 */
public class TelaConsulta extends javax.swing.JFrame {
      
    Posicao mod = new Posicao();
    PosicaoCliente control = new PosicaoCliente();
    ConexaoBD conex = new ConexaoBD();
    
    public TelaConsulta() {
        /*
        TelaLogin telaLogin = new TelaLogin();
        if(telaLogin.login == true){
            initComponents();
        }else{
            JOptionPane.showMessageDialog(null, "Faça Login!");
            telaLogin.setVisible(true);
            this.setVisible(false);
        }
        */
        initComponents();        
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        buttonPesquisa = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtFieldPesquisa = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(397, 463, 0, 0);

        buttonPesquisa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonPesquisa.setText("Pesquisa");
        buttonPesquisa.setMaximumSize(new java.awt.Dimension(100, 40));
        buttonPesquisa.setMinimumSize(new java.awt.Dimension(100, 40));
        buttonPesquisa.setPreferredSize(new java.awt.Dimension(90, 35));
        buttonPesquisa.setVerifyInputWhenFocusTarget(false);
        buttonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPesquisa);
        buttonPesquisa.setBounds(30, 140, 90, 35);

        lblCodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCodigo.setText("Codigo Cliente");
        lblCodigo.setMaximumSize(new java.awt.Dimension(90, 20));
        lblCodigo.setMinimumSize(new java.awt.Dimension(90, 20));
        lblCodigo.setPreferredSize(new java.awt.Dimension(90, 30));
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(30, 40, 100, 30);

        txtFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPesquisaActionPerformed(evt);
            }
        });
        txtFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldPesquisaKeyPressed(evt);
            }
        });
        getContentPane().add(txtFieldPesquisa);
        txtFieldPesquisa.setBounds(30, 80, 90, 30);

        jMenu1.setText("Arquivo");

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(162, 262));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisaActionPerformed
        pesquisar();
    }//GEN-LAST:event_buttonPesquisaActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if(sair == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void txtFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPesquisaActionPerformed
    }//GEN-LAST:event_txtFieldPesquisaActionPerformed

    private void txtFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisar();
        }
    }//GEN-LAST:event_txtFieldPesquisaKeyPressed
      
    void pesquisar(){
        TelaPrincipal principal = new TelaPrincipal();
        SugarConnection sugar = new SugarConnection();
        try {
            if(sugar.isClient(txtFieldPesquisa.getText())){
                principal.preencherColunas(txtFieldPesquisa.getText());
                principal.preencherLabel(txtFieldPesquisa.getText());

                principal.setVisible(true);
                TelaConsulta consulta = new TelaConsulta();
                consulta.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Cliente inválido.");
            }
        } catch (ConexaoException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar dados. " + ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro " + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }
    
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
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTextField txtFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
