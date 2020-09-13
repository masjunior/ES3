package br.edu.fatec.Baby_Clothes.dao.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Usuario;

public class FiltroUsuario implements IFiltro{

	@Override
	public String gerarQuerry(EntidadeDominio entidade) {
		Usuario usuario = (Usuario)entidade;
		List<Integer> qtdCampos = new ArrayList<Integer>();
		Map<Integer, String> campos = new HashMap<Integer, String>();
		boolean flgWhere = false;
		String sql = "SELECT * FROM usuario";
		
		if(usuario != null) {
			 if(usuario.getId() != null) {
					if(!flgWhere) {
						sql += " WHERE ( ";
						flgWhere = true;
					}
					campos.put(0, "usu_id = " + usuario.getId());
					qtdCampos.add(0);
				}
			 
			 if(usuario.getDataCriacao() != null) {
					if(!flgWhere) {
						sql += " WHERE ( ";
						flgWhere = true;
					}
					campos.put(1, "usu_data_criacao = " + "'" + usuario.getDataCriacao() + "'");
					qtdCampos.add(1);
				}
				
				if(usuario.isHabilitado() != null) {
					if(!flgWhere) {
						sql += " WHERE ( ";
						flgWhere = true;
					}
					campos.put(3, "usu_habilidato = " + usuario.isHabilitado());
					qtdCampos.add(3);
				}
				
				if(usuario.getEmail() != null) {
					if(!usuario.getEmail().trim().equalsIgnoreCase("")) {
						if(!flgWhere) {
							sql += " WHERE ( ";
							flgWhere = true;
						}
						campos.put(4, "usu_email = " + "'" + usuario.getEmail() + "'");
						qtdCampos.add(4);
					}
				}
				
				if(usuario.getSenha() != null) {
					if(!usuario.getSenha().trim().equals("")) {
						if(!flgWhere) {
							sql += " WHERE ( ";
							flgWhere = true;
						}
						campos.put(5, "usu_senha = " + "'" + usuario.getSenha() + "'" );
						qtdCampos.add(5);
					}
				}
				
				if(usuario.getNivelAcesso() != null) {
					if(!flgWhere) {
						sql += " WHERE ( ";
						flgWhere = true;
					}
					campos.put(6, "usu_nivel_acesso = " + usuario.getNivelAcesso().ordinal());
					qtdCampos.add(6);
				}
		} 
			
		
		
		
		
		
		
		for(Integer I : qtdCampos) {
			if(I != qtdCampos.get(0)) {
				sql += " AND ";
			}
			sql += campos.get(I);
		}
		
		if(flgWhere) {
			sql +=" );";
		}
		
		return sql;
	}

}
