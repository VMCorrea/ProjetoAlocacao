package model;

import java.sql.Date;

public class Produto {

    private String produto;
    private String subproduto;
    private String produtoGarantia;
    private String cnpj;
    private String ativo;
    private String emissor;
    private Date dataVencimento;
    private String classificacao;

    public Produto(){}

    public Produto(String produto, String subproduto, String cnpj, String ativo, String emissor, Date dataVencimento, String classificacao) {
        setProduto(produto);
        setSubproduto(subproduto);
        setCnpj(cnpj);
        setAtivo(ativo);
        setEmissor(emissor);
        setDataVencimento(dataVencimento);
        setClassificacao(classificacao);
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getSubproduto() {
        return subproduto;
    }

    public void setSubproduto(String subproduto) {
        this.subproduto = subproduto;
    }

    public String getProdutoGarantia() {
        return produtoGarantia;
    }

    public void setProdutoGarantia(String produtoGarantia) {
        this.produtoGarantia = produtoGarantia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }


}
