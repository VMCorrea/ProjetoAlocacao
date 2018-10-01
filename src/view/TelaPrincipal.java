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
import javax.swing.JTextField;
import model.Posicao;

/**
 *
 * @author Beatriz.aurelio
 */
public class TelaPrincipal extends javax.swing.JFrame {

    Posicao mod = new Posicao();
    PosicaoCliente control = new PosicaoCliente();
    ConexaoBD conex = new ConexaoBD();
    /**
     * Creates new form Tela
     */
    public TelaPrincipal() {
        initComponents();
    }
    
    void preencherLabel(String codigo) throws ConexaoException, ClassNotFoundException {
        String sql = "SELECT nome FROM alocacao.clientes WHERE codCorretora = " + codigo;
        try {
            conex.open();
            conex.executaSql(sql);
            conex.rs.first();
            
            String nome = conex.rs.getString("nome");
            jNomeCliente.setText(nome);
            jCodigoCliente.setText(codigo);
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao obter dados.");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            conex.close();
        }
    }
    
    void preencherColunas(String pesquisa) throws ConexaoException, ClassNotFoundException {    
        
        String[] classificacao = {"Renda Fixa Pós com liquidez (LFT, CDBs, Fundos DI, Poupança)",
            "Renda Fixa Pós sem liquidez (LC, LCIs, LCAs, CDB longo)",
            "Renda Fixa Pós Crédito Privado (sem FGC - CRI, CRA, Deb)",
            "Renda Fixa Pré com liquidez (LTNs, NTN-F)", "Renda Fixa Pré sem liquidez (CDBs, LCs)",
            "Renda Fixa Pré Crédito Privado (LF, Debentures)",
            "Renda Fixa IPCA com liquidez (NTN-B)", "Renda Fixa IPCA sem liquidez (CDBs, LCs)",
            "Renda Fixa IPCA Crédito Privado (CRI, CRA, Debentures)",
            "Multimercado Baixa Vol (até 1.5%)", "Multimercado Média Vol (de 1.5% até 4%)", 
            "Multimercado Alta Vol (Acima de 4%)", "Fundos Imobiliários", "Carteira de Ações", 
            "Fundos Internacionas sem hedge", "Proteção (Seguro Vida)", "Carteira Offshore (FX)"};
        JTextField alocacao[] = {alocacaoAtual1, alocacaoAtual2, alocacaoAtual3, alocacaoAtual4, alocacaoAtual5,
            alocacaoAtual6, alocacaoAtual7, alocacaoAtual8, alocacaoAtual9, alocacaoAtual10, alocacaoAtual11,
            alocacaoAtual12, alocacaoAtual13, alocacaoAtual14, alocacaoAtual15, alocacaoAtual16, alocacaoAtual17
        };
        
        for(int i=0; i<alocacao.length; i++){
            String sql = "SELECT cat.classificacao as class, SUM(al.NET) as soma FROM alocacao.catalogo_op AS cat \n"
                    + "INNER JOIN alocacao.alocacoes AS al ON al.catalogo_id = cat.id \n"
                    + "INNER JOIN alocacao.clientes AS cl ON cl.codCorretora = al.cliente_id\n"
                    + "WHERE al.cliente_id = '" + pesquisa + "' AND cat.classificacao = '" + classificacao[i] + "'\n"
                    + "GROUP BY cat.classificacao";
            try {
                conex.open();
                conex.executaSql(sql);
                conex.rs.first();

                String alocacaoAtual = conex.rs.getString("soma");
                alocacao[i].setText(alocacaoAtual);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao obter dados.");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } finally {
                conex.close();
            }
        }
        
    }
 /* 
    {alocacaoAtual1.getName(), alocacaoAtual2.getName(), alocacaoAtual3.getName(), 
            alocacaoAtual4.getName(), alocacaoAtual5.getName(), alocacaoAtual6.getName(), alocacaoAtual7.getName(), 
            alocacaoAtual8.getName(), alocacaoAtual9.getName(), alocacaoAtual10.getName(), alocacaoAtual11.getName(),
            alocacaoAtual12.getName(), alocacaoAtual13.getName(), alocacaoAtual14.getName(), alocacaoAtual15.getName(), 
            alocacaoAtual16.getName(), alocacaoAtual17.getName()};
    
    ArrayList<String><String> nomex = new ArrayList<>();
        while (conex.rs.next()){
                nomex[i][0] = conex.rs.getString("class");
                nomex[i][1] = conex.rs.getString("soma");
                 i++;
        }        
    
    PRIMEIRA COLUNA TELA PRINCIPAL
        total: soma todas as linhas da 1a coluna            

    SEGUNDA COLUNA
       Fazer regra de 3 
        total                   - 100%
        1a coluna por categoria - x */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNomeCliente = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        aporteFinal = new javax.swing.JTextField();
        aporteAjuste = new javax.swing.JTextField();
        aporteFinalPerc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lblAssessorPerc = new javax.swing.JLabel();
        aporteAjustePerc = new javax.swing.JTextField();
        aportePerfil = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        atualPerc = new javax.swing.JLabel();
        aporteAtualPerc = new javax.swing.JTextField();
        aporteAtual = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        alocacaoAtual1 = new javax.swing.JTextField();
        alocacaoPerc1 = new javax.swing.JTextField();
        perfil1 = new javax.swing.JTextField();
        ajustePerc1 = new javax.swing.JTextField();
        finalPerc1 = new javax.swing.JTextField();
        ajuste1 = new javax.swing.JTextField();
        final1 = new javax.swing.JTextField();
        final2 = new javax.swing.JTextField();
        ajuste3 = new javax.swing.JTextField();
        ajuste2 = new javax.swing.JTextField();
        final3 = new javax.swing.JTextField();
        finalPerc3 = new javax.swing.JTextField();
        finalPerc2 = new javax.swing.JTextField();
        ajustePerc2 = new javax.swing.JTextField();
        ajustePerc3 = new javax.swing.JTextField();
        perfil3 = new javax.swing.JTextField();
        perfil2 = new javax.swing.JTextField();
        alocacaoPerc2 = new javax.swing.JTextField();
        alocacaoPerc3 = new javax.swing.JTextField();
        alocacaoAtual3 = new javax.swing.JTextField();
        alocacaoAtual2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        alocacaoAtual4 = new javax.swing.JTextField();
        alocacaoPerc4 = new javax.swing.JTextField();
        perfil4 = new javax.swing.JTextField();
        ajustePerc4 = new javax.swing.JTextField();
        finalPerc4 = new javax.swing.JTextField();
        ajuste4 = new javax.swing.JTextField();
        final4 = new javax.swing.JTextField();
        final5 = new javax.swing.JTextField();
        ajuste5 = new javax.swing.JTextField();
        finalPerc5 = new javax.swing.JTextField();
        ajustePerc5 = new javax.swing.JTextField();
        perfil5 = new javax.swing.JTextField();
        alocacaoPerc5 = new javax.swing.JTextField();
        alocacaoAtual5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        alocacaoAtual6 = new javax.swing.JTextField();
        alocacaoPerc6 = new javax.swing.JTextField();
        perfil6 = new javax.swing.JTextField();
        ajustePerc6 = new javax.swing.JTextField();
        finalPerc6 = new javax.swing.JTextField();
        ajuste6 = new javax.swing.JTextField();
        final6 = new javax.swing.JTextField();
        final7 = new javax.swing.JTextField();
        ajuste7 = new javax.swing.JTextField();
        finalPerc7 = new javax.swing.JTextField();
        ajustePerc7 = new javax.swing.JTextField();
        perfil7 = new javax.swing.JTextField();
        alocacaoPerc7 = new javax.swing.JTextField();
        alocacaoAtual7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        alocacaoAtual8 = new javax.swing.JTextField();
        alocacaoPerc8 = new javax.swing.JTextField();
        perfil8 = new javax.swing.JTextField();
        ajustePerc8 = new javax.swing.JTextField();
        finalPerc8 = new javax.swing.JTextField();
        ajuste8 = new javax.swing.JTextField();
        final8 = new javax.swing.JTextField();
        final9 = new javax.swing.JTextField();
        ajuste9 = new javax.swing.JTextField();
        finalPerc9 = new javax.swing.JTextField();
        ajustePerc9 = new javax.swing.JTextField();
        perfil9 = new javax.swing.JTextField();
        alocacaoPerc9 = new javax.swing.JTextField();
        alocacaoAtual9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rendaFixaAtual = new javax.swing.JTextField();
        rendaFixaAtualPerc = new javax.swing.JTextField();
        rendaFixaPerfil = new javax.swing.JTextField();
        rendaFixaAjustePerc = new javax.swing.JTextField();
        rendaFixaFinalPerc = new javax.swing.JTextField();
        rendaFixaAjuste = new javax.swing.JTextField();
        rendaFixaFinal = new javax.swing.JTextField();
        final10 = new javax.swing.JTextField();
        final11 = new javax.swing.JTextField();
        final12 = new javax.swing.JTextField();
        ajuste12 = new javax.swing.JTextField();
        ajuste11 = new javax.swing.JTextField();
        ajuste10 = new javax.swing.JTextField();
        finalPerc11 = new javax.swing.JTextField();
        finalPerc10 = new javax.swing.JTextField();
        finalPerc12 = new javax.swing.JTextField();
        jTextField125 = new javax.swing.JTextField();
        jTextField131 = new javax.swing.JTextField();
        ajustePerc10 = new javax.swing.JTextField();
        perfil11 = new javax.swing.JTextField();
        javax.swing.JTextField perfil12 = new javax.swing.JTextField();
        perfil10 = new javax.swing.JTextField();
        alocacaoPerc10 = new javax.swing.JTextField();
        alocacaoPerc12 = new javax.swing.JTextField();
        alocacaoPerc11 = new javax.swing.JTextField();
        alocacaoAtual10 = new javax.swing.JTextField();
        alocacaoAtual11 = new javax.swing.JTextField();
        alocacaoAtual12 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        multimercadoAtual = new javax.swing.JTextField();
        multimercadoAtualPerc = new javax.swing.JTextField();
        multimercadoPerfil = new javax.swing.JTextField();
        multimercadoAjustePerc = new javax.swing.JTextField();
        multimercadoFinalPerc = new javax.swing.JTextField();
        multimercadoAjuste = new javax.swing.JTextField();
        multimercadoFinal = new javax.swing.JTextField();
        final13 = new javax.swing.JTextField();
        finalPerc13 = new javax.swing.JTextField();
        ajuste13 = new javax.swing.JTextField();
        ajustePerc13 = new javax.swing.JTextField();
        perfil13 = new javax.swing.JTextField();
        alocacaoPerc13 = new javax.swing.JTextField();
        alocacaoAtual13 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        alocacaoAtual14 = new javax.swing.JTextField();
        alocacaoPerc14 = new javax.swing.JTextField();
        perfil14 = new javax.swing.JTextField();
        ajustePerc14 = new javax.swing.JTextField();
        finalPerc14 = new javax.swing.JTextField();
        ajuste14 = new javax.swing.JTextField();
        final14 = new javax.swing.JTextField();
        final15 = new javax.swing.JTextField();
        ajuste15 = new javax.swing.JTextField();
        finalPerc15 = new javax.swing.JTextField();
        ajustePerc15 = new javax.swing.JTextField();
        perfil15 = new javax.swing.JTextField();
        alocacaoPerc15 = new javax.swing.JTextField();
        alocacaoAtual15 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        rendaVariavelAloc = new javax.swing.JTextField();
        rendaVariavelAlocPerc = new javax.swing.JTextField();
        rendaVariavelPerfil = new javax.swing.JTextField();
        rendaVariavelAjustePerc = new javax.swing.JTextField();
        rendaVariavelFinalPerc = new javax.swing.JTextField();
        rendaVariavelAjuste = new javax.swing.JTextField();
        rendaVariavelFinal = new javax.swing.JTextField();
        final16 = new javax.swing.JTextField();
        final17 = new javax.swing.JTextField();
        totalFinal = new javax.swing.JTextField();
        totalAjuste = new javax.swing.JTextField();
        ajuste17 = new javax.swing.JTextField();
        ajuste16 = new javax.swing.JTextField();
        totalFinalPerc = new javax.swing.JTextField();
        finalPerc17 = new javax.swing.JTextField();
        finalPerc16 = new javax.swing.JTextField();
        ajustePerc16 = new javax.swing.JTextField();
        ajustePerc17 = new javax.swing.JTextField();
        totalAjustePerc = new javax.swing.JTextField();
        totalPerfil = new javax.swing.JTextField();
        perfil17 = new javax.swing.JTextField();
        perfil16 = new javax.swing.JTextField();
        alocacaoPerc16 = new javax.swing.JTextField();
        alocacaoPerc17 = new javax.swing.JTextField();
        totalAtualPerc = new javax.swing.JTextField();
        totalAtual = new javax.swing.JTextField();
        alocacaoAtual17 = new javax.swing.JTextField();
        alocacaoAtual16 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCodigoCliente = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCompra = new javax.swing.JMenuItem();
        jVenda = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jConsulta = new javax.swing.JMenuItem();
        jAlocacao = new javax.swing.JMenu();
        jMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Principal");
        getContentPane().setLayout(null);

