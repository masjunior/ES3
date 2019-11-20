package br.edu.Baby_Clothes.dao.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;

public class FiltroFornecedor implements IFiltro{

	
	public String gerarQuerry(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		List<Integer> qtdCampos = new ArrayList<Integer>();
		Map<Integer, String> campos = new HashMap<Integer, String>();
		boolean flgWhere = false;
		
		String querry = "SELECT * FROM fornecedor";
		
		
		System.out.println("inicio IFS filtroFornecedor");
		
		if(fornecedor == null) {
			System.out.println("fornecedor nulo");
		}
		
		if(fornecedor.getId() == null) {
			System.out.println("Id nulo");
			
		}else if(fornecedor.getId() > 0) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(0, "frn_id = " + fornecedor.getId());
			qtdCampos.add(0);
		} 
		
		
		if(fornecedor.getDataCriacao() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			
			campos.put(1, "frn_data_criacao = " + fornecedor.getDataCriacao());
			qtdCampos.add(1);
		}
		
//		if(fornecedor.isHabilitado() != null) {
//			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
//			}
//			campos.put(2, "frn_habilitado = " + fornecedor.isHabilitado());
			campos.put(2, "frn_habilitado = true");
			qtdCampos.add(2);
//		}
		  
		if(fornecedor.getRazaoSocial() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(3, "frn_razaoSocial LIKE '%" + fornecedor.getRazaoSocial() + "%'");
			qtdCampos.add(3);
		}
		
		if(fornecedor.getNomeFantasia() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(4, "frn_nomeFantasia LIKE '%" + fornecedor.getNomeFantasia() + "%'");
			qtdCampos.add(4);
		}
		
		if(fornecedor.getRazaoResponsavel() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(5, "frn_razaoResponsavel LIKE '%" + fornecedor.getRazaoResponsavel() + "%'");
			qtdCampos.add(5);
		}
		
		if(fornecedor.getCnpj() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(6, "frn_cnpj LIKE '%" + fornecedor.getCnpj() + "%'");
			qtdCampos.add(6);
		}
		
		if(fornecedor.getEmail() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(7, "frn_email LIKE '%" + fornecedor.getEmail() + "%'");
			qtdCampos.add(7);
		}
		
		if(fornecedor.getTelefone() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(8, "frn_telefone LIKE '%" + fornecedor.getTelefone() + "%'");
			qtdCampos.add(8);
		}
		
		for(Integer I : qtdCampos) {
			if(I != qtdCampos.get(0)) {
				querry += " AND ";
			}
			
			querry += campos.get(I);
		}
		
		System.out.println(querry);
		
		return querry;
		
		
	}
	
	
	
}
