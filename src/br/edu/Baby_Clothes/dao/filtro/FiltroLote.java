package br.edu.Baby_Clothes.dao.filtro;

import java.util.HashMap;
import java.util.Map;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Lote;

public class FiltroLote implements IFiltro {

	private Map<String, EntidadeDominio> entidades;
	
	public FiltroLote() {
		entidades = new HashMap<String, EntidadeDominio>();
		entidades.put(Fornecedor.class.getName(), new Fornecedor());
		entidades.put(Lote.class.getName(), new Lote());
	}
	
	@Override
	public String gerarQuerry(EntidadeDominio entidade) {
	
		EntidadeDominio etd = entidades.get(entidade.getClass().getName());
		
		String sql = "SELECT * FROM lote";
		boolean flgWhere = false;
		
		//Cria SQL para a consultar os lotes de determinado fornecedor
		if(etd.getClass().getName().equalsIgnoreCase(Fornecedor.class.getName())) {
			Fornecedor fornecedor = (Fornecedor)etd;
			
			if(fornecedor.getId() > 0) {
				sql += " WHERE lot_fornecedor = " + fornecedor.getId();
				
			}
			
			return sql;
			
		//Cria SQL para consultar o lote inteiro
		}else if(etd.getClass().getName().equalsIgnoreCase(Lote.class.getName())) {
			Lote lote = (Lote)etd;
			
			if(lote.getId() > 0) {
				if(!flgWhere) {
					sql += " WHERE";
					flgWhere = true;
				}
				sql += " lot_id = " + lote.getId();
			}
			
			if(lote.getDataCriacao() != null) {
				if(!flgWhere) {
					sql += " WHERE";
					flgWhere = true;
				}
				sql += " lot_data_criacao = " + lote.getDataCriacao();
			}
			
			if(lote.getPrecoCompraUnidade() != null) {
				if(!flgWhere) {
					sql += " WHERE";
					flgWhere = true;
				}
				sql += " lot_precoCompraUnidade = " + lote.getPrecoCompraUnidade();
			}
			
			if(lote.getFornecedor() != null) {
				if(!flgWhere) {
					sql += " WHERE";
					flgWhere = true;
				}
				sql += " lot_fornecedor = " + lote.getFornecedor();
			}
			
			return sql;
			
		}
		
		
		
		
		return null;	
	}

}
