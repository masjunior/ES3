/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

import java.util.List;

/**
 * @author Marco_Aurelio_de_Sa_Junior
 *
 */
public class Lote extends EntidadeDominio{
	private Double precoCompraUnidade;
	private int quantidadePecas;
	private List<Roupa> roupas;
	private Fornecedor fornecedor;
	// TODO Validar existencia
	public Double getPrecoCompraUnidade() {
		return precoCompraUnidade;
	}
	public void setPrecoCompraUnidade(Double precoCompraUnidade) {
		this.precoCompraUnidade = precoCompraUnidade;
	}
	public int getQuantidadePecas() {
		return quantidadePecas;
	}
	public void setQuantidadePecas(int quantidadePecas) {
		this.quantidadePecas = quantidadePecas;
	}
	public List<Roupa> getRoupas() {
		return roupas;
	}
	public void setRoupas(List<Roupa> roupas) {
		this.roupas = roupas;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
