package model;

import java.sql.Date;


public class Posicao extends Produto{

	@SuppressWarnings("unused")
	private String cliente;
	private float quantidade;
	private float net;

        
        private String pesquisa;
        
	
	public Posicao() {}
	
	public Posicao(String cliente, String produto, String subproduto, String produtoGarantia, String cnpj, String ativo, String emissor, float quantidade, Date dataVencimento, float net, String classificacao) {
		setCliente(cliente);
		setProduto(produto);
		setSubproduto(subproduto);
		setProdutoGarantia(produtoGarantia);
		setCnpj(cnpj);
		setAtivo(ativo);
		setEmissor(emissor);
		setQuantidade(quantidade);
		setDataVencimento(dataVencimento);
		setNet(net);
		setClassificacao(classificacao);
	}	

	public void setAssessor() {}
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public float getNet() {
		return net;
	}
	public void setNet(float net) {
		this.net = net;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
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
