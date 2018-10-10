/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConexaoException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.ModeloTabela;
import model.Posicao;
import model.Produto;

/**
 *
 * @author Beatriz.aurelio
 */
public class TelaAjusteCompra extends javax.swing.JFrame {

    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonConf;
    private javax.swing.JLabel jLabelQtd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAjusteCompra;
    public javax.swing.JTextField jTextFieldAjuste;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    public TelaCompra tela;
    /**
     * Creates new form TelaAjuste
     */
    public TelaAjusteCompra() {
        initComponents();
    }    

    public TelaAjusteCompra(TelaCompra tela) {
        initComponents();
        this.tela = tela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabelQtd = new javax.swing.JLabel();
        jTextFieldAjuste = new javax.swing.JTextField();
        jButtonConf = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAjusteCompra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelQtd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelQtd.setText("Ajuste %");
        getContentPane().add(jLabelQtd);
        jLabelQtd.setBounds(30, 150, 70, 40);

        jTextFieldAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAjusteActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAjuste);
        jTextFieldAjuste.setBounds(120, 150, 160, 40);

        jButtonConf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonConf.setText("Confirmar");
        jButtonConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConf);
        jButtonConf.setBounds(120, 200, 100, 40);

        jButtonCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCancel.setText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancel);
        jButtonCancel.setBounds(120, 250, 100, 40);

        jTableAjusteCompra.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTableAjusteCompra.setModel(new javax.swing.table.DefaultTableModel(
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

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButtonConf, org.jdesktop.beansbinding.ObjectProperty.create(), jTableAjusteCompra, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);
        binding.bind();
        jScrollPane1.setViewportView(jTableAjusteCompra);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 1270, 80);

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1299, 359));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAjusteActionPerformed
        //Ajustes ajustes = new Ajustes();
        
    }//GEN-LAST:event_jTextFieldAjusteActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfActionPerformed
        //criar objeto e armazenar no objeto o ajuste da % e tudo da tabela OU o ativo, como PK


        Object[] tabela = new Object[]{
                jTableAjusteCompra.getModel().getValueAt(0,0),
                jTableAjusteCompra.getModel().getValueAt(0,1),
                jTableAjusteCompra.getModel().getValueAt(0,2),
                jTableAjusteCompra.getModel().getValueAt(0,3),
                jTableAjusteCompra.getModel().getValueAt(0,4),
                jTableAjusteCompra.getModel().getValueAt(0,5),
                jTextFieldAjuste.getText()
        };
        tela.addItemCart(tabela);

    }//GEN-LAST:event_jButtonConfActionPerformed

    public void adicionaLinha(Produto objCompras) {

        try {
            preencherTabela(objCompras);

        } catch (ConexaoException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar dados. " + ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro " + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro NullPointer: " + ex);
        }
    }
    
    public void preencherTabela(Produto objCompras) throws ConexaoException, ClassNotFoundException {
      ArrayList dados = new ArrayList();
      String[] colunas = new String[]{"Produto", "Sub Produto", "CNPJ", "Ativo", "Emissor", "Data Vencimento"};
      
      dados.add(objCompras);              
        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTableAjusteCompra.setModel(modelo);
        jTableAjusteCompra.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTableAjusteCompra.getColumnModel().getColumn(0).setResizable(false);
        jTableAjusteCompra.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTableAjusteCompra.getColumnModel().getColumn(1).setResizable(false);
        jTableAjusteCompra.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableAjusteCompra.getColumnModel().getColumn(2).setResizable(false);
        jTableAjusteCompra.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTableAjusteCompra.getColumnModel().getColumn(3).setResizable(false);
        jTableAjusteCompra.getColumnModel().getColumn(4).setPreferredWidth(345);
        jTableAjusteCompra.getColumnModel().getColumn(4).setResizable(false);
        jTableAjusteCompra.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTableAjusteCompra.getColumnModel().getColumn(5).setResizable(false);

        jTableAjusteCompra.getTableHeader().setReorderingAllowed(false);
        jTableAjusteCompra.setAutoResizeMode(jTableAjusteCompra.AUTO_RESIZE_OFF);
        jTableAjusteCompra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

    // End of variables declaration//GEN-END:variables
}
