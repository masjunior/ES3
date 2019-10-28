/**
 * 
 */
package br.edu.fatec.Baby_Clothes.dao;

import java.util.List;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;

/**
 * @author Marco_Aurelio_de_Sa_Junior 
 *
 */
public class UsuarioDAO implements IDAO{

	@Override
	public boolean cadastrar(EntidadeDominio obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(EntidadeDominio obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(EntidadeDominio obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EntidadeDominio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntidadeDominio listarPorEntidade(EntidadeDominio obj) {
		// TODO Aqui validar por login e senha
		return null;
	}

}
