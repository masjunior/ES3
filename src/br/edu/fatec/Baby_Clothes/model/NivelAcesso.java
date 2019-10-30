/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

/**
 * @author Marco_Aurelio_de_Sa_Junior
 *
 */
public enum NivelAcesso {
	
	ADMINISTRADOR("Administrador")
	,MODERADOR_JUNIOR("Moderador Junior")
	,MODERADOR_PLENO("Moderador Pleno")
	,MODERADOR_SENIOR("Moderador Senior");
	
	private String descricao;
	
	NivelAcesso (String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
