/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

/**
 * @author Marco_Aurelio_de_Sa_Junior
 *
 */
public class Usuario extends EntidadeDominio {
	
	private String email;
	private String senha;
	private NivelAcesso nivelAcesso;
	
	
	public Usuario() {
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
	

	public Usuario(String email, String senha, NivelAcesso nivelAcesso) {
		this.email = email;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
		
	}
	
	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}


}
