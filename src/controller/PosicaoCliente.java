package controller;

import model.Posicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class PosicaoCliente{
	
    private Connection con;
    private Statement statement; 
    private PreparedStatement pst;
    ConexaoBD conex = new ConexaoBD();
    Posicao pos = new Posicao();
    
 
        
    public void inserePosicaoCliente(Posicao posicao) throws ConexaoException, SQLException{
       
    	String query = "INSERT INTO alocacao.catalogo_op (classificacao, garantia, ativo, data_vencimento) VALUES (?,?,?,?)";
        pst = conex.con.prepareStatement(query);
        pst.setString(1, pos.getClassificacao());
        pst.setString(2, pos.getProdutoGarantia());
        pst.setString(3, pos.getAtivo());
        pst.setDate(4, pos.getDataVencimento());
       
        
        pst.execute();
        	
  }
    
    public Posicao buscaPosicaoCliente(Posicao mod) throws ConexaoException, SQLException, ClassNotFoundException{
        try {
            conex.open();
            conex.executaSql("SELECT cat.classificacao, cat.garantia, cat.ativo, cat.data_vencimento, al.NET\n"
                    + "FROM alocacao.catalogo_op AS cat\n"
                    + "INNER JOIN alocacao.alocacoes AS al\n"
                    + "ON cat.id = al.catalogo_id \n"
                    + "WHERE al.cliente_id LIKE '%" + mod.getPesquisa() + "%'");
            conex.rs.first();
            mod.setClassificacao(conex.rs.getString("classificacao"));
            mod.setProdutoGarantia(conex.rs.getString("garantia")); 
            mod.setAtivo(conex.rs.getString("ativo"));
            mod.setDataVencimento(conex.rs.getDate("data_vencimento"));
            mod.setNet(conex.rs.getFloat("NET"));
            
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente não existe / Sem acesso ao cliente.");
        }
                
        conex.close();
        return mod;
    }

    public void atualizaPosicaoCliente() throws ConexaoException, SQLException, ClassNotFoundException {
        conex.open();

        String query = "UPDATE alocacao.catalogo_op SET ativo=?, "
                + "data_vencimento=?, classificacao=?, garantia=?, quantidade=? "
                + "INNER JOIN alocacos AS al ON al.id = id WHERE id=?";
        pst = conex.con.prepareStatement(query);

        pst.setString(1, pos.getClassificacao());
        pst.setString(2, pos.getSubproduto());
        pst.setString(3, pos.getAtivo());
        pst.setDate(4, pos.getDataVencimento());
        pst.setFloat(5, pos.getNet());

        pst.execute();
        conex.close();
    }
	
	public void deletaPosicaoCliente() throws ConexaoException, SQLException, ClassNotFoundException{
	    conex.open();
            
            String query = "DELETE FROM alocacao.alocacoes WHERE cliente_id=?";
            pst = conex.con.prepareStatement(query);
            pst.execute(query);
            
            conex.close();
	}
       
	
}
