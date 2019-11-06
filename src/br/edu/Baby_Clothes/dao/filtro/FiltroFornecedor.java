package br.edu.Baby_Clothes.dao.filtro;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;

public class FiltroFornecedor implements IFiltro{

	
	public String gerarQuerry(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		boolean flgWhere = false;
		
		String querry = "SELECT * FROM fornecedor";
		
		if(fornecedor.getId() > 0) {
			if(!flgWhere) {
				querry += " WHERE";
				flgWhere = true;
			}
			
			querry += " frn_id = " + fornecedor.getId();
		}
		
		/*
		 * if(fornecedor.getDataCriacao() != null) { if(!flgWhere) { querry += " WHERE";
		 * flgWhere = true; }
		 * 
		 * querry += ", frn_dtCriacao = " + fornecedor.getDataCriacao(); }
		 */
		
		if(fornecedor.getRazaoSocial() != null) {
			if(!flgWhere) {
				querry += " WHERE";
				flgWhere = true;
			}
			querry += " frn_razaoSocial LIKE '%" + fornecedor.getRazaoSocial() + "%'";
		}
		
		if(fornecedor.getNomeFantasia() != null) {
			if(!flgWhere) {
				querry += " WHERE";
				flgWhere = true;
			}
			querry += " frn_nomeFantasia LIKE '%" + fornecedor.getNomeFantasia() + "%'";
		}
		
		if(fornecedor.getRazaoResponsavel() != null) {
			if(!flgWhere) {
				querry += " WHERE";
				flgWhere = true;
			}
			querry += " frn_razaoResponsavel LIKE '%" + fornecedor.getRazaoResponsavel() + "%'";
		}
		
		if(fornecedor.getCnpj() != null) {
			if(!flgWhere) {
				querry += " WHERE";
				flgWhere = true;
			}
			querry += " frn_cnpj = " + fornecedor.getCnpj();
		}
		
		if(fornecedor.getEmail() != null) {
			if(!flgWhere) {
				querry += " WHERE";
				flgWhere = true;
			}
			querry += " fnr_email = " + fornecedor.getEmail();
		}
		
		if(fornecedor.getTelefone() != null) {
			if(!flgWhere) {
				querry += " WHERE";
				flgWhere = true;
			}
			querry += " frn_telefone = " + fornecedor.getTelefone();
		}
		
		return querry;
		
		
	}
	
	
	
}
