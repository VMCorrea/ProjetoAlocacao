package model;

import java.sql.Date;


public class Posicao {

	@SuppressWarnings("unused")
	private int assessor;
	private int cliente;
	private String produto;
	private String subproduto;
	private String produtoGarantia;
	private int cnpj;
	private String ativo;
	private String emissor;
	private float quantidade;
	private Date dataVencimento;
	private float net;
	private String classificacao;
        
        private String pesquisa;
        
	
	public Posicao() {}
	
	public Posicao(int assessor, int cliente, String produto, String subproduto, String produtoGarantia, int cnpj, String ativo, String emissor, float quantidade, Date dataVencimento, float net, String classificacao) {
		this.assessor = assessor;
		this.cliente = cliente;
		this.produto = produto;
		this.subproduto = subproduto;
		this.produtoGarantia = produtoGarantia;
		this.cnpj = cnpj;
		this.ativo = ativo;
		this.emissor = emissor;
		this.quantidade = quantidade;
		this.dataVencimento = dataVencimento;
		this.net = net;
		this.classificacao = classificacao;		
	}	
	
	
	public void setAssessor(int assessor) {
		this.assessor = assessor;
	}
	public void setAssessor() {}
	
	public double getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
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
	
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	public float getNet() {
		return net;
	}
	public void setNet(float net) {
		this.net = net;
	}
	
	public String getProdutoGarantia() {
		return produtoGarantia;
	}
	public void setProdutoGarantia(String produtoGarantia) {
		this.produtoGarantia = produtoGarantia;
	}
	
	public String getEmissor() {
		return emissor;
	}
	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
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
	
        
    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
        
}
