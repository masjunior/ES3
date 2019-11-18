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
			
			if(fornecedor == null) {
				System.out.println("fornecedor nulo");
			}else if(fornecedor.getId() > 0) {
				sql += " WHERE lot_fornecedor = " + fornecedor.getId();
				
			}		
			
			
			return sql;
			
		//Cria SQL para consultar o lote inteiro
		}else if(etd.getClass().getName().equalsIgnoreCase(Lote.class.getName())) {
			Lote lote = (Lote)etd;
			qtdCampos = new ArrayList<Integer>();
			campos = new HashMap<Integer, String>();
			
			if(lote.getId() == null) {
				System.out.println("ID LOTE NULO");
			}else {
				if(lote.getId() > 0) {
					if(!flgWhere) {
						sql += " WHERE ";
						flgWhere = true;
					}
					campos.put(0, "lot_id = " + lote.getId());
					qtdCampos.add(0);
				}
			}
				
			
			if(lote.getDataCriacao() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(1, "lot_data_criacao = " + lote.getDataCriacao());
				qtdCampos.add(1);
			}
			
			if(lote.isHabilitado() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(2, "lot_habilitado = " + lote.isHabilitado());
				qtdCampos.add(2);
				
			}
			
			if(lote.getPrecoCompraUnidade() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(3, "lot_precoCompraUnidade = " + lote.getPrecoCompraUnidade());
				qtdCampos.add(3);
			}
			
			if(lote.getQuantidadePecas() > 0) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(4, "lot_quantidadePecas = " + lote.getQuantidadePecas());
				qtdCampos.add(4);
			}
			
			if(lote.getFornecedor() != null) {
				if(!flgWhere) {
					sql += " WHERE ";
					flgWhere = true;
				}
				campos.put(5, "lot_fornecedor = " + lote.getFornecedor().getId());
				qtdCampos.add(5);
			}
			
			for(Integer I : qtdCampos) {
				if(I != qtdCampos.get(0)) {
					sql += " AND ";
				}
				sql += campos.get(I);
			}
			
			
			
			System.out.println(sql);
			return sql;
			
		}
		
		
		
		
		return null;	
	}

}
