package controller;

import java.awt.TextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class SugarConnect {

	public String login(String usuario, String senha) {	
		/*   Param: Usuario e Senha
         Retorna (se correto) access_token e refresh_token
          access_token - usado para autenticar API calls (dura 1h)
          refresh_token - usado para re-autenticar sem precisar novamente de usuario e senha 
		 * */
                
		return "";
	}

	public boolean buscaCliente(String access_token, String codigo_cliente) throws ConexaoException {
		/*
		 * Param: access_token e Codigo Cliente
           Verifica no Sugar se cliente existe e � accessivel
           Retorna true or false
		 * */

		boolean autenticado = false;
		String sql;
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21");
			sql = "SELECT access_token, codigo_cliente FROM usuarios WHERE username=? and senha=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setString(1, access_token);
			ps.setString(2, codigo_cliente);
			ResultSet rs;
			rs = ps.executeQuery();
			if (rs.next()) {
				access_token = rs.getString("acesso");
				codigo_cliente = rs.getString("idUser");
				autenticado = true;
			} else {
				ps.close();
				return autenticado;
			}
		} catch (SQLException ex){}

		return autenticado;

	}



}

	
