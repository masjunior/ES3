package br.edu.fatec.Baby_Clothes.dao.filtro;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;

public interface IFiltro {

	public String gerarQuerry(EntidadeDominio entidade);
	
}
