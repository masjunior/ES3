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

}
