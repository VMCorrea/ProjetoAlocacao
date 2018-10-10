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
import model.Produto;

/**
 *
 * @author User
 */
public class TelaCompra extends javax.swing.JFrame {

    PosicaoCliente control = new PosicaoCliente();
    ConexaoBD conex = new ConexaoBD();
    TelaPrincipal principal;
    ArrayList compras;
    ArrayList tabelaCompras;


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

    /**
     * Creates new form TelaDeVenda
     */
    public TelaCompra() {
        initComponents();
        
    }
    public TelaCompra(TelaPrincipal principal){
        this.principal = principal;
        initComponents();
    }

    public void addItemCart(Object obj[]) {
        compras.add(obj);
        ArrayList e;
        Object o[] = new Object[]{
                obj[3].toString(),
                Double.parseDouble(obj[6].toString())
        };
        tabelaCompras.add(o);
        String s[] = new String [] {
                "Categoria", "Ativo", "% Comprada"
        };

        ModeloTabela modelo = new ModeloTabela(tabelaCompras, s);
        jTableAlocacao.setModel(modelo);
        jTableAlocacao.getColumnModel().getColumn(0).setPreferredWidth(180);
        jTableAlocacao.getColumnModel().getColumn(0).setResizable(false);
        jTableAlocacao.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTableAlocacao.getColumnModel().getColumn(1).setResizable(false);
        jTableAlocacao.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableAlocacao.getColumnModel().getColumn(3).setResizable(false);
        jTableAlocacao.getTableHeader().setReorderingAllowed(false);
        jTableAlocacao.setAutoResizeMode(jTableAlocacao.AUTO_RESIZE_OFF);
        jTableAlocacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxItem = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlocacao = new javax.swing.JTable();
        jButtonConfirm = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCompra = new javax.swing.JTable();
        txtFieldPesquisa = new javax.swing.JTextField();
        buttonPesquisa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jAlocacao = new javax.swing.JMenu();
        jMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBoxItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Selecione uma das opções >", "Renda Fixa Pós com liquidez (LFT, CDBs, Fundos DI, Poupança)", "Renda Fixa Pós sem liquidez (LC, LCIs, LCAs, CDB longo)", "Renda Fixa Pós Crédito Privado (sem FGC - CRI, CRA, Deb)", "Renda Fixa Pré com liquidez (LTNs, NTN-F)", "Renda Fixa Pré sem liquidez (CDBs, LCs)", "Renda Fixa Pré Crédito Privado (LF, Debentures)", "Renda Fixa IPCA com liquidez (NTN-B)", "Renda Fixa IPCA sem liquidez (CDBs, LCs)", "Renda Fixa IPCA Crédito Privado (CRI, CRA, Debentures)", "Multimercado Baixa Vol (até 1.5%)", "Multimercado Média Vol (de 1.5% até 4%)", "Multimercado Alta Vol (acima de 4%)", "Fundos Imobiliários", "Carteira de Ações", "Fundos Internacionas sem hedge", "Proteção (Seguro Vida)", "Carteira Offshore (FX)" }));
        jComboBoxItem.setToolTipText("Opções Compra");
        jComboBoxItem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBoxItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxItemActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxItem);
        jComboBoxItem.setBounds(20, 30, 385, 30);

        jTableAlocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Ativo", "% Comprada"
            }
        ));
        jScrollPane1.setViewportView(jTableAlocacao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(880, 20, 380, 100);

        jButtonConfirm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonConfirm.setText("Confirmar Alocação");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirm);
        jButtonConfirm.setBounds(1120, 140, 140, 30);

        jTableCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCompraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableCompraMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableCompra);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(80, 210, 1190, 620);

        txtFieldPesquisa.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldPesquisa);
        txtFieldPesquisa.setBounds(650, 40, 140, 30);

        buttonPesquisa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonPesquisa.setText("Pesquisar");
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
        buttonPesquisa.setBounds(700, 90, 90, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Emissor");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 30, 80, 40);

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

        setSize(new java.awt.Dimension(1299, 913));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxItemActionPerformed
        if (jComboBoxItem.getSelectedItem() == mensagem[0]) {
            JOptionPane.showMessageDialog(null, "Selecione uma das opções.");
        } else if (jComboBoxItem.getSelectedItem() == mensagem[jComboBoxItem.getSelectedIndex()]) {
            try {

                preencherTabela("SELECT cat.produto, cat.sub_produto, cat.cnpj, cat.ativo, cat.emissor, cat.data_vencimento\n"
                    + "FROM alocacao.catalogo_op AS cat\n"
                    + "WHERE cat.classificacao = '" + mensagem[jComboBoxItem.getSelectedIndex()] + "'");

            } catch (ConexaoException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar dados. " + ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro " + ex);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }
        }
    }//GEN-LAST:event_jComboBoxItemActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if(sair == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActionPerformed
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
    }//GEN-LAST:event_jMenuItemActionPerformed

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar?");
        if(confirm == JOptionPane.YES_OPTION){
        

            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
            
            // passar as porcentagens para tela principal 
            // passar mudança de alocação para banco de dados >>>>>>>> 
            /*
            alocacaoRS --- alocacao%
            ajusteassessorRS --- ajusteassessor%
            (x = ajusteassessorRS)
            */
        }

    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void txtFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPesquisaActionPerformed
        pesquisa();
    }//GEN-LAST:event_txtFieldPesquisaActionPerformed

    private void buttonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisaActionPerformed
        pesquisa();
    }//GEN-LAST:event_buttonPesquisaActionPerformed

    private void jTableCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCompraMouseClicked
    }//GEN-LAST:event_jTableCompraMouseClicked

    private void jTableCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCompraMousePressed
        int linha = jTableCompra.getSelectedRow();
        if (linha != -1) {
            Produto nova = new Produto();
            nova.setProduto((String) jTableCompra.getValueAt(linha, 0));
            nova.setSubproduto((String) jTableCompra.getValueAt(linha, 1));
            nova.setCnpj((String) jTableCompra.getValueAt(linha, 2));
            nova.setAtivo((String) jTableCompra.getValueAt(linha, 3));
            nova.setEmissor((String) jTableCompra.getValueAt(linha, 4));
            nova.setDataVencimento((Date) jTableCompra.getValueAt(linha, 5));
            nova.setClassificacao((String) jComboBoxItem.getSelectedItem());
            
            TelaAjusteCompra tela = new TelaAjusteCompra(this);
            tela.adicionaLinha(nova);
            tela.setVisible(true);
        }
    }//GEN-LAST:event_jTableCompraMousePressed

    public void preencherTabelaAloc() {

    }

    
    public void preencherTabela(String sql) throws ConexaoException, ClassNotFoundException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Produto", "Sub Produto", "CNPJ", "Ativo", "Emissor", "Data Vencimento", "Classificacao"};

       try {
            conex.open();

            conex.executaSql(sql);

            conex.rs.first();
            do {
                Produto tabela = new Produto(conex.rs.getString("produto"), conex.rs.getString("sub_produto"),
                    conex.rs.getString("cnpj"), conex.rs.getString("ativo"), conex.rs.getString("emissor"),
                    conex.rs.getDate("data_vencimento"), (String)jComboBoxItem.getSelectedItem()
                        );
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

        jTableCompra.setModel(modelo);
        jTableCompra.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTableCompra.getColumnModel().getColumn(0).setResizable(false);
        jTableCompra.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTableCompra.getColumnModel().getColumn(1).setResizable(false);
        jTableCompra.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableCompra.getColumnModel().getColumn(2).setResizable(false);
        jTableCompra.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTableCompra.getColumnModel().getColumn(3).setResizable(false);
        jTableCompra.getColumnModel().getColumn(4).setPreferredWidth(345);
        jTableCompra.getColumnModel().getColumn(4).setResizable(false);
        jTableCompra.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTableCompra.getColumnModel().getColumn(5).setResizable(false);
        jTableCompra.getTableHeader().setReorderingAllowed(false);
        jTableCompra.setAutoResizeMode(jTableCompra.AUTO_RESIZE_OFF);
        jTableCompra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


    }
    void pesquisa(){try {
            preencherTabela("SELECT cat.produto, cat.sub_produto, cat.cnpj, cat.ativo, cat.emissor, cat.data_vencimento\n"
                    + "FROM alocacao.catalogo_op AS cat\n"
                    + "WHERE ((cat.classificacao = '" + mensagem[jComboBoxItem.getSelectedIndex()] + "') AND (cat.emissor LIKE '%" + txtFieldPesquisa.getText() + "%')) ");
        } catch (ConexaoException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar. " + ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro " + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        txtFieldPesquisa.setText("");
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
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPesquisa;
    private javax.swing.JMenu jAlocacao;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JComboBox<String> jComboBoxItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAlocacao;
    private javax.swing.JTable jTableCompra;
    private javax.swing.JTextField txtFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
