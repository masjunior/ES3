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
		
		if(fornecedor.getId() > 0) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(0, "frn_id = " + fornecedor.getId());
			qtdCampos.add(0);
		}
		
		/*
		 * if(fornecedor.getDataCriacao() != null) { if(!flgWhere) { querry += " WHERE";
		 * flgWhere = true; }
		 * 
		 * querry += ", frn_dtCriacao = " + fornecedor.getDataCriacao(); }
		 */
		
		if(fornecedor.getRazaoSocial() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(1, "frn_razaoSocial LIKE '%" + fornecedor.getRazaoSocial() + "%'");
			qtdCampos.add(1);
		}
		
		if(fornecedor.getNomeFantasia() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(2, "frn_nomeFantasia LIKE '%" + fornecedor.getNomeFantasia() + "%'");
			qtdCampos.add(2);
		}
		
		if(fornecedor.getRazaoResponsavel() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(3, "frn_razaoResponsavel LIKE '%" + fornecedor.getRazaoResponsavel() + "%'");
			qtdCampos.add(3);
		}
		
		if(fornecedor.getCnpj() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(4, "frn_cnpj = " + fornecedor.getCnpj());
			qtdCampos.add(4);
		}
		
		if(fornecedor.getEmail() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(5, "fnr_email = " + fornecedor.getEmail());
			qtdCampos.add(5);
		}
		
		if(fornecedor.getTelefone() != null) {
			if(!flgWhere) {
				querry += " WHERE ";
				flgWhere = true;
			}
			campos.put(6, "frn_telefone = " + fornecedor.getTelefone());
			qtdCampos.add(6);
		}
		
		for(Integer I : qtdCampos) {
			if(I != qtdCampos.get(0)) {
				querry += " AND ";
			}
			
			querry += campos.get(I);
		}
		
		return querry;
		
		
	}
	
	
	
}
