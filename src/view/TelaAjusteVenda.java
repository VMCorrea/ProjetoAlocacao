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
public class TelaAjusteVenda extends javax.swing.JFrame {

    Posicao mod = new Posicao();
    PosicaoCliente control = new PosicaoCliente();
    ConexaoBD conex = new ConexaoBD();
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
        jTableVenda = new javax.swing.JTable();
        jComboBoxItens = new javax.swing.JComboBox<>();
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
        setTitle("Vendas");
        getContentPane().setLayout(null);

        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableVenda.getTableHeader().setReorderingAllowed(false);
        jTableVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableVenda);
        if (jTableVenda.getColumnModel().getColumnCount() > 0) {
            jTableVenda.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 210, 700, 280);

        jComboBoxItens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxItens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Selecione uma das opções >", "Renda Fixa Pós com liquidez (LFT, CDBs, Fundos DI, Poupança)", "Renda Fixa Pós sem liquidez (LC, LCIs, LCAs, CDB longo)", "Renda Fixa Pós Crédito Privado (sem FGC - CRI, CRA, Deb)", "Renda Fixa Pré com liquidez (LTNs, NTN-F)", "Renda Fixa Pré sem liquidez (CDBs, LCs)", "Renda Fixa Pré Crédito Privado (LF, Debentures)", "Renda Fixa IPCA com liquidez (NTN-B)", "Renda Fixa IPCA sem liquidez (CDBs, LCs)", "Renda Fixa IPCA Crédito Privado (CRI, CRA, Debentures)", "Multimercado Baixa Vol (até 1.5%)", "Multimercado Média Vol (de 1.5% até 4%)", "Multimercado Alta Vol (acima de 4%)", "Fundos Imobiliários", "Carteira de Ações", "Fundos Internacionas sem hedge", "Proteção (Seguro Vida)", "Carteira Offshore (FX)" }));
        jComboBoxItens.setToolTipText("Opções Compra");
        jComboBoxItens.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBoxItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxItensActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxItens);
        jComboBoxItens.setBounds(130, 20, 385, 30);

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

        setSize(new java.awt.Dimension(732, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSair4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSair4ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSair4ActionPerformed

    private void jCompra4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCompra4ActionPerformed
        TelaAjusteCompra telaCompra = new TelaAjusteCompra();
        telaCompra.setVisible(true);
    }//GEN-LAST:event_jCompra4ActionPerformed

    private void jVenda4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVenda4ActionPerformed
        TelaAjusteVenda telaVenda = new TelaAjusteVenda();
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

    private void jTableVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendaMouseClicked
        TelaAjuste ajuste = new TelaAjuste();
        ajuste.setVisible(true);
    }//GEN-LAST:event_jTableVendaMouseClicked

    private void jComboBoxItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxItensActionPerformed
        String[] mensagem = {"< Selecione uma das opções >",
            "Renda Fixa Pós com liquidez (LFT, CDBs, Fundos DI, Poupança)",
            "Renda Fixa Pós sem liquidez (LC, LCIs, LCAs, CDB longo)",
            "Renda Fixa Pós Crédito Privado (sem FGC - CRI, CRA, Deb)",
            "Renda Fixa Pré com liquidez (LTNs, NTN-F)",
            "Renda Fixa Pré sem liquidez (CDBs, LCs)",
            "Renda Fixa Pré Crédito Privado (LF, Debentures)",
            "Renda Fixa IPCA com liquidez (NTN-B)",
            "Renda Fixa IPCA sem liquidez (CDBs, LCs)",
            "Renda Fixa IPCA Crédito Privado (CRI, CRA, Debentures)",
            "Multimercado Baixa Vol (até 1.5%)",
            "Multimercado Média Vol (de 1.5% até 4%)",
            "Multimercado Alta Vol (acima de 4%)",
            "Fundos Imobiliários",
            "Carteira de Ações",
            "Fundos Internacionas sem hedge",
            "Proteção (Seguro Vida)",
            "Carteira Offshore (FX)"};

        if (jComboBoxItens.getSelectedItem() == mensagem[0]) {
            JOptionPane.showMessageDialog(null, "Selecione uma das opções.");
        } else if (jComboBoxItens.getSelectedItem() == mensagem[jComboBoxItens.getSelectedIndex()]) {
            try {
                
                preencherTabela("SELECT cat.produto, cat.sub_produto, cat.ativo, cat.garantia, cat.data_vencimento, al.net\n"
                        + "FROM alocacao.catalogo_op AS cat JOIN alocacao.alocacoes AS al\n"
                        + "ON al.catalogo_id = cat.id\n"
                        + "WHERE cat.classificacao = '" + mensagem[jComboBoxItens.getSelectedIndex()] + "'");
            
            } catch (ConexaoException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar dados. " + ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro " + ex);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }
        }

    }//GEN-LAST:event_jComboBoxItensActionPerformed

    public void preencherTabela(String sql) throws ConexaoException, ClassNotFoundException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Produto", "Sub Produto", "Ativo","Produto em Garantia", "Data Vencimento", "NET"};

        conex.open();
        conex.executaSql(sql);

        try {
            conex.rs.first();
            do {
                Object[] tabela = new Object[]{conex.rs.getString("produto"), conex.rs.getString("sub_produto"),
                    conex.rs.getString("ativo"), conex.rs.getString("garantia"),
                    conex.rs.getString("data_vencimento"), conex.rs.getFloat("NET")
                };
                dados.add(tabela);
            } while (conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher.");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTableVenda.setModel(modelo);
        jTableVenda.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTableVenda.getColumnModel().getColumn(0).setResizable(false);
        jTableVenda.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableVenda.getColumnModel().getColumn(1).setResizable(false);
        jTableVenda.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableVenda.getColumnModel().getColumn(2).setResizable(false);
        jTableVenda.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableVenda.getColumnModel().getColumn(3).setResizable(false);
        jTableVenda.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTableVenda.getColumnModel().getColumn(4).setResizable(false);
        jTableVenda.getColumnModel().getColumn(5).setPreferredWidth(30);
        jTableVenda.getColumnModel().getColumn(5).setResizable(false);

        jTableVenda.getTableHeader().setReorderingAllowed(false);
        jTableVenda.setAutoResizeMode(jTableVenda.AUTO_RESIZE_OFF);
        jTableVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.close();

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
    private javax.swing.JComboBox<String> jComboBoxItens;
    private javax.swing.JMenuItem jCompra4;
    private javax.swing.JMenuItem jConsulta4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuSair4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVenda;
    private javax.swing.JMenuItem jVenda4;
    // End of variables declaration//GEN-END:variables
}
