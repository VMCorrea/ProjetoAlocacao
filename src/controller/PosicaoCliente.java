package controller;

import model.Posicao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PosicaoCliente{

    private Connection conn;
    private Statement statement;
    private ConexaoInterface conexao;
    

            
    public void inserePosicaoCliente(Posicao posicao) throws ConexaoException{
    	/*Param: ?
           Cria o Cliente no Banco (mySQL)
          retorna Objeto de Model com Posicao vazia*/
	   
    	//Connection con = conexao.getConnection();
    	
    	String query = "INSERT INTO posicaoCliente (classificacao, tipo fiscal, nomeativo, vencimento, taxa, valor) VALUES (?,?,?,?,?,?)";
    	stmInserir = conexao.prepareStatement(query);
    	
  }
    
    public void buscaPosicaoCliente() throws ConexaoException{
    	/* Param: access_token do Sugar (assumindo que o Login foi feito com sucesso)
        Verifica se o Cliente existe no Sugar para o usu�rio
         se existir procurar no banco (mySQL) a posi��o do Cliente
         Armazenar em Objeto de Model ou retornar um objeto com informa��es
         se cliente n�o tiver Posicao usa metodo CriaPosicaoCliente e retorna a Posicao Zerada
         se n�o existir enviar mensagem 
          "Cliente n�o existe / sem acesso ao Cliente"*/

    	String query ="SELECT posicao FROM posicaoCliente WHERE codigoCliente=?";
        stmObterPosicao = conexao.prepareStatement(query);
 
    	
    }


	public void atualizaPosicaoCliente() throws ConexaoException {
		/*
		 *  Param: objeto de Model com informacoees atualizadas de Poscao do Cliente
                   Atualiza Cliente com base no objeto
		 * */
    	
		String query = "UPDATE posicaoCliente SET (classificacao, tipo fiscal, nomeativo, vencimento, taxa, valor) VALUES (?,?,?,?,?,?) WHERE codigoCliente=?";
        stmAtualizar = conexao.prepareStatement(query);
		
	}
	
	public void deletaPosicaoCliente() throws ConexaoException{
	    			
		String query = "DELETE FROM posicaoCliente WHERE codigoCliente=?";
        stmApagar = conexao.prepareStatement(query);
	}
			
}
