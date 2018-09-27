package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexaoBD{


    private String driver = "com.mysql.jdbc.Driver";

    public ResultSet rs = null;
    public Statement statement = null;
    public Connection con = null;

    public ConexaoBD(){}
    
    
    public void first(){
        try {
            rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void open() throws ConexaoException, ClassNotFoundException {

        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://192.168.1.4:3306/alocacao?useTimezone=true&serverTimezone=UTC", "alocacao", "alocacao@2018");
                //JOptionPane.showMessageDialog(null, "Conexao efetuada com sucesso.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro conexao: " + ex.getMessage());
            }
        }
    }
    
    public void executaSql(String sql) {
         try {
                statement = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
                //JOptionPane.showMessageDialog(null, sql);
                rs = statement.executeQuery(sql);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro sql: " + ex.getMessage());
            }
         
    }

    public void close() throws ConexaoException {
        if (con == null) {
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexao.");
            }
        }
    }

    Statement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
