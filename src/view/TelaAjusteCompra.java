/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Beatriz.aurelio
 */
public class TelaAjusteCompra extends javax.swing.JFrame {

    /**
     * Creates new form TelaAjuste
     */
    public TelaAjusteCompra() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabelQtd = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jButtonConf = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelQtd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelQtd.setText("Quantidade");
        getContentPane().add(jLabelQtd);
        jLabelQtd.setBounds(10, 290, 90, 40);

        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldQtd);
        jTextFieldQtd.setBounds(110, 290, 160, 40);

        jButtonConf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonConf.setText("Confirmar");
        jButtonConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConf);
        jButtonConf.setBounds(290, 290, 100, 40);

        jButtonCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCancel.setText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancel);
        jButtonCancel.setBounds(400, 290, 100, 40);

        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Sub Produto", "CNPJ", "Ativo", "Emissor", "Data Vencimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButtonConf, org.jdesktop.beansbinding.ObjectProperty.create(), jTable1, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);
        binding.bind();
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 700, 80);

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

        bindingGroup.bind();

        setSize(new java.awt.Dimension(744, 412));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSair4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSair4ActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if(sair == JOptionPane.YES_OPTION){
            dispose();
            //System.exit(0);
        }
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

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
        
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfActionPerformed
        
        /*
        JConsultaProfissao frm = new JConsultaProfissao(new JFrame(), true);
	frm.setVisible(true);

	if(frm.isConfirmado){
		Profissao p = frm.getProfissao();
		jComboBox3;setSelectedItem(p);
	}
*/
        
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
            java.util.logging.Logger.getLogger(TelaAjusteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAjusteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAjusteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAjusteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAjusteCompra().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JMenuItem jVenda4;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}