package br.edu.Baby_Clothes.dao.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;

public class FiltroFuncionario implements IFiltro{

	@Override
	public String gerarQuerry(EntidadeDominio entidade) {
		Funcionario funcionario = (Funcionario)entidade;
		List<Integer> qtdCampos = new ArrayList<Integer>();
		Map<Integer, String> campos = new HashMap<Integer, String>();
		boolean flgWhere = false;
		
		String sql = "SELECT * FROM funcionario JOIN usuario ON usu_id = fun_usuario";
		
		
		if(funcionario != null) {
			
			if(funcionario.getId() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(0, "fun_id = " + funcionario.getId());
				qtdCampos.add(0);
			}
			
			if(funcionario.getNome() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(1, "fun_nome LIKE '%" + funcionario.getNome() + "%'");
				qtdCampos.add(1);
			}
			
			if(funcionario.getCpf() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(2,"fun_cpf LIKE '%" + funcionario.getCpf() + "%'");
				qtdCampos.add(2);
			}
			
			if(funcionario.getUsuario() != null) {
				if(funcionario.getUsuario().getId() != null) {
					if(!flgWhere) {
						sql += " WHERE ";
						flgWhere = true;
					}
					campos.put(3, "fun_usuario = " + funcionario.getUsuario().getId());
					qtdCampos.add(3);
				}
			}
			
			
		}
		
		for(Integer I : qtdCampos) {
			if(I != qtdCampos.get(0)) {
				sql += " AND ";
			}
			sql += campos.get(I);
		}
		
//		System.out.println("SQL FUNCIONARIO" + sql);
		return sql;
	}

}
