/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConexaoBD;
import controller.ConexaoException;
import controller.PosicaoCliente;
import java.sql.Date;
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
public class TelaVenda extends javax.swing.JFrame {

    Posicao mod = new Posicao();
    PosicaoCliente control = new PosicaoCliente();
    ConexaoBD conex = new ConexaoBD();
    TelaPrincipal principal;
    
    /**
     * Creates new form TelaAjusteVenda
     */
    public TelaVenda() {
        initComponents();
    }

    public TelaVenda(TelaPrincipal principal){
        this.principal = principal;
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
        jButtonConfirm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlocacao = new javax.swing.JTable();
        txtFieldPesquisa = new javax.swing.JTextField();
        buttonPesquisa = new javax.swing.JButton();
        jLabelAtivo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jAlocacao = new javax.swing.JMenu();
        jMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");
        getContentPane().setLayout(null);

        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableVenda.getTableHeader().setReorderingAllowed(false);
        jTableVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableVendaMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableVendaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableVenda);
        if (jTableVenda.getColumnModel().getColumnCount() > 0) {
            jTableVenda.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 210, 970, 280);

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
        jComboBoxItens.setBounds(320, 30, 385, 30);

        jButtonConfirm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonConfirm.setText("Confirmar Alocação");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirm);
        jButtonConfirm.setBounds(20, 140, 140, 30);

        jTableAlocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alocação Atual %", "Sugestão para Perfil"
            }
        ));
        jScrollPane1.setViewportView(jTableAlocacao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 270, 90);

        txtFieldPesquisa.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldPesquisa);
        txtFieldPesquisa.setBounds(820, 80, 150, 30);

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
        buttonPesquisa.setBounds(880, 130, 90, 35);

        jLabelAtivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelAtivo.setText("Ativo");
        getContentPane().add(jLabelAtivo);
        jLabelAtivo.setBounds(930, 30, 40, 40);

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

        setSize(new java.awt.Dimension(1003, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jTableVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendaMouseClicked
        Posicao vendas = new Posicao();
        ArrayList<Posicao> v = new ArrayList<Posicao>();
        
        int linha = jTableVenda.getSelectedRow();
        if (linha != -1) {
            String produto = (String) jTableVenda.getValueAt(linha, 0);
            vendas.setProduto(produto);
            String sub_produto = (String) jTableVenda.getValueAt(linha, 1);
            vendas.setSubproduto(sub_produto);
            String ativo = (String) jTableVenda.getValueAt(linha, 2);
            vendas.setAtivo(ativo);
            String garantia =(String) jTableVenda.getValueAt(linha, 3);
            vendas.setProdutoGarantia(garantia);
            Date dataVencimento = (Date) jTableVenda.getValueAt(linha, 4);
            vendas.setDataVencimento(dataVencimento);
            Float net = (Float) jTableVenda.getValueAt(linha, 5);
            vendas.setNet(net);
            v.add(vendas);
            
            TelaAjusteVenda ajuste = new TelaAjusteVenda(vendas);
            ajuste.setVisible(true);
            
        }
               
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
                        + "FROM alocacao.catalogo_op AS cat INNER JOIN alocacao.alocacoes AS al\n"
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

    private void jTableVendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendaMousePressed
    }//GEN-LAST:event_jTableVendaMousePressed

    private void jTableVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendaMouseEntered
    }//GEN-LAST:event_jTableVendaMouseEntered

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        // passar os dados para tela principal
        
    }//GEN-LAST:event_jButtonConfirmActionPerformed

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

    private void txtFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPesquisaActionPerformed

    private void buttonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisaActionPerformed

        mod.setPesquisa(txtFieldPesquisa.getText());


    }//GEN-LAST:event_buttonPesquisaActionPerformed

    public void preencherTabela(String sql) throws ConexaoException, ClassNotFoundException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Produto", "Sub Produto", "Ativo","Produto em Garantia", "Data Vencimento", "NET"};

        try {
            conex.open();

            conex.executaSql(sql);

            conex.rs.first();
            do {
                Object[] tabela = new Object[]{conex.rs.getString("produto"), conex.rs.getString("sub_produto"),
                    conex.rs.getString("ativo"), conex.rs.getString("garantia"),
                    conex.rs.getString("data_vencimento"), conex.rs.getFloat("NET")
                };
                dados.add(tabela);               
            } while (conex.rs.next());

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao obter dados.");
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            conex.close();
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTableVenda.setModel(modelo);
        jTableVenda.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTableVenda.getColumnModel().getColumn(0).setResizable(false);
        jTableVenda.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableVenda.getColumnModel().getColumn(1).setResizable(false);
        jTableVenda.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableVenda.getColumnModel().getColumn(2).setResizable(false);
        jTableVenda.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableVenda.getColumnModel().getColumn(3).setResizable(false);
        jTableVenda.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTableVenda.getColumnModel().getColumn(4).setResizable(false);
        jTableVenda.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableVenda.getColumnModel().getColumn(5).setResizable(false);

        jTableVenda.getTableHeader().setReorderingAllowed(false);
        jTableVenda.setAutoResizeMode(jTableVenda.AUTO_RESIZE_OFF);
        jTableVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    
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
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPesquisa;
    private javax.swing.JMenu jAlocacao;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JComboBox<String> jComboBoxItens;
    private javax.swing.JLabel jLabelAtivo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlocacao;
    private javax.swing.JTable jTableVenda;
    private javax.swing.JTextField txtFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
