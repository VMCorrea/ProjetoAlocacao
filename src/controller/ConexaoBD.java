package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;

public class ConexaoBD{

    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://192.168.1.4:3306/alocacao";
    private String usuario = "alocacao";
    private String senha = "alocacao@2018";
    
    public ResultSet rs;
    public Statement statement;
    public Connection con;

    
    public ConexaoBD() {}

    
    public void open() throws ConexaoException {
        
        System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexao efetuada com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar conexao." +ex.getMessage());
        }
    }

    public void executaSql(String sql){
        try {
            statement = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar sql./n" +ex.getMessage());
        }    
    } 

    
    public void close() throws ConexaoException {
         try{
            con.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao.");
        }
    }

    Statement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
    
}