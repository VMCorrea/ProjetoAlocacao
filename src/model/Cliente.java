package model;

import java.util.*;

/**
 * 
 */
public class Cliente {

    public Cliente() {
    }

    public long CodigoCliente;
    public String NomeCliente;
    public Date DataNascimento;

    public long getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(long CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
}