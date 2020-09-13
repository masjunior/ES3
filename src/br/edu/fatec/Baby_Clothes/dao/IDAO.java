package br.edu.fatec.Baby_Clothes.dao;

import java.util.List;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;

public interface IDAO {

	public void cadastrar(EntidadeDominio entidade);
	public void remover(EntidadeDominio entidade);
	public void alterar(EntidadeDominio entidade);
	public List<EntidadeDominio> listar(EntidadeDominio entidade);
}
	