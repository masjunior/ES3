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
	private int quantidadePecas;
	private List<Roupa> roupas;
	private Fornecedor fornecedor;
	// TODO Validar existencia

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
