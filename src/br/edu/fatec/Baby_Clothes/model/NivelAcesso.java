/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

/**
 * @author Marco_Aurelio_de_Sa_Junior
 *
 */
public enum NivelAcesso {
	
	ADMINISTRADOR(1)
	,MODERADOR_JUNIOR(2)
	,MODERADOR_PLENO(3)
	,MODERADOR_SENIOR(4);
	
	private int valor;
	
	NivelAcesso (int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

}
