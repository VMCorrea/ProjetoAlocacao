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
    	/*Param: ?
           Cria o Cliente no Banco (mySQL)
          retorna Objeto de Model com Posicao vazia*/
	   
    	String query = "INSERT INTO alocacoes (classificacao, garantia_produto, ativo, data_vencimento, NET) VALUES (?,?,?,?,?)";
    	pst = conex.con.prepareStatement(query);
        
        pst.setString(1, pos.getClassificacao());
        pst.setString(2, pos.getSubproduto());
        pst.setString(3, pos.getAtivo());
        pst.setDate(4, pos.getDataVencimento());
        pst.setFloat(5, pos.getNet());
        
        pst.execute();
        	
  }
    
    public Posicao buscaPosicaoCliente(Posicao mod) throws ConexaoException, SQLException{
    	/* Param: access_token do Sugar (assumindo que o Login foi feito com sucesso)
         se cliente nao tiver Posicao usa metodo CriaPosicaoCliente e retorna a Posicao Zerada
         */
  
        conex.open();
        conex.executaSql("SELECT * FROM posicaoCliente WHERE id_cliente LIKE '%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setClassificacao(conex.rs.getString("classificacao"));
            //PRODUTO GARANTIA = TIPO FISCAL ?
            mod.setProdutoGarantia(conex.rs.getString("garantia_produto")); //??????????????
            mod.setAtivo(conex.rs.getString("ativo"));
            mod.setDataVencimento(conex.rs.getDate("data_vencimento"));
            mod.setNet(conex.rs.getFloat("NET"));
            
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente não existe / Sem acesso ao cliente.");
        }
                
        conex.close();
        return mod;
    }

    public void atualizaPosicaoCliente() throws ConexaoException, SQLException {
   	
        String query = "UPDATE alocacoes SET classificacao=?, garantia_produto=?, ativo=?, data_vencimento=?, NET=? WHERE id_cliente= ?";
    	pst = conex.con.prepareStatement(query);
        
        pst.setString(1, pos.getClassificacao());
        pst.setString(2, pos.getSubproduto());
        pst.setString(3, pos.getAtivo());
        pst.setDate(4, pos.getDataVencimento());
        pst.setFloat(5, pos.getNet());
        
        pst.execute();	
	
        }
	
	public void deletaPosicaoCliente() throws ConexaoException, SQLException{
	    			
            String query = "DELETE FROM alocacoes WHERE id_cliente=?";
            pst = conex.con.prepareStatement(query);
            pst.execute(query);
	}
       
	
}
