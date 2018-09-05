package controller;

import model.Posicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;

public class PosicaoCliente{
	
    private Connection conn;
    private Statement statement;
    private ConexaoInterface conexao;
        
  public void inserePosicaoCliente(Posicao posicao) throws ConexaoException, SQLException{
    	/*Param: ?
           Cria o Cliente no Banco (mySQL)
          retorna Objeto de Model com Posicao vazia*/
	   
    	String query = "INSERT INTO posicaoCliente (classificacaoPosicao, tipoFiscalPosicao, nomeAtivoPosicao, vencimentoPosicao, taxaPosicao, valorPosicao) VALUES (?,?,?,?,?,?)";
    	statement = conexao.prepareStatement(query);
        ResultSet rs = statement.executeQuery(query);
        
    	
  }
    
    public void buscaPosicaoCliente() throws ConexaoException, SQLException{
    	/* Param: access_token do Sugar (assumindo que o Login foi feito com sucesso)
        Verifica se o Cliente existe no Sugar para o usu�rio
         se existir procurar no banco (mySQL) a posi��o do Cliente
         Armazenar em Objeto de Model ou retornar um objeto com informa��es
         se cliente n�o tiver Posicao usa metodo CriaPosicaoCliente e retorna a Posicao Zerada
         se n�o existir enviar mensagem 
          "Cliente n�o existe / sem acesso ao Cliente"*/

    	String query ="SELECT * FROM posicaoCliente WHERE codigoCliente=?";
        statement = conexao.prepareStatement(query);
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            String classificacaoPosicao = rs.getString("Classificacao");
            String tipoFiscalPosicao = rs.getString("Tipo Fiscal");
            String nomeAtivoPosicao = rs.getString("Nome Ativo");
            float vencimentoPosicao = rs.getFloat("Vencimento");
            float taxaPosicao = rs.getFloat("Taxa"); 
            float valorPosicao = rs.getFloat("Valor");
            
        }
 
    }


	public void atualizaPosicaoCliente() throws ConexaoException, SQLException {
		/*
		 *  Param: objeto de Model com informacoees atualizadas de Posicao do Cliente
                   Atualiza Cliente com base no objeto
		 * */
    	
            String query = "UPDATE posicaoCliente SET (classificacaoPosicao, tipoFiscalPosicao, nomeAtivoPosicao, vencimentoPosicao, taxaPosicao, valorPosicao) VALUES (?,?,?,?,?,?) WHERE codigoCliente=?";
            statement = conexao.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);	
	
        }
	
	public void deletaPosicaoCliente() throws ConexaoException, SQLException{
	    			
            String query = "DELETE FROM posicaoCliente WHERE codigoCliente=?";
            statement = conexao.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
	}
			
}
