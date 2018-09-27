/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.ConexaoBD;
import controller.ConexaoException;
import controller.PosicaoCliente;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.ModeloTabela;
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
        txtFieldPesquisa = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jAlocacao = new javax.swing.JMenu();
        jMenuItem = new javax.swing.JMenuItem();

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

        txtFieldPesquisa.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldPesquisa);
        txtFieldPesquisa.setBounds(30, 90, 90, 30);

        lblCodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCodigo.setText("Codigo Cliente");
        lblCodigo.setMaximumSize(new java.awt.Dimension(90, 20));
        lblCodigo.setMinimumSize(new java.awt.Dimension(90, 20));
        lblCodigo.setPreferredSize(new java.awt.Dimension(90, 30));
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(30, 40, 90, 30);

        jMenu1.setText("Arquivo");

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair);

        jMenuBar1.add(jMenu1);

        jAlocacao.setText("Menu");

        jMenuItem.setText("Alocação");
        jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActionPerformed(evt);
            }
        });
        jAlocacao.add(jMenuItem);

        jMenuBar1.add(jAlocacao);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(162, 262));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisaActionPerformed
        
         mod.setPesquisa(txtFieldPesquisa.getText());
         /*
           preencherTabela("SELECT cat.classificacao, cat.sub_produto, cat.ativo, cat.data_vencimento, aloc.NET \n"
                    + "FROM alocacao.catalogo_op AS cat JOIN alocacao.alocacoes AS aloc\n"
                    + "ON cat.id = aloc.id\n"
                    + "WHERE aloc.cliente_id = '" + mod.getPesquisa() + "'");
         */
         TelaPrincipal principal= new TelaPrincipal();
         principal.setVisible(true);
        
    }//GEN-LAST:event_buttonPesquisaActionPerformed

    private void txtFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPesquisaActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if(sair == JOptionPane.YES_OPTION){
            dispose();
            //System.exit(0);
        }
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActionPerformed
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
    }//GEN-LAST:event_jMenuItemActionPerformed
      
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
    private javax.swing.JMenu jAlocacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTextField txtFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
