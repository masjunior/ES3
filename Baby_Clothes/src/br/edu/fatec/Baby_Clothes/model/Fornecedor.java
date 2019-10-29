/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

import java.util.List;

/**
 * @author Marco_Aurelio_de_Sa_Junior marco
 *
 */
public class Fornecedor extends EntidadeDominio{
	private String razaoSocial;
	private String cnpj;
	private String nomeFantasia;
	private String razaoResponsavel;
	private String email;
	private String telefone;
	private List<Lote> lotes;
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoResponsavel() {
		return razaoResponsavel;
	}
	public void setRazaoResponsavel(String razaoResponsavel) {
		this.razaoResponsavel = razaoResponsavel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Lote> getLotes() {
		return lotes;
	}
	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

}
