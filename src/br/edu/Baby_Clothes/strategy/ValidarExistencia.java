package br.edu.Baby_Clothes.strategy;

import br.edu.Baby_Clothes.dao.FornecedorDAO;
import br.edu.Baby_Clothes.dao.FuncionarioDAO;
import br.edu.Baby_Clothes.dao.IDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Funcionario;

public class ValidarExistencia implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		String retorno  = null;
		
		IDAO dao = null;
		if(entidade.getClass().getName().equals(Fornecedor.class.getName())) {
			Fornecedor fornecedor = (Fornecedor)entidade;
			dao = new FornecedorDAO();
			
			if(dao.listar(fornecedor).size() != 0) {
				retorno += "Fornecedor já cadastrado";
			}
		}else if(entidade.getClass().getName().equals(Funcionario.class.getName())) {
			Funcionario funcionario = (Funcionario)entidade;
			dao = new FuncionarioDAO();
			
			if(dao.listar(funcionario).size() != 0) {
				retorno += "Funcionário já cadastrado";
			}
		}
		
		return retorno;
		
	}

}
