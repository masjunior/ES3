/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

/**
 * @author Marco_Aurelio_de_Sa_Junior
 *
 */
public enum NivelAcesso {
	
	ADMINISTRADOR(4)
	,MODERADOR_JUNIOR(1)
	,MODERADOR_PLENO(2)
	,MODERADOR_SENIOR(3);
	
	private int valor;
	
	NivelAcesso (int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static NivelAcesso getByName(int num) {
		switch (num) {
		case 4:
			return ADMINISTRADOR;
		case 1:
			return MODERADOR_JUNIOR;
		case 2:
			return MODERADOR_PLENO;
		case 3:
			return MODERADOR_SENIOR;
		default:
			return null;
		}
	
	}

}
