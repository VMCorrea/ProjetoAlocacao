package model;


public class Posicao {
	@SuppressWarnings("unused")
	private double assessor;
	private double cliente;
	private String produto;
	private String subproduto;
	private String produtoGarantia;
	private double cnpj;
	private String ativo;
	private String emissor;
	private double quantidade;
	private double dataVencimento;
	private double net;
	private String classificacao;
	
	public Posicao() {}
	
	public Posicao(double assessor, double cliente, String produto, String subproduto, String produtoGarantia, double cnpj, String ativo, String emissor, double quantidade, double dataVencimento, float net, String classificacao) {
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
	
	
	public void setAssessor(double assessor) {
		this.assessor = assessor;
	}
	public void setAssessor() {}
	
	public double getCliente() {
		return cliente;
	}
	public void setCliente(double cliente) {
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
	
	public double getCnpj() {
		return cnpj;
	}
	public void setCnpj(double cnpj) {
		this.cnpj = cnpj;
	}
	
	public double getNet() {
		return net;
	}
	public void setNet(double net) {
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
	
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	public double getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(double dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
}
