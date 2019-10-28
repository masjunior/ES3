/**
 * 
 */
package br.edu.fatec.Baby_Clothes.model;

/**
 * @author Marco_Aurelio_de_Sa_Junior 
 *
 */
public enum Tamanho {
	
	RN("Recém Nascido")
	,P("0 a 3 meses")
	,M("4 a 6 meses")
	,G("7 a 10 meses")
	,GG("11 a 12 meses");
	
	private String descricao;
	
	Tamanho (String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

//	Tamanho	Idade	Altura (menino)	Altura (menina)
//	RN	Recém Nascido	50 cm	49 cm
//	P	0 a 3 meses	50 a 63 cm	49 a 62 cm
//	M	4 a 6 meses	63 a 66 cm	62 a 65 cm
//	G	7 a 10 meses	66 a 72 cm	65 a 71 cm
//	GG	11 a 12 meses	72 a 75 cm	71 a 73 cm
//	1	1 ano	75 a 82 cm	73 a 80 cm
//	2	1 a 2 anos	82 a 87 cm	80 a 86 cm
//	3	2 a 3 anos	87 a 95 cm	86 a 95 cm
//	4	3 a 5 anos	95 a 107 cm	95 a 108 cm
//	6	4 a 5 anos	101 a 107 cm	102 a 108 cm
//	8	5 a 7 anos	107 a 120 cm	108 a 119 cm
//	10	7 a 9 anos	120 a 131 cm	119 a 130 cm
	
}
