package br.edu.Baby_Clothes.dao.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class FiltroRoupa implements IFiltro{

	@Override
	public String gerarQuerry(EntidadeDominio entidade) {
		Roupa roupa = (Roupa)entidade;
		List<Integer> qtdCampos = new ArrayList<Integer>();
		Map<Integer, String> campos = new HashMap<Integer, String>();
		String sql = "SELECT * FROM roupa  JOIN lote ON rou_lote = lot_id JOIN fornecedor ON lot_fornecedor = frn_id ";
		boolean flgWhere = false;
		
		if(roupa.getId() != null) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(0, "rou_id = " + roupa.getId());
			qtdCampos.add(0);
		}
		
		if(roupa.getDataCriacao() != null) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(1, "rou_data_criacao = " + roupa.getDataCriacao());
			qtdCampos.add(1);
		}
		
		if(roupa.isHabilitado() != null) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(2, "rou_habilitado = " + roupa.isHabilitado());
			qtdCampos.add(2);
		}
		
		if(roupa.getMarca() != null) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(3, "rou_marca = " + roupa.getMarca());
			qtdCampos.add(3);
		}
		
		if(roupa.getPrecoVenda() != null) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(4, "rou_preco_venda = " + roupa.getPrecoVenda());
			qtdCampos.add(4);
		}
		
		if(roupa.getQuantidadeDisponivel() >0 ) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(5, "rou_quantidade_disponivel = " + roupa.getQuantidadeDisponivel());
			qtdCampos.add(5);
		}
		
		if(roupa.getTamanho() != null) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(6, "rou_tamanho = " + roupa.getTamanho().getValor());
			qtdCampos.add(6);
		}
		
		if(roupa.getLote() != null) {
			if(!flgWhere) {
				sql += " WHERE ";
				flgWhere = true;
			}
			campos.put(7, "rou_lote = " + roupa.getLote().getId());
			qtdCampos.add(7);
		}
		

		if(roupa.getCor() != null) {
			if(roupa.getCor().getDescricao() != null) {
				if(!roupa.getCor().getDescricao().trim().equals("")) {
					if(!flgWhere) {
						sql += " WHERE ";
						flgWhere = true;
					}
					campos.put(8, "rou_cor LIKE '%" + roupa.getCor().getDescricao() + "%'");
					qtdCampos.add(8);
				}
			}
			
		}
		
		for(Integer I : qtdCampos) {
			if(I != qtdCampos.get(0)) {
				sql += " AND ";
			}
			sql += campos.get(I);
			
		}
		
		System.out.println("ESTE E DO MARCO NO FILTRO ROUPA " + sql);
		return sql;
		
	}

}
