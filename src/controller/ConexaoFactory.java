package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoFactory implements ConexaoInterface {
    
    private String hostname = "";
    private String usuario = "";
    private String senha = "";
    private String nomeBancoDados;
    private Connection connection;
    String driver = "com.mysql.jdbc.Driver";

    public ConexaoFactory() {}

    @Override
    public Connection getConnection() throws ConexaoException {
        if (connection == null) {
            try {
                Class.forName(driver);
                String url = "jdbc:mysql://" + hostname +  "/" + nomeBancoDados;
                connection = DriverManager.getConnection(url, usuario, senha);
             
           } catch (ClassNotFoundException ex) {
                throw new ConexaoException("Driver JDBC nao encontrado!") ;   
            } catch (SQLException ex) {
                throw new ConexaoException("Falha ao abrir conexao!");
            } catch (Exception e){
                throw new ConexaoException("Ops...Algo deu errado!");
            }

        }
        return connection;
    }

    @Override
    public void close() throws ConexaoException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new ConexaoException("Falha ao fechar a conexao!");
            }
        }
    }

	@Override
	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
