/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

/**
 * @author Marco_Aurelio_de_Sa_Junior
 *
 */
public class Usuario extends EntidadeDominio {
	
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private NivelAcesso nivelAcesso;
	
	public Usuario() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public Usuario(String nome, String cpf, String email, String senha, NivelAcesso nivelAcesso) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}


}
