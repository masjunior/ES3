package br.edu.fatec.Baby_Clothes.strategy;

import java.util.List;

import br.edu.fatec.Baby_Clothes.dao.FornecedorDAO;
import br.edu.fatec.Baby_Clothes.dao.FuncionarioDAO;
import br.edu.fatec.Baby_Clothes.dao.IDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Funcionario;

public class ValidarExistencia implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		String retorno  = "";
		
		IDAO dao = null;
		if(entidade.getClass().getName().equals(Fornecedor.class.getName())) {
			Fornecedor fornecedor = (Fornecedor)entidade;
			dao = new FornecedorDAO();
			
//			System.out.println("ID FORNECEDOR " + fornecedor.getId());
			
			List<EntidadeDominio>entidadesRetorno = dao.listar(fornecedor);
			
			//System.out.println("TAMANHO LISTA VALIDAR EXISTENCIA FORNECEDOR" + entidadesRetorno.size());
			
			if(entidadesRetorno != null && !entidadesRetorno.isEmpty()) {
				//System.out.println("FORNECEDOR CADASTRADO");
				retorno += "Fornecedor j� cadastrado";
			}
		}else if(entidade.getClass().getName().equals(Funcionario.class.getName())) {
			Funcionario funcionario = (Funcionario)entidade;
			dao = new FuncionarioDAO();
			List<EntidadeDominio>entidadesRetorno = dao.listar(funcionario);
			
			if(entidadesRetorno != null && !entidadesRetorno.isEmpty()) {
				System.out.println("Funcionario ja cadastrado");
				retorno += "Funcion�rio j� cadastrado";
			}
		}
		
		return retorno;
		
	}

}
