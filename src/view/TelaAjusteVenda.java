/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author User
 */
public class TelaAjusteVenda extends javax.swing.JFrame {

    /**
     * Creates new form TelaAjusteVenda
     */
    public TelaAjusteVenda() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAjusteVenda = new javax.swing.JTable();
        jLabelQtd = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jButtonConf = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCompra4 = new javax.swing.JMenuItem();
        jVenda4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jConsulta4 = new javax.swing.JMenuItem();
        jAlocacao3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTableAjusteVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Sub Produto", "Ativo", "Produto em Garantia", "Data Vencimento", "NET"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAjusteVenda.getTableHeader().setReorderingAllowed(false);
        jTableAjusteVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAjusteVendaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableAjusteVenda);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 20, 700, 180);

        jLabelQtd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelQtd.setText("Quantidade");
        getContentPane().add(jLabelQtd);
        jLabelQtd.setBounds(20, 230, 110, 50);
        getContentPane().add(jTextFieldQtd);
        jTextFieldQtd.setBounds(140, 240, 220, 40);

        jButtonConf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonConf.setText("Confirmar");
        jButtonConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConf);
        jButtonConf.setBounds(380, 240, 110, 40);

        jButtonCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCancel.setText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancel);
        jButtonCancel.setBounds(510, 240, 120, 40);

        jMenu1.setText("Arquivo");

        jMenuSair4.setText("Sair");
        jMenuSair4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSair4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuste");

        jCompra4.setText("Compra");
        jCompra4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCompra4ActionPerformed(evt);
            }
        });
        jMenu2.add(jCompra4);

        jVenda4.setText("Venda");
        jVenda4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVenda4ActionPerformed(evt);
            }
        });
        jMenu2.add(jVenda4);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Clientes");

        jConsulta4.setText("Consulta");
        jConsulta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsulta4ActionPerformed(evt);
            }
        });
        jMenu4.add(jConsulta4);

        jMenuBar1.add(jMenu4);

        jAlocacao3.setText("Menu");

        jMenuItem4.setText("Alocação");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jAlocacao3.add(jMenuItem4);

        jMenuBar1.add(jAlocacao3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSair4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSair4ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSair4ActionPerformed

    private void jCompra4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCompra4ActionPerformed
        TelaCompra telaCompra = new TelaCompra();
        telaCompra.setVisible(true);
    }//GEN-LAST:event_jCompra4ActionPerformed

    private void jVenda4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVenda4ActionPerformed
        TelaVenda telaVenda = new TelaVenda();
        telaVenda.setVisible(true);
    }//GEN-LAST:event_jVenda4ActionPerformed

    private void jConsulta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsulta4ActionPerformed
        TelaConsulta telaConsulta = new TelaConsulta();
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_jConsulta4ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jTableAjusteVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAjusteVendaMouseClicked
        TelaAjusteCompra ajuste = new TelaAjusteCompra();
        ajuste.setVisible(true);
    }//GEN-LAST:event_jTableAjusteVendaMouseClicked

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConfActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAjusteVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAjusteVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAjusteVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAjusteVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAjusteVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jAlocacao3;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonConf;
    private javax.swing.JMenuItem jCompra4;
    private javax.swing.JMenuItem jConsulta4;
    private javax.swing.JLabel jLabelQtd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuSair4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAjusteVenda;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JMenuItem jVenda4;
    // End of variables declaration//GEN-END:variables
}
