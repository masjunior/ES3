package br.edu.Baby_Clothes.dao.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		List<Integer> qtdCampos = null;
		Map<Integer, String> campos = null;
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
			qtdCampos = new ArrayList<Integer>();
			campos = new HashMap<Integer, String>();
			
			if(lote.getId() > 0) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(0, "lot_id = " + lote.getId());
				qtdCampos.add(0);
			}
			
			if(lote.getDataCriacao() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(1, "lot_data_criacao = " + lote.getDataCriacao());
				qtdCampos.add(1);
			}
			
			if(lote.getPrecoCompraUnidade() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(2, "lot_precoCompraUnidade = " + lote.getPrecoCompraUnidade());
				qtdCampos.add(2);
			}
			
			if(lote.getFornecedor() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(3, "lot_fornecedor = " + lote.getFornecedor());
				qtdCampos.add(3);
			}
			
			for(Integer I : qtdCampos) {
				if(I != qtdCampos.get(0)) {
					sql += " AND ";
				}
				sql += campos.get(I);
			}
			
			
			
			
			return sql;
			
		}
		
		
		
		
		return null;	
	}

}