        jNomeCliente.setBackground(java.awt.Color.white);
        jNomeCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jNomeCliente.setForeground(java.awt.Color.red);
        jNomeCliente.setText("XXXXXXXX");
        getContentPane().add(jNomeCliente);
        jNomeCliente.setBounds(10, 10, 140, 50);

        jLabel40.setBackground(new java.awt.Color(153, 153, 153));
        jLabel40.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Alocação");
        jLabel40.setOpaque(true);
        getContentPane().add(jLabel40);
        jLabel40.setBounds(920, 70, 100, 20);

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("   Final R$");
        jLabel22.setOpaque(true);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(910, 90, 110, 20);

        aporteFinal.setBackground(java.awt.Color.yellow);
        aporteFinal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aporteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aporteFinalActionPerformed(evt);
            }
        });
        getContentPane().add(aporteFinal);
        aporteFinal.setBounds(910, 110, 110, 30);

        aporteAjuste.setBackground(java.awt.Color.yellow);
        aporteAjuste.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aporteAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aporteAjusteActionPerformed(evt);
            }
        });
        getContentPane().add(aporteAjuste);
        aporteAjuste.setBounds(810, 110, 100, 30);

        aporteFinalPerc.setBackground(java.awt.Color.yellow);
        aporteFinalPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aporteFinalPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aporteFinalPercActionPerformed(evt);
            }
        });
        getContentPane().add(aporteFinalPerc);
        aporteFinalPerc.setBounds(720, 110, 90, 30);

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Assessor R$");
        jLabel19.setOpaque(true);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(820, 90, 90, 20);

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Ajuste ");
        jLabel21.setOpaque(true);
        getContentPane().add(jLabel21);
        jLabel21.setBounds(820, 70, 100, 20);

        jLabel29.setBackground(new java.awt.Color(153, 153, 153));
        jLabel29.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("   Final %");
        jLabel29.setOpaque(true);
        getContentPane().add(jLabel29);
        jLabel29.setBounds(710, 90, 110, 20);

        jLabel39.setBackground(new java.awt.Color(153, 153, 153));
        jLabel39.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText(" Alocação");
        jLabel39.setOpaque(true);
        getContentPane().add(jLabel39);
        jLabel39.setBounds(710, 70, 110, 20);

        jLabel38.setBackground(new java.awt.Color(153, 153, 153));
        jLabel38.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("    Ajuste");
        jLabel38.setOpaque(true);
        getContentPane().add(jLabel38);
        jLabel38.setBounds(620, 70, 90, 20);

        lblAssessorPerc.setBackground(new java.awt.Color(153, 153, 153));
        lblAssessorPerc.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lblAssessorPerc.setForeground(new java.awt.Color(255, 255, 255));
        lblAssessorPerc.setText("Assessor %");
        lblAssessorPerc.setOpaque(true);
        getContentPane().add(lblAssessorPerc);
        lblAssessorPerc.setBounds(620, 90, 90, 20);

        aporteAjustePerc.setBackground(java.awt.Color.yellow);
        aporteAjustePerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aporteAjustePerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aporteAjustePercActionPerformed(evt);
            }
        });
        getContentPane().add(aporteAjustePerc);
        aporteAjustePerc.setBounds(620, 110, 100, 30);

        aportePerfil.setBackground(java.awt.Color.yellow);
        aportePerfil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(aportePerfil);
        aportePerfil.setBounds(540, 110, 80, 30);

        jLabel27.setBackground(new java.awt.Color(153, 153, 153));
        jLabel27.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("para Perfil");
        jLabel27.setOpaque(true);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(540, 90, 80, 20);

        jLabel36.setBackground(new java.awt.Color(153, 153, 153));
        jLabel36.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText(" Sugestão");
        jLabel36.setOpaque(true);
        getContentPane().add(jLabel36);
        jLabel36.setBounds(540, 70, 80, 20);

        jLabel37.setBackground(new java.awt.Color(153, 153, 153));
        jLabel37.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText(" Alocação");
        jLabel37.setOpaque(true);
        getContentPane().add(jLabel37);
        jLabel37.setBounds(460, 70, 80, 20);

        atualPerc.setBackground(new java.awt.Color(153, 153, 153));
        atualPerc.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        atualPerc.setForeground(new java.awt.Color(255, 255, 255));
        atualPerc.setText("   Atual %");
        atualPerc.setOpaque(true);
        getContentPane().add(atualPerc);
        atualPerc.setBounds(460, 90, 80, 20);

        aporteAtualPerc.setBackground(java.awt.Color.yellow);
        aporteAtualPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aporteAtualPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aporteAtualPercActionPerformed(evt);
            }
        });
        getContentPane().add(aporteAtualPerc);
        aporteAtualPerc.setBounds(460, 110, 80, 30);

        aporteAtual.setBackground(java.awt.Color.yellow);
        aporteAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aporteAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aporteAtualActionPerformed(evt);
            }
        });
        getContentPane().add(aporteAtual);
        aporteAtual.setBounds(380, 110, 80, 30);

        jLabel34.setBackground(new java.awt.Color(153, 153, 153));
        jLabel34.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText(" Atual R$");
        jLabel34.setOpaque(true);
        getContentPane().add(jLabel34);
        jLabel34.setBounds(380, 90, 80, 20);

        jLabel35.setBackground(new java.awt.Color(153, 153, 153));
        jLabel35.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText(" Alocação");
        jLabel35.setOpaque(true);
        getContentPane().add(jLabel35);
        jLabel35.setBounds(380, 70, 80, 20);

        jLabel25.setBackground(new java.awt.Color(153, 153, 153));
        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText(" PERFIL MODERADO");
        jLabel25.setOpaque(true);
        getContentPane().add(jLabel25);
        jLabel25.setBounds(10, 70, 370, 40);

        jLabel3.setBackground(new java.awt.Color(25, 137, 25));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText(" Renda Fixa Pós com liquidez (LTF, CDBs, Fundos DI, Poupança)");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel3.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 140, 370, 30);

        jLabel23.setBackground(java.awt.Color.yellow);
        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setText(" Conta Corrente/Aporte");
        jLabel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel23.setOpaque(true);
        getContentPane().add(jLabel23);
        jLabel23.setBounds(10, 110, 370, 30);

        alocacaoAtual1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual1.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual1.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual1.setName("alocacaoAtual1"); // NOI18N
        alocacaoAtual1.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual1ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual1);
        alocacaoAtual1.setBounds(380, 140, 80, 30);

        alocacaoPerc1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc1.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc1.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc1.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc1ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc1);
        alocacaoPerc1.setBounds(460, 140, 80, 30);

        perfil1.setBackground(new java.awt.Color(129, 167, 71));
        perfil1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil1.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil1.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil1.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(perfil1);
        perfil1.setBounds(540, 140, 80, 30);

        ajustePerc1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc1.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc1.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc1.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc1ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc1);
        ajustePerc1.setBounds(620, 140, 100, 30);

        finalPerc1.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc1.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc1.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc1.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc1ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc1);
        finalPerc1.setBounds(720, 140, 90, 30);

        ajuste1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste1.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste1.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste1.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste1ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste1);
        ajuste1.setBounds(810, 140, 101, 30);

        final1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final1.setMaximumSize(new java.awt.Dimension(101, 15));
        final1.setMinimumSize(new java.awt.Dimension(101, 15));
        final1.setPreferredSize(new java.awt.Dimension(101, 15));
        final1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final1ActionPerformed(evt);
            }
        });
        getContentPane().add(final1);
        final1.setBounds(910, 140, 110, 30);

        final2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final2.setMaximumSize(new java.awt.Dimension(101, 15));
        final2.setMinimumSize(new java.awt.Dimension(101, 15));
        final2.setPreferredSize(new java.awt.Dimension(101, 15));
        final2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final2ActionPerformed(evt);
            }
        });
        getContentPane().add(final2);
        final2.setBounds(910, 170, 110, 30);

        ajuste3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste3.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste3.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste3.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste3ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste3);
        ajuste3.setBounds(810, 200, 101, 30);

        ajuste2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste2.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste2.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste2.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste2ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste2);
        ajuste2.setBounds(810, 170, 101, 30);

        final3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final3.setMaximumSize(new java.awt.Dimension(101, 15));
        final3.setMinimumSize(new java.awt.Dimension(101, 15));
        final3.setPreferredSize(new java.awt.Dimension(101, 15));
        final3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final3ActionPerformed(evt);
            }
        });
        getContentPane().add(final3);
        final3.setBounds(910, 200, 110, 30);

        finalPerc3.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc3.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc3.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc3.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc3ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc3);
        finalPerc3.setBounds(720, 200, 90, 30);

        finalPerc2.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc2.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc2.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc2.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc2ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc2);
        finalPerc2.setBounds(720, 170, 90, 30);

        ajustePerc2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc2.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc2.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc2.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc2ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc2);
        ajustePerc2.setBounds(620, 170, 100, 30);

        ajustePerc3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc3.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc3.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc3.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc3ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc3);
        ajustePerc3.setBounds(620, 200, 100, 30);

        perfil3.setBackground(new java.awt.Color(129, 167, 71));
        perfil3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil3.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil3.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil3.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(perfil3);
        perfil3.setBounds(540, 200, 80, 30);

        perfil2.setBackground(new java.awt.Color(129, 167, 71));
        perfil2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil2.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil2.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil2.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(perfil2);
        perfil2.setBounds(540, 170, 80, 30);

        alocacaoPerc2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc2.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc2.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc2.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc2ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc2);
        alocacaoPerc2.setBounds(460, 170, 80, 30);

        alocacaoPerc3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc3.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc3.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc3.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc3ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc3);
        alocacaoPerc3.setBounds(460, 200, 80, 30);

        alocacaoAtual3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual3.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual3.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual3.setName("alocacaoAtual3"); // NOI18N
        alocacaoAtual3.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual3ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual3);
        alocacaoAtual3.setBounds(380, 200, 80, 30);

        alocacaoAtual2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual2.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual2.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual2.setName("alocacaoAtual2"); // NOI18N
        alocacaoAtual2.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual2ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual2);
        alocacaoAtual2.setBounds(380, 170, 80, 30);

        jLabel1.setBackground(new java.awt.Color(25, 137, 25));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText(" Renda Fixa Pós sem liquidez (LC, LCIs, LCAs, CDB longo)");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel1.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(101, 15));
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 170, 370, 30);

        jLabel4.setBackground(new java.awt.Color(25, 137, 25));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText(" Renda Fixa Pós Crédito Privado (sem FGC - CRI, CRA, Deb)");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel4.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 200, 370, 30);

        jLabel5.setBackground(java.awt.Color.green);
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText(" Renda Fixa Pré com liquidez (LTNs, NTN-F)");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel5.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel5.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 230, 370, 30);

        alocacaoAtual4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual4.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual4.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual4.setName("alocacaoAtual4"); // NOI18N
        alocacaoAtual4.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual4ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual4);
        alocacaoAtual4.setBounds(380, 230, 80, 30);

        alocacaoPerc4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc4.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc4.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc4.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc4ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc4);
        alocacaoPerc4.setBounds(460, 230, 80, 30);

        perfil4.setBackground(new java.awt.Color(129, 167, 71));
        perfil4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil4.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil4.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil4.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(perfil4);
        perfil4.setBounds(540, 230, 80, 30);

        ajustePerc4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc4.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc4.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc4.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc4ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc4);
        ajustePerc4.setBounds(620, 230, 100, 30);

        finalPerc4.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc4.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc4.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc4.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc4ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc4);
        finalPerc4.setBounds(720, 230, 90, 30);

        ajuste4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste4.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste4.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste4.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste4ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste4);
        ajuste4.setBounds(810, 230, 101, 30);

        final4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final4.setMaximumSize(new java.awt.Dimension(101, 15));
        final4.setMinimumSize(new java.awt.Dimension(101, 15));
        final4.setPreferredSize(new java.awt.Dimension(101, 15));
        final4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final4ActionPerformed(evt);
            }
        });
        getContentPane().add(final4);
        final4.setBounds(910, 230, 110, 30);

        final5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final5.setMaximumSize(new java.awt.Dimension(101, 15));
        final5.setMinimumSize(new java.awt.Dimension(101, 15));
        final5.setPreferredSize(new java.awt.Dimension(101, 15));
        final5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final5ActionPerformed(evt);
            }
        });
        getContentPane().add(final5);
        final5.setBounds(910, 260, 110, 30);

        ajuste5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste5.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste5.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste5.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste5ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste5);
        ajuste5.setBounds(810, 260, 101, 30);

        finalPerc5.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc5.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc5.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc5.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc5ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc5);
        finalPerc5.setBounds(720, 260, 90, 30);

        ajustePerc5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc5.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc5.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc5.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc5ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc5);
        ajustePerc5.setBounds(620, 260, 100, 30);

        perfil5.setBackground(new java.awt.Color(129, 167, 71));
        perfil5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil5.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil5.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil5.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil5ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil5);
        perfil5.setBounds(540, 260, 80, 30);

        alocacaoPerc5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc5.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc5.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc5.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc5ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc5);
        alocacaoPerc5.setBounds(460, 260, 80, 30);

        alocacaoAtual5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual5.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual5.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual5.setName("alocacaoAtual5"); // NOI18N
        alocacaoAtual5.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual5ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual5);
        alocacaoAtual5.setBounds(380, 260, 80, 30);

        jLabel6.setBackground(java.awt.Color.green);
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText(" Renda Fixa Pré sem liquidez (CDBs, LCs)");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel6.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel6.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel6.setOpaque(true);
        jLabel6.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 260, 370, 30);

        jLabel7.setBackground(java.awt.Color.green);
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText(" Renda Fixa Pré Crédito Privado (LF, Debentures)");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel7.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel7.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 290, 370, 30);

        alocacaoAtual6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual6.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual6.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual6.setName("alocacaoAtual6"); // NOI18N
        alocacaoAtual6.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual6ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual6);
        alocacaoAtual6.setBounds(380, 290, 80, 30);

        alocacaoPerc6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc6.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc6.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc6.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc6ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc6);
        alocacaoPerc6.setBounds(460, 290, 80, 30);

        perfil6.setBackground(new java.awt.Color(129, 167, 71));
        perfil6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil6.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil6.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil6.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil6ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil6);
        perfil6.setBounds(540, 290, 80, 30);

        ajustePerc6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc6.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc6.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc6.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc6ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc6);
        ajustePerc6.setBounds(620, 290, 100, 30);

        finalPerc6.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc6.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc6.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc6.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc6ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc6);
        finalPerc6.setBounds(720, 290, 90, 30);

        ajuste6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste6.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste6.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste6.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste6ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste6);
        ajuste6.setBounds(810, 290, 101, 30);

        final6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final6.setMaximumSize(new java.awt.Dimension(101, 15));
        final6.setMinimumSize(new java.awt.Dimension(101, 15));
        final6.setPreferredSize(new java.awt.Dimension(101, 15));
        final6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final6ActionPerformed(evt);
            }
        });
        getContentPane().add(final6);
        final6.setBounds(910, 290, 110, 30);

        final7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final7.setMaximumSize(new java.awt.Dimension(101, 15));
        final7.setMinimumSize(new java.awt.Dimension(101, 15));
        final7.setPreferredSize(new java.awt.Dimension(101, 15));
        final7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final7ActionPerformed(evt);
            }
        });
        getContentPane().add(final7);
        final7.setBounds(910, 320, 110, 30);

        ajuste7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste7.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste7.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste7.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste7ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste7);
        ajuste7.setBounds(810, 320, 101, 30);

        finalPerc7.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc7.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc7.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc7.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc7ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc7);
        finalPerc7.setBounds(720, 320, 90, 30);

        ajustePerc7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc7.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc7.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc7.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc7ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc7);
        ajustePerc7.setBounds(620, 320, 100, 30);

        perfil7.setBackground(new java.awt.Color(129, 167, 71));
        perfil7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil7.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil7.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil7.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil7ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil7);
        perfil7.setBounds(540, 320, 80, 30);

        alocacaoPerc7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc7.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc7.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc7.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc7ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc7);
        alocacaoPerc7.setBounds(460, 320, 80, 30);

        alocacaoAtual7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual7.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual7.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual7.setName("alocacaoAtual7"); // NOI18N
        alocacaoAtual7.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual7ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual7);
        alocacaoAtual7.setBounds(380, 320, 80, 30);

        jLabel8.setBackground(java.awt.Color.green);
        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText(" Renda Fixa IPCA com liquidez (NTN-B)");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel8.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel8.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel8.setOpaque(true);
        jLabel8.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 320, 370, 30);

        jLabel9.setBackground(java.awt.Color.green);
        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText(" Renda Fixa IPCA sem liquidez (CDBs, LCs)");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel9.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel9.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel9.setOpaque(true);
        jLabel9.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 350, 370, 30);

        alocacaoAtual8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual8.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual8.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual8.setName("alocacaoAtual8"); // NOI18N
        alocacaoAtual8.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual8ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual8);
        alocacaoAtual8.setBounds(380, 350, 80, 30);

        alocacaoPerc8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc8.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc8.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc8.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc8ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc8);
        alocacaoPerc8.setBounds(460, 350, 80, 30);

        perfil8.setBackground(new java.awt.Color(129, 167, 71));
        perfil8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil8.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil8.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil8.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil8ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil8);
        perfil8.setBounds(540, 350, 80, 30);

        ajustePerc8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc8.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc8.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc8.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc8ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc8);
        ajustePerc8.setBounds(620, 350, 100, 30);

        finalPerc8.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc8.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc8.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc8.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc8ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc8);
        finalPerc8.setBounds(720, 350, 90, 30);

        ajuste8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste8.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste8.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste8.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste8ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste8);
        ajuste8.setBounds(810, 350, 101, 30);

        final8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final8.setMaximumSize(new java.awt.Dimension(101, 15));
        final8.setMinimumSize(new java.awt.Dimension(101, 15));
        final8.setPreferredSize(new java.awt.Dimension(101, 15));
        final8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final8ActionPerformed(evt);
            }
        });
        getContentPane().add(final8);
        final8.setBounds(910, 350, 110, 30);

        final9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final9.setMaximumSize(new java.awt.Dimension(101, 15));
        final9.setMinimumSize(new java.awt.Dimension(101, 15));
        final9.setPreferredSize(new java.awt.Dimension(101, 15));
        final9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final9ActionPerformed(evt);
            }
        });
        getContentPane().add(final9);
        final9.setBounds(910, 380, 110, 30);

        ajuste9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste9.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste9.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste9.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste9ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste9);
        ajuste9.setBounds(810, 380, 101, 30);

        finalPerc9.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc9.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc9.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc9.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc9ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc9);
        finalPerc9.setBounds(720, 380, 90, 30);

        ajustePerc9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc9.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc9.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc9.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc9ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc9);
        ajustePerc9.setBounds(620, 380, 100, 30);

        perfil9.setBackground(new java.awt.Color(129, 167, 71));
        perfil9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil9.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil9.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil9.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil9ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil9);
        perfil9.setBounds(540, 380, 80, 30);

        alocacaoPerc9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc9.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc9.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc9.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc9ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc9);
        alocacaoPerc9.setBounds(460, 380, 80, 30);

        alocacaoAtual9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual9.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual9.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual9.setName("alocacaoAtual9"); // NOI18N
        alocacaoAtual9.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual9ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual9);
        alocacaoAtual9.setBounds(380, 380, 80, 30);

        jLabel10.setBackground(java.awt.Color.green);
        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText(" Renda Fixa IPCA Crédito Privado (CRI, CRA, Debentures)");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel10.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 380, 370, 30);

        jLabel11.setBackground(java.awt.Color.gray);
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText(" Renda Fixa TOTAL");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 410, 370, 30);

        rendaFixaAtual.setBackground(java.awt.Color.gray);
        rendaFixaAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaFixaAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaFixaAtualActionPerformed(evt);
            }
        });
        getContentPane().add(rendaFixaAtual);
        rendaFixaAtual.setBounds(380, 410, 80, 30);

        rendaFixaAtualPerc.setBackground(java.awt.Color.gray);
        rendaFixaAtualPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaFixaAtualPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaFixaAtualPercActionPerformed(evt);
            }
        });
        getContentPane().add(rendaFixaAtualPerc);
        rendaFixaAtualPerc.setBounds(460, 410, 80, 30);

        rendaFixaPerfil.setBackground(java.awt.Color.gray);
        rendaFixaPerfil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaFixaPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaFixaPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(rendaFixaPerfil);
        rendaFixaPerfil.setBounds(540, 410, 80, 30);

        rendaFixaAjustePerc.setBackground(java.awt.Color.gray);
        rendaFixaAjustePerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaFixaAjustePerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaFixaAjustePercActionPerformed(evt);
            }
        });
        getContentPane().add(rendaFixaAjustePerc);
        rendaFixaAjustePerc.setBounds(620, 410, 100, 30);

        rendaFixaFinalPerc.setBackground(java.awt.Color.gray);
        rendaFixaFinalPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaFixaFinalPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaFixaFinalPercActionPerformed(evt);
            }
        });
        getContentPane().add(rendaFixaFinalPerc);
        rendaFixaFinalPerc.setBounds(720, 410, 90, 30);

        rendaFixaAjuste.setBackground(java.awt.Color.gray);
        rendaFixaAjuste.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaFixaAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaFixaAjusteActionPerformed(evt);
            }
        });
        getContentPane().add(rendaFixaAjuste);
        rendaFixaAjuste.setBounds(810, 410, 100, 30);

        rendaFixaFinal.setBackground(java.awt.Color.gray);
        rendaFixaFinal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaFixaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaFixaFinalActionPerformed(evt);
            }
        });
        getContentPane().add(rendaFixaFinal);
        rendaFixaFinal.setBounds(910, 410, 110, 30);

        final10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final10.setMaximumSize(new java.awt.Dimension(101, 15));
        final10.setMinimumSize(new java.awt.Dimension(101, 15));
        final10.setPreferredSize(new java.awt.Dimension(101, 15));
        final10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final10ActionPerformed(evt);
            }
        });
        getContentPane().add(final10);
        final10.setBounds(910, 440, 110, 30);

        final11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final11.setMaximumSize(new java.awt.Dimension(101, 15));
        final11.setMinimumSize(new java.awt.Dimension(101, 15));
        final11.setPreferredSize(new java.awt.Dimension(101, 15));
        final11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final11ActionPerformed(evt);
            }
        });
        getContentPane().add(final11);
        final11.setBounds(910, 470, 110, 30);

        final12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final12.setMaximumSize(new java.awt.Dimension(101, 15));
        final12.setMinimumSize(new java.awt.Dimension(101, 15));
        final12.setPreferredSize(new java.awt.Dimension(101, 15));
        final12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final12ActionPerformed(evt);
            }
        });
        getContentPane().add(final12);
        final12.setBounds(910, 500, 110, 30);

        ajuste12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste12.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste12.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste12.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste12ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste12);
        ajuste12.setBounds(810, 500, 101, 30);

        ajuste11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste11.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste11.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste11.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste11ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste11);
        ajuste11.setBounds(810, 470, 101, 30);

        ajuste10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste10.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste10.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste10.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste10ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste10);
        ajuste10.setBounds(810, 440, 101, 30);

        finalPerc11.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc11.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc11.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc11.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc11ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc11);
        finalPerc11.setBounds(720, 470, 90, 30);

        finalPerc10.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc10.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc10.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc10.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc10ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc10);
        finalPerc10.setBounds(720, 440, 90, 30);

        finalPerc12.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc12.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc12.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc12.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc12ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc12);
        finalPerc12.setBounds(720, 500, 90, 30);

        jTextField125.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField125.setMaximumSize(new java.awt.Dimension(101, 15));
        jTextField125.setMinimumSize(new java.awt.Dimension(101, 15));
        jTextField125.setPreferredSize(new java.awt.Dimension(101, 15));
        jTextField125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField125ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField125);
        jTextField125.setBounds(620, 500, 100, 30);

        jTextField131.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField131.setMaximumSize(new java.awt.Dimension(101, 15));
        jTextField131.setMinimumSize(new java.awt.Dimension(101, 15));
        jTextField131.setPreferredSize(new java.awt.Dimension(101, 15));
        jTextField131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField131ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField131);
        jTextField131.setBounds(620, 470, 100, 30);

        ajustePerc10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc10.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc10.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc10.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc10ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc10);
        ajustePerc10.setBounds(620, 440, 100, 30);

        perfil11.setBackground(new java.awt.Color(129, 167, 71));
        perfil11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil11.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil11.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil11.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil11ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil11);
        perfil11.setBounds(540, 470, 80, 30);

        perfil12.setBackground(new java.awt.Color(129, 167, 71));
        perfil12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil12.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil12.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil12.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil12ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil12);
        perfil12.setBounds(540, 500, 80, 30);

        perfil10.setBackground(new java.awt.Color(129, 167, 71));
        perfil10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil10.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil10.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil10.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil10ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil10);
        perfil10.setBounds(540, 440, 80, 30);

        alocacaoPerc10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc10.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc10.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc10.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc10ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc10);
        alocacaoPerc10.setBounds(460, 440, 80, 30);

        alocacaoPerc12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc12.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc12.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc12.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc12ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc12);
        alocacaoPerc12.setBounds(460, 500, 80, 30);

        alocacaoPerc11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc11.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc11.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc11.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc11ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc11);
        alocacaoPerc11.setBounds(460, 470, 80, 30);

        alocacaoAtual10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual10.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual10.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual10.setName("alocacaoAtual10"); // NOI18N
        alocacaoAtual10.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual10ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual10);
        alocacaoAtual10.setBounds(380, 440, 80, 30);

        alocacaoAtual11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual11.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual11.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual11.setName("alocacaoAtual11"); // NOI18N
        alocacaoAtual11.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual11ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual11);
        alocacaoAtual11.setBounds(380, 470, 80, 30);

        alocacaoAtual12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual12.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual12.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual12.setName("alocacaoAtual12"); // NOI18N
        alocacaoAtual12.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual12ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual12);
        alocacaoAtual12.setBounds(380, 500, 80, 30);

        jLabel14.setBackground(java.awt.Color.orange);
        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText(" Multimercado Alta Vol (Acima de 4%)");
        jLabel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel14.setMaximumSize(new java.awt.Dimension(230, 15));
        jLabel14.setMinimumSize(new java.awt.Dimension(230, 15));
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 500, 370, 30);

        jLabel13.setBackground(java.awt.Color.green);
        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText(" Multimercado Média Vol (de 1.5% até 4%)");
        jLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 470, 370, 30);

        jLabel12.setBackground(new java.awt.Color(25, 137, 25));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText(" Multimercado Baixa Vol (até 1.5%)");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel12.setMaximumSize(new java.awt.Dimension(230, 15));
        jLabel12.setMinimumSize(new java.awt.Dimension(230, 15));
        jLabel12.setOpaque(true);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 440, 370, 30);

        jLabel15.setBackground(java.awt.Color.gray);
        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText(" Multimercado TOTAL");
        jLabel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 530, 370, 30);

        multimercadoAtual.setBackground(java.awt.Color.gray);
        multimercadoAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        multimercadoAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multimercadoAtualActionPerformed(evt);
            }
        });
        getContentPane().add(multimercadoAtual);
        multimercadoAtual.setBounds(380, 530, 80, 30);

        multimercadoAtualPerc.setBackground(java.awt.Color.gray);
        multimercadoAtualPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        multimercadoAtualPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multimercadoAtualPercActionPerformed(evt);
            }
        });
        getContentPane().add(multimercadoAtualPerc);
        multimercadoAtualPerc.setBounds(460, 530, 80, 30);

        multimercadoPerfil.setBackground(java.awt.Color.gray);
        multimercadoPerfil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        multimercadoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multimercadoPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(multimercadoPerfil);
        multimercadoPerfil.setBounds(540, 530, 80, 30);

        multimercadoAjustePerc.setBackground(java.awt.Color.gray);
        multimercadoAjustePerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        multimercadoAjustePerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multimercadoAjustePercActionPerformed(evt);
            }
        });
        getContentPane().add(multimercadoAjustePerc);
        multimercadoAjustePerc.setBounds(620, 530, 100, 30);

        multimercadoFinalPerc.setBackground(java.awt.Color.gray);
        multimercadoFinalPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        multimercadoFinalPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multimercadoFinalPercActionPerformed(evt);
            }
        });
        getContentPane().add(multimercadoFinalPerc);
        multimercadoFinalPerc.setBounds(720, 530, 90, 30);

        multimercadoAjuste.setBackground(java.awt.Color.gray);
        multimercadoAjuste.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        multimercadoAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multimercadoAjusteActionPerformed(evt);
            }
        });
        getContentPane().add(multimercadoAjuste);
        multimercadoAjuste.setBounds(810, 530, 100, 30);

        multimercadoFinal.setBackground(java.awt.Color.gray);
        multimercadoFinal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        multimercadoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multimercadoFinalActionPerformed(evt);
            }
        });
        getContentPane().add(multimercadoFinal);
        multimercadoFinal.setBounds(910, 530, 110, 30);

        final13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final13.setMaximumSize(new java.awt.Dimension(101, 15));
        final13.setMinimumSize(new java.awt.Dimension(101, 15));
        final13.setPreferredSize(new java.awt.Dimension(101, 15));
        final13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final13ActionPerformed(evt);
            }
        });
        getContentPane().add(final13);
        final13.setBounds(910, 560, 110, 30);

        finalPerc13.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc13.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc13.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc13.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc13ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc13);
        finalPerc13.setBounds(720, 560, 90, 30);

        ajuste13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste13.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste13.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste13.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste13ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste13);
        ajuste13.setBounds(810, 560, 101, 30);

        ajustePerc13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc13.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc13.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc13.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc13ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc13);
        ajustePerc13.setBounds(620, 560, 100, 30);

        perfil13.setBackground(new java.awt.Color(129, 167, 71));
        perfil13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil13.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil13.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil13.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil13ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil13);
        perfil13.setBounds(540, 560, 80, 30);

        alocacaoPerc13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc13.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc13.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc13.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc13ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc13);
        alocacaoPerc13.setBounds(460, 560, 80, 30);

        alocacaoAtual13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual13.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual13.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual13.setName("alocacaoAtual13"); // NOI18N
        alocacaoAtual13.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual13ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual13);
        alocacaoAtual13.setBounds(380, 560, 80, 30);

        jLabel16.setBackground(java.awt.Color.orange);
        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText(" Fundos Imobiliários");
        jLabel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel16.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel16.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel16.setOpaque(true);
        jLabel16.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 560, 370, 30);

        jLabel31.setBackground(java.awt.Color.red);
        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText(" Carteira de Ações");
        jLabel31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel31.setOpaque(true);
        getContentPane().add(jLabel31);
        jLabel31.setBounds(10, 590, 370, 30);

        alocacaoAtual14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual14.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual14.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual14.setName("alocacaoAtual14"); // NOI18N
        alocacaoAtual14.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual14ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual14);
        alocacaoAtual14.setBounds(380, 590, 80, 30);

        alocacaoPerc14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc14.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc14.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc14.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc14ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc14);
        alocacaoPerc14.setBounds(460, 590, 80, 30);

        perfil14.setBackground(new java.awt.Color(129, 167, 71));
        perfil14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil14.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil14.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil14.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil14ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil14);
        perfil14.setBounds(540, 590, 80, 30);

        ajustePerc14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc14.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc14.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc14.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc14ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc14);
        ajustePerc14.setBounds(620, 590, 100, 30);

        finalPerc14.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc14.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc14.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc14.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc14ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc14);
        finalPerc14.setBounds(720, 590, 90, 30);

        ajuste14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste14.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste14.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste14.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste14ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste14);
        ajuste14.setBounds(810, 590, 101, 30);

        final14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final14.setMaximumSize(new java.awt.Dimension(101, 15));
        final14.setMinimumSize(new java.awt.Dimension(101, 15));
        final14.setPreferredSize(new java.awt.Dimension(101, 15));
        final14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final14ActionPerformed(evt);
            }
        });
        getContentPane().add(final14);
        final14.setBounds(910, 590, 110, 30);

        final15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final15.setMaximumSize(new java.awt.Dimension(101, 15));
        final15.setMinimumSize(new java.awt.Dimension(101, 15));
        final15.setPreferredSize(new java.awt.Dimension(101, 15));
        final15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final15ActionPerformed(evt);
            }
        });
        getContentPane().add(final15);
        final15.setBounds(910, 620, 110, 30);

        ajuste15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste15.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste15.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste15.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste15ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste15);
        ajuste15.setBounds(810, 620, 101, 30);

        finalPerc15.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc15.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc15.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc15.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc15ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc15);
        finalPerc15.setBounds(720, 620, 90, 30);

        ajustePerc15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc15.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc15.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc15.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc15ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc15);
        ajustePerc15.setBounds(620, 620, 100, 30);

        perfil15.setBackground(new java.awt.Color(129, 167, 71));
        perfil15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil15.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil15.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil15.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil15ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil15);
        perfil15.setBounds(540, 620, 80, 30);

        alocacaoPerc15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc15.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc15.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc15.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc15ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc15);
        alocacaoPerc15.setBounds(460, 620, 80, 30);

        alocacaoAtual15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual15.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual15.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual15.setName("alocacaoAtual15"); // NOI18N
        alocacaoAtual15.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual15ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual15);
        alocacaoAtual15.setBounds(380, 620, 80, 30);

        jLabel33.setBackground(java.awt.Color.red);
        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setText(" Fundos Internacionais sem hedge");
        jLabel33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel33.setMaximumSize(new java.awt.Dimension(101, 15));
        jLabel33.setMinimumSize(new java.awt.Dimension(101, 15));
        jLabel33.setOpaque(true);
        jLabel33.setPreferredSize(new java.awt.Dimension(101, 15));
        getContentPane().add(jLabel33);
        jLabel33.setBounds(10, 620, 370, 30);

        jLabel30.setBackground(java.awt.Color.gray);
        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setText(" Renda Variável TOTAL");
        jLabel30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel30.setOpaque(true);
        getContentPane().add(jLabel30);
        jLabel30.setBounds(10, 650, 370, 30);

        rendaVariavelAloc.setBackground(java.awt.Color.gray);
        rendaVariavelAloc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaVariavelAloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaVariavelAlocActionPerformed(evt);
            }
        });
        getContentPane().add(rendaVariavelAloc);
        rendaVariavelAloc.setBounds(380, 650, 80, 30);

        rendaVariavelAlocPerc.setBackground(java.awt.Color.gray);
        rendaVariavelAlocPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaVariavelAlocPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaVariavelAlocPercActionPerformed(evt);
            }
        });
        getContentPane().add(rendaVariavelAlocPerc);
        rendaVariavelAlocPerc.setBounds(460, 650, 80, 30);

        rendaVariavelPerfil.setBackground(java.awt.Color.gray);
        rendaVariavelPerfil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaVariavelPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaVariavelPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(rendaVariavelPerfil);
        rendaVariavelPerfil.setBounds(540, 650, 80, 30);

        rendaVariavelAjustePerc.setBackground(java.awt.Color.gray);
        rendaVariavelAjustePerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaVariavelAjustePerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaVariavelAjustePercActionPerformed(evt);
            }
        });
        getContentPane().add(rendaVariavelAjustePerc);
        rendaVariavelAjustePerc.setBounds(620, 650, 100, 30);

        rendaVariavelFinalPerc.setBackground(java.awt.Color.gray);
        rendaVariavelFinalPerc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaVariavelFinalPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaVariavelFinalPercActionPerformed(evt);
            }
        });
        getContentPane().add(rendaVariavelFinalPerc);
        rendaVariavelFinalPerc.setBounds(720, 650, 90, 30);

        rendaVariavelAjuste.setBackground(java.awt.Color.gray);
        rendaVariavelAjuste.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaVariavelAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaVariavelAjusteActionPerformed(evt);
            }
        });
        getContentPane().add(rendaVariavelAjuste);
        rendaVariavelAjuste.setBounds(810, 650, 100, 30);

        rendaVariavelFinal.setBackground(java.awt.Color.gray);
        rendaVariavelFinal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rendaVariavelFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaVariavelFinalActionPerformed(evt);
            }
        });
        getContentPane().add(rendaVariavelFinal);
        rendaVariavelFinal.setBounds(910, 650, 110, 30);

        final16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final16.setMaximumSize(new java.awt.Dimension(101, 15));
        final16.setMinimumSize(new java.awt.Dimension(101, 15));
        final16.setPreferredSize(new java.awt.Dimension(101, 15));
        final16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final16ActionPerformed(evt);
            }
        });
        getContentPane().add(final16);
        final16.setBounds(910, 680, 110, 30);

        final17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        final17.setMaximumSize(new java.awt.Dimension(101, 15));
        final17.setMinimumSize(new java.awt.Dimension(101, 15));
        final17.setPreferredSize(new java.awt.Dimension(101, 15));
        final17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                final17ActionPerformed(evt);
            }
        });
        getContentPane().add(final17);
        final17.setBounds(910, 710, 110, 30);

        totalFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalFinal.setMaximumSize(new java.awt.Dimension(101, 15));
        totalFinal.setMinimumSize(new java.awt.Dimension(101, 15));
        totalFinal.setPreferredSize(new java.awt.Dimension(101, 15));
        totalFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalFinalActionPerformed(evt);
            }
        });
        getContentPane().add(totalFinal);
        totalFinal.setBounds(910, 740, 110, 30);

        totalAjuste.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAjuste.setMaximumSize(new java.awt.Dimension(101, 15));
        totalAjuste.setMinimumSize(new java.awt.Dimension(101, 15));
        totalAjuste.setPreferredSize(new java.awt.Dimension(101, 15));
        totalAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAjusteActionPerformed(evt);
            }
        });
        getContentPane().add(totalAjuste);
        totalAjuste.setBounds(810, 740, 101, 30);

        ajuste17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste17.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste17.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste17.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste17ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste17);
        ajuste17.setBounds(810, 710, 101, 30);

        ajuste16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajuste16.setMaximumSize(new java.awt.Dimension(101, 15));
        ajuste16.setMinimumSize(new java.awt.Dimension(101, 15));
        ajuste16.setPreferredSize(new java.awt.Dimension(101, 15));
        ajuste16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste16ActionPerformed(evt);
            }
        });
        getContentPane().add(ajuste16);
        ajuste16.setBounds(810, 680, 101, 30);

        totalFinalPerc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalFinalPerc.setMaximumSize(new java.awt.Dimension(101, 15));
        totalFinalPerc.setMinimumSize(new java.awt.Dimension(101, 15));
        totalFinalPerc.setPreferredSize(new java.awt.Dimension(101, 15));
        totalFinalPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalFinalPercActionPerformed(evt);
            }
        });
        getContentPane().add(totalFinalPerc);
        totalFinalPerc.setBounds(720, 740, 90, 30);

        finalPerc17.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc17.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc17.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc17.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc17ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc17);
        finalPerc17.setBounds(720, 710, 90, 30);

        finalPerc16.setBackground(new java.awt.Color(129, 167, 71));
        finalPerc16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        finalPerc16.setMaximumSize(new java.awt.Dimension(101, 15));
        finalPerc16.setMinimumSize(new java.awt.Dimension(101, 15));
        finalPerc16.setPreferredSize(new java.awt.Dimension(101, 15));
        finalPerc16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPerc16ActionPerformed(evt);
            }
        });
        getContentPane().add(finalPerc16);
        finalPerc16.setBounds(720, 680, 90, 30);

        ajustePerc16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc16.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc16.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc16.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc16ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc16);
        ajustePerc16.setBounds(620, 680, 100, 30);

        ajustePerc17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ajustePerc17.setMaximumSize(new java.awt.Dimension(101, 15));
        ajustePerc17.setMinimumSize(new java.awt.Dimension(101, 15));
        ajustePerc17.setPreferredSize(new java.awt.Dimension(101, 15));
        ajustePerc17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustePerc17ActionPerformed(evt);
            }
        });
        getContentPane().add(ajustePerc17);
        ajustePerc17.setBounds(620, 710, 100, 30);

        totalAjustePerc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAjustePerc.setMaximumSize(new java.awt.Dimension(101, 15));
        totalAjustePerc.setMinimumSize(new java.awt.Dimension(101, 15));
        totalAjustePerc.setPreferredSize(new java.awt.Dimension(101, 15));
        totalAjustePerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAjustePercActionPerformed(evt);
            }
        });
        getContentPane().add(totalAjustePerc);
        totalAjustePerc.setBounds(620, 740, 100, 30);

        totalPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalPerfil.setMaximumSize(new java.awt.Dimension(101, 15));
        totalPerfil.setMinimumSize(new java.awt.Dimension(101, 15));
        totalPerfil.setPreferredSize(new java.awt.Dimension(101, 15));
        totalPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(totalPerfil);
        totalPerfil.setBounds(540, 740, 80, 30);

        perfil17.setBackground(new java.awt.Color(129, 167, 71));
        perfil17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil17.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil17.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil17.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil17ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil17);
        perfil17.setBounds(540, 710, 80, 30);

        perfil16.setBackground(new java.awt.Color(129, 167, 71));
        perfil16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        perfil16.setMaximumSize(new java.awt.Dimension(101, 15));
        perfil16.setMinimumSize(new java.awt.Dimension(101, 15));
        perfil16.setPreferredSize(new java.awt.Dimension(101, 15));
        perfil16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfil16ActionPerformed(evt);
            }
        });
        getContentPane().add(perfil16);
        perfil16.setBounds(540, 680, 80, 30);

        alocacaoPerc16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc16.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc16.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc16.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc16ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc16);
        alocacaoPerc16.setBounds(460, 680, 80, 30);

        alocacaoPerc17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoPerc17.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc17.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoPerc17.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoPerc17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoPerc17ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoPerc17);
        alocacaoPerc17.setBounds(460, 710, 80, 30);

        totalAtualPerc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAtualPerc.setMaximumSize(new java.awt.Dimension(101, 15));
        totalAtualPerc.setMinimumSize(new java.awt.Dimension(101, 15));
        totalAtualPerc.setPreferredSize(new java.awt.Dimension(101, 15));
        totalAtualPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAtualPercActionPerformed(evt);
            }
        });
        getContentPane().add(totalAtualPerc);
        totalAtualPerc.setBounds(460, 740, 80, 30);

        totalAtual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAtual.setMaximumSize(new java.awt.Dimension(101, 15));
        totalAtual.setMinimumSize(new java.awt.Dimension(101, 15));
        totalAtual.setPreferredSize(new java.awt.Dimension(101, 15));
        totalAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAtualActionPerformed(evt);
            }
        });
        getContentPane().add(totalAtual);
        totalAtual.setBounds(380, 740, 80, 30);

        alocacaoAtual17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual17.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual17.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual17.setName("alocacaoAtual17"); // NOI18N
        alocacaoAtual17.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual17ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual17);
        alocacaoAtual17.setBounds(380, 710, 80, 30);

        alocacaoAtual16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        alocacaoAtual16.setMaximumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual16.setMinimumSize(new java.awt.Dimension(101, 15));
        alocacaoAtual16.setName("alocacaoAtual16"); // NOI18N
        alocacaoAtual16.setPreferredSize(new java.awt.Dimension(101, 15));
        alocacaoAtual16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alocacaoAtual16ActionPerformed(evt);
            }
        });
        getContentPane().add(alocacaoAtual16);
        alocacaoAtual16.setBounds(380, 680, 80, 30);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setText(" Proteção (Seguro Vida)");
        jLabel32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel32);
        jLabel32.setBounds(10, 680, 370, 30);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText(" Carteira Offshore (FX)");
        jLabel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel20);
        jLabel20.setBounds(10, 710, 370, 30);

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText(" CARTEIRA INVESTIMENTOS TOTAL");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 740, 370, 30);

        jCodigoCliente.setBackground(java.awt.Color.white);
        jCodigoCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCodigoCliente.setForeground(java.awt.Color.red);
        jCodigoCliente.setText("99999");
        getContentPane().add(jCodigoCliente);
        jCodigoCliente.setBounds(150, 10, 80, 50);

        jMenu1.setText("Arquivo");

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuste");

        jCompra.setText("Compra");
        jCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCompraActionPerformed(evt);
            }
        });
        jMenu2.add(jCompra);

        jVenda.setText("Venda");
        jVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVendaActionPerformed(evt);
            }
        });
        jMenu2.add(jVenda);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Clientes");

        jConsulta.setText("Consulta");
        jConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultaActionPerformed(evt);
            }
        });
        jMenu6.add(jConsulta);

        jMenuBar1.add(jMenu6);

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

        setSize(new java.awt.Dimension(1073, 881));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aporteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aporteFinalActionPerformed
    }//GEN-LAST:event_aporteFinalActionPerformed
    private void aporteAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aporteAjusteActionPerformed
    }//GEN-LAST:event_aporteAjusteActionPerformed
    private void aporteFinalPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aporteFinalPercActionPerformed
    }//GEN-LAST:event_aporteFinalPercActionPerformed
    private void aporteAjustePercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aporteAjustePercActionPerformed
    }//GEN-LAST:event_aporteAjustePercActionPerformed
    private void aporteAtualPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aporteAtualPercActionPerformed
    }//GEN-LAST:event_aporteAtualPercActionPerformed
    private void aporteAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aporteAtualActionPerformed
    }//GEN-LAST:event_aporteAtualActionPerformed
    private void alocacaoPerc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc1ActionPerformed
    }//GEN-LAST:event_alocacaoPerc1ActionPerformed
    private void ajustePerc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc1ActionPerformed
    }//GEN-LAST:event_ajustePerc1ActionPerformed
    private void finalPerc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc1ActionPerformed
    }//GEN-LAST:event_finalPerc1ActionPerformed
    private void ajuste1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste1ActionPerformed
    }//GEN-LAST:event_ajuste1ActionPerformed
    private void final1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final1ActionPerformed
    }//GEN-LAST:event_final1ActionPerformed
    private void final2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final2ActionPerformed
    }//GEN-LAST:event_final2ActionPerformed
    private void ajuste3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste3ActionPerformed
    }//GEN-LAST:event_ajuste3ActionPerformed
    private void ajuste2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste2ActionPerformed
    }//GEN-LAST:event_ajuste2ActionPerformed
    private void final3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final3ActionPerformed
    }//GEN-LAST:event_final3ActionPerformed
    private void finalPerc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc3ActionPerformed
    }//GEN-LAST:event_finalPerc3ActionPerformed
    private void finalPerc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc2ActionPerformed
    private void ajustePerc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc2ActionPerformed
    private void ajustePerc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc3ActionPerformed
    private void alocacaoPerc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc2ActionPerformed
    private void alocacaoPerc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc3ActionPerformed
    private void alocacaoPerc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc4ActionPerformed
    private void ajustePerc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc4ActionPerformed
    private void finalPerc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc4ActionPerformed
    private void ajuste4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste4ActionPerformed
    private void final4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final4ActionPerformed
    private void final5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final5ActionPerformed
    }//GEN-LAST:event_final5ActionPerformed
    private void ajuste5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste5ActionPerformed
    private void finalPerc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc5ActionPerformed
    private void ajustePerc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc5ActionPerformed
    private void perfil5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil5ActionPerformed
    private void alocacaoPerc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc5ActionPerformed
    private void alocacaoPerc6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc6ActionPerformed
    private void perfil6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil6ActionPerformed
    private void ajustePerc6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc6ActionPerformed
    private void finalPerc6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc6ActionPerformed
    }//GEN-LAST:event_finalPerc6ActionPerformed
    private void ajuste6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste6ActionPerformed

    }//GEN-LAST:event_ajuste6ActionPerformed
    private void final6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final6ActionPerformed
    private void final7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final7ActionPerformed
    private void ajuste7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste7ActionPerformed
    private void finalPerc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc7ActionPerformed
    private void ajustePerc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc7ActionPerformed
    private void perfil7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil7ActionPerformed
    private void alocacaoPerc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc7ActionPerformed
    private void alocacaoPerc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc8ActionPerformed
    private void perfil8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil8ActionPerformed
    private void ajustePerc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc8ActionPerformed
    private void finalPerc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc8ActionPerformed
    private void ajuste8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste8ActionPerformed
    private void final8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final8ActionPerformed
    private void final9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final9ActionPerformed
    private void ajuste9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste9ActionPerformed
    private void finalPerc9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc9ActionPerformed
    private void ajustePerc9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc9ActionPerformed
    private void perfil9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil9ActionPerformed
    private void alocacaoPerc9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc9ActionPerformed
    private void rendaFixaAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaFixaAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaFixaAtualActionPerformed
    private void rendaFixaAtualPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaFixaAtualPercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaFixaAtualPercActionPerformed
    private void rendaFixaPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaFixaPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaFixaPerfilActionPerformed
    private void rendaFixaAjustePercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaFixaAjustePercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaFixaAjustePercActionPerformed
    private void rendaFixaFinalPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaFixaFinalPercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaFixaFinalPercActionPerformed
    private void rendaFixaAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaFixaAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaFixaAjusteActionPerformed
    private void rendaFixaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaFixaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaFixaFinalActionPerformed
    private void final10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final10ActionPerformed
    private void final11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final11ActionPerformed
    private void final12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final12ActionPerformed
    private void ajuste12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste12ActionPerformed
    private void ajuste11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste11ActionPerformed
    private void ajuste10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste10ActionPerformed
    private void finalPerc11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc11ActionPerformed
    private void finalPerc10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc10ActionPerformed
    private void finalPerc12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc12ActionPerformed
    private void jTextField125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField125ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField125ActionPerformed
    private void jTextField131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField131ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField131ActionPerformed
    private void ajustePerc10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc10ActionPerformed
    private void perfil11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil11ActionPerformed
    private void perfil12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil12ActionPerformed
    private void perfil10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil10ActionPerformed
    private void alocacaoPerc10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc10ActionPerformed
    private void alocacaoPerc12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc12ActionPerformed
    private void alocacaoPerc11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc11ActionPerformed
    private void multimercadoAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multimercadoAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multimercadoAtualActionPerformed
    private void multimercadoAtualPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multimercadoAtualPercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multimercadoAtualPercActionPerformed
    private void multimercadoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multimercadoPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multimercadoPerfilActionPerformed
    private void multimercadoAjustePercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multimercadoAjustePercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multimercadoAjustePercActionPerformed
    private void multimercadoFinalPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multimercadoFinalPercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multimercadoFinalPercActionPerformed
    private void multimercadoAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multimercadoAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multimercadoAjusteActionPerformed
    private void multimercadoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multimercadoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multimercadoFinalActionPerformed
    private void final13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final13ActionPerformed
    private void finalPerc13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc13ActionPerformed
    private void ajuste13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste13ActionPerformed
    private void ajustePerc13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc13ActionPerformed
    private void perfil13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil13ActionPerformed
    private void alocacaoPerc13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc13ActionPerformed
    private void alocacaoPerc14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc14ActionPerformed
    private void perfil14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil14ActionPerformed
    private void ajustePerc14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc14ActionPerformed
    private void finalPerc14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc14ActionPerformed
    private void ajuste14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste14ActionPerformed
    private void final14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final14ActionPerformed
    private void final15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final15ActionPerformed
    private void ajuste15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste15ActionPerformed
    private void finalPerc15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalPerc15ActionPerformed
    private void ajustePerc15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajustePerc15ActionPerformed
    private void perfil15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfil15ActionPerformed
    private void alocacaoPerc15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoPerc15ActionPerformed
    private void rendaVariavelAlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaVariavelAlocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaVariavelAlocActionPerformed
    private void rendaVariavelAlocPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaVariavelAlocPercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaVariavelAlocPercActionPerformed
    private void rendaVariavelPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaVariavelPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaVariavelPerfilActionPerformed
    private void rendaVariavelAjustePercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaVariavelAjustePercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaVariavelAjustePercActionPerformed
    private void rendaVariavelFinalPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaVariavelFinalPercActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaVariavelFinalPercActionPerformed
    private void rendaVariavelAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaVariavelAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaVariavelAjusteActionPerformed
    private void rendaVariavelFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaVariavelFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaVariavelFinalActionPerformed
    private void final16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final16ActionPerformed
    private void final17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_final17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_final17ActionPerformed
    private void totalFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalFinalActionPerformed
    private void totalAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAjusteActionPerformed
    private void ajuste17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste17ActionPerformed
    private void ajuste16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste16ActionPerformed
    private void totalFinalPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalFinalPercActionPerformed
    }//GEN-LAST:event_totalFinalPercActionPerformed
    private void finalPerc17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc17ActionPerformed
    }//GEN-LAST:event_finalPerc17ActionPerformed
    private void finalPerc16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPerc16ActionPerformed
    }//GEN-LAST:event_finalPerc16ActionPerformed
    private void ajustePerc16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc16ActionPerformed
    }//GEN-LAST:event_ajustePerc16ActionPerformed
    private void ajustePerc17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustePerc17ActionPerformed
    }//GEN-LAST:event_ajustePerc17ActionPerformed
    private void totalAjustePercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAjustePercActionPerformed
    }//GEN-LAST:event_totalAjustePercActionPerformed
    private void totalPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPerfilActionPerformed
    }//GEN-LAST:event_totalPerfilActionPerformed
    private void perfil17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil17ActionPerformed
    }//GEN-LAST:event_perfil17ActionPerformed
    private void perfil16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfil16ActionPerformed
    }//GEN-LAST:event_perfil16ActionPerformed
    private void alocacaoPerc16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc16ActionPerformed
    }//GEN-LAST:event_alocacaoPerc16ActionPerformed
    private void alocacaoPerc17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoPerc17ActionPerformed
    }//GEN-LAST:event_alocacaoPerc17ActionPerformed
    private void totalAtualPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAtualPercActionPerformed
    }//GEN-LAST:event_totalAtualPercActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
         int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if(sair == JOptionPane.YES_OPTION){
            dispose();
            //System.exit(0);
        }
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCompraActionPerformed
        TelaCompra telaCompra = new TelaCompra();
        telaCompra.setVisible(true);
    }//GEN-LAST:event_jCompraActionPerformed

    private void jConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultaActionPerformed
        TelaConsulta telaConsulta = new TelaConsulta();
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_jConsultaActionPerformed

    private void jVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVendaActionPerformed
        TelaVenda telaVenda = new TelaVenda();
        telaVenda.setVisible(true);
    }//GEN-LAST:event_jVendaActionPerformed

    private void jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActionPerformed
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
    }//GEN-LAST:event_jMenuItemActionPerformed

    private void totalAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAtualActionPerformed

    }//GEN-LAST:event_totalAtualActionPerformed

    private void alocacaoAtual17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual17ActionPerformed

    }//GEN-LAST:event_alocacaoAtual17ActionPerformed

    private void alocacaoAtual16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual16ActionPerformed

    }//GEN-LAST:event_alocacaoAtual16ActionPerformed

    private void alocacaoAtual15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual15ActionPerformed

    private void alocacaoAtual14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual14ActionPerformed

    private void alocacaoAtual13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual13ActionPerformed

    private void alocacaoAtual12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual12ActionPerformed

    private void alocacaoAtual11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual11ActionPerformed

    private void alocacaoAtual10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual10ActionPerformed

    private void alocacaoAtual9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual9ActionPerformed

    private void alocacaoAtual8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual8ActionPerformed

    private void alocacaoAtual7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual7ActionPerformed

    private void alocacaoAtual6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual6ActionPerformed

    private void alocacaoAtual5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual5ActionPerformed

    private void alocacaoAtual4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual4ActionPerformed

    private void alocacaoAtual3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual3ActionPerformed

    }//GEN-LAST:event_alocacaoAtual3ActionPerformed

    private void alocacaoAtual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacaoAtual2ActionPerformed

    private void alocacaoAtual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alocacaoAtual1ActionPerformed

    }//GEN-LAST:event_alocacaoAtual1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ajuste1;
    private javax.swing.JTextField ajuste10;
    private javax.swing.JTextField ajuste11;
    private javax.swing.JTextField ajuste12;
    private javax.swing.JTextField ajuste13;
    private javax.swing.JTextField ajuste14;
    private javax.swing.JTextField ajuste15;
    private javax.swing.JTextField ajuste16;
    private javax.swing.JTextField ajuste17;
    private javax.swing.JTextField ajuste2;
    private javax.swing.JTextField ajuste3;
    private javax.swing.JTextField ajuste4;
    private javax.swing.JTextField ajuste5;
    private javax.swing.JTextField ajuste6;
    private javax.swing.JTextField ajuste7;
    private javax.swing.JTextField ajuste8;
    private javax.swing.JTextField ajuste9;
    private javax.swing.JTextField ajustePerc1;
    private javax.swing.JTextField ajustePerc10;
    private javax.swing.JTextField ajustePerc13;
    private javax.swing.JTextField ajustePerc14;
    private javax.swing.JTextField ajustePerc15;
    private javax.swing.JTextField ajustePerc16;
    private javax.swing.JTextField ajustePerc17;
    private javax.swing.JTextField ajustePerc2;
    private javax.swing.JTextField ajustePerc3;
    private javax.swing.JTextField ajustePerc4;
    private javax.swing.JTextField ajustePerc5;
    private javax.swing.JTextField ajustePerc6;
    private javax.swing.JTextField ajustePerc7;
    private javax.swing.JTextField ajustePerc8;
    private javax.swing.JTextField ajustePerc9;
    private javax.swing.JTextField alocacaoAtual1;
    private javax.swing.JTextField alocacaoAtual10;
    private javax.swing.JTextField alocacaoAtual11;
    private javax.swing.JTextField alocacaoAtual12;
    private javax.swing.JTextField alocacaoAtual13;
    private javax.swing.JTextField alocacaoAtual14;
    private javax.swing.JTextField alocacaoAtual15;
    private javax.swing.JTextField alocacaoAtual16;
    private javax.swing.JTextField alocacaoAtual17;
    private javax.swing.JTextField alocacaoAtual2;
    private javax.swing.JTextField alocacaoAtual3;
    private javax.swing.JTextField alocacaoAtual4;
    private javax.swing.JTextField alocacaoAtual5;
    private javax.swing.JTextField alocacaoAtual6;
    private javax.swing.JTextField alocacaoAtual7;
    private javax.swing.JTextField alocacaoAtual8;
    private javax.swing.JTextField alocacaoAtual9;
    private javax.swing.JTextField alocacaoPerc1;
    private javax.swing.JTextField alocacaoPerc10;
    private javax.swing.JTextField alocacaoPerc11;
    private javax.swing.JTextField alocacaoPerc12;
    private javax.swing.JTextField alocacaoPerc13;
    private javax.swing.JTextField alocacaoPerc14;
    private javax.swing.JTextField alocacaoPerc15;
    private javax.swing.JTextField alocacaoPerc16;
    private javax.swing.JTextField alocacaoPerc17;
    private javax.swing.JTextField alocacaoPerc2;
    private javax.swing.JTextField alocacaoPerc3;
    private javax.swing.JTextField alocacaoPerc4;
    private javax.swing.JTextField alocacaoPerc5;
    private javax.swing.JTextField alocacaoPerc6;
    private javax.swing.JTextField alocacaoPerc7;
    private javax.swing.JTextField alocacaoPerc8;
    private javax.swing.JTextField alocacaoPerc9;
    private javax.swing.JTextField aporteAjuste;
    private javax.swing.JTextField aporteAjustePerc;
    private javax.swing.JTextField aporteAtual;
    private javax.swing.JTextField aporteAtualPerc;
    private javax.swing.JTextField aporteFinal;
    private javax.swing.JTextField aporteFinalPerc;
    private javax.swing.JTextField aportePerfil;
    private javax.swing.JLabel atualPerc;
    private javax.swing.JTextField final1;
    private javax.swing.JTextField final10;
    private javax.swing.JTextField final11;
    private javax.swing.JTextField final12;
    private javax.swing.JTextField final13;
    private javax.swing.JTextField final14;
    private javax.swing.JTextField final15;
    private javax.swing.JTextField final16;
    private javax.swing.JTextField final17;
    private javax.swing.JTextField final2;
    private javax.swing.JTextField final3;
    private javax.swing.JTextField final4;
    private javax.swing.JTextField final5;
    private javax.swing.JTextField final6;
    private javax.swing.JTextField final7;
    private javax.swing.JTextField final8;
    private javax.swing.JTextField final9;
    private javax.swing.JTextField finalPerc1;
    private javax.swing.JTextField finalPerc10;
    private javax.swing.JTextField finalPerc11;
    private javax.swing.JTextField finalPerc12;
    private javax.swing.JTextField finalPerc13;
    private javax.swing.JTextField finalPerc14;
    private javax.swing.JTextField finalPerc15;
    private javax.swing.JTextField finalPerc16;
    private javax.swing.JTextField finalPerc17;
    private javax.swing.JTextField finalPerc2;
    private javax.swing.JTextField finalPerc3;
    private javax.swing.JTextField finalPerc4;
    private javax.swing.JTextField finalPerc5;
    private javax.swing.JTextField finalPerc6;
    private javax.swing.JTextField finalPerc7;
    private javax.swing.JTextField finalPerc8;
    private javax.swing.JTextField finalPerc9;
    private javax.swing.JMenu jAlocacao;
    private javax.swing.JLabel jCodigoCliente;
    private javax.swing.JMenuItem jCompra;
    private javax.swing.JMenuItem jConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JLabel jNomeCliente;
    private javax.swing.JTextField jTextField125;
    private javax.swing.JTextField jTextField131;
    private javax.swing.JMenuItem jVenda;
    private javax.swing.JLabel lblAssessorPerc;
    private javax.swing.JTextField multimercadoAjuste;
    private javax.swing.JTextField multimercadoAjustePerc;
    private javax.swing.JTextField multimercadoAtual;
    private javax.swing.JTextField multimercadoAtualPerc;
    private javax.swing.JTextField multimercadoFinal;
    private javax.swing.JTextField multimercadoFinalPerc;
    private javax.swing.JTextField multimercadoPerfil;
    private javax.swing.JTextField perfil1;
    private javax.swing.JTextField perfil10;
    private javax.swing.JTextField perfil11;
    private javax.swing.JTextField perfil13;
    private javax.swing.JTextField perfil14;
    private javax.swing.JTextField perfil15;
    private javax.swing.JTextField perfil16;
    private javax.swing.JTextField perfil17;
    private javax.swing.JTextField perfil2;
    private javax.swing.JTextField perfil3;
    private javax.swing.JTextField perfil4;
    private javax.swing.JTextField perfil5;
    private javax.swing.JTextField perfil6;
    private javax.swing.JTextField perfil7;
    private javax.swing.JTextField perfil8;
    private javax.swing.JTextField perfil9;
    private javax.swing.JTextField rendaFixaAjuste;
    private javax.swing.JTextField rendaFixaAjustePerc;
    private javax.swing.JTextField rendaFixaAtual;
    private javax.swing.JTextField rendaFixaAtualPerc;
    private javax.swing.JTextField rendaFixaFinal;
    private javax.swing.JTextField rendaFixaFinalPerc;
    private javax.swing.JTextField rendaFixaPerfil;
    private javax.swing.JTextField rendaVariavelAjuste;
    private javax.swing.JTextField rendaVariavelAjustePerc;
    private javax.swing.JTextField rendaVariavelAloc;
    private javax.swing.JTextField rendaVariavelAlocPerc;
    private javax.swing.JTextField rendaVariavelFinal;
    private javax.swing.JTextField rendaVariavelFinalPerc;
    private javax.swing.JTextField rendaVariavelPerfil;
    private javax.swing.JTextField totalAjuste;
    private javax.swing.JTextField totalAjustePerc;
    private javax.swing.JTextField totalAtual;
    private javax.swing.JTextField totalAtualPerc;
    private javax.swing.JTextField totalFinal;
    private javax.swing.JTextField totalFinalPerc;
    private javax.swing.JTextField totalPerfil;
    // End of variables declaration//GEN-END:variables
}
