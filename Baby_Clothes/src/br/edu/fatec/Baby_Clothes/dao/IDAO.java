package br.edu.fatec.Baby_Clothes.dao;

import java.util.List;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;

public interface IDAO {

	public boolean cadastrar(EntidadeDominio obj);
	public boolean remover(EntidadeDominio obj);
	public boolean alterar(EntidadeDominio obj);
	public List<EntidadeDominio> listar();
}
	