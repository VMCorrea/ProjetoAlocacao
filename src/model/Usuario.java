package model;

import javax.swing.JOptionPane;
import java.util.Date;
import view.TelaResumo;

public class Usuario {

    private Integer id_user;
    private String nome;
    private String senha;
    private Date dataCadastro;

    
    public Integer getId() {
        return id_user;
    }

    public void setId(Integer id) {
        this.id_user = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha.trim();
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    
    public void validaLogin(String login, char[] pwd) {
        if(login.equals("lifetime")){ 
            JOptionPane.showMessageDialog(null,"Bem-vindo."); 
            TelaResumo resumo = new TelaResumo();
            resumo.setVisible(true); 
        } else{ JOptionPane.showMessageDialog(null,"Credencias invalidas."); }
     }
    
}
