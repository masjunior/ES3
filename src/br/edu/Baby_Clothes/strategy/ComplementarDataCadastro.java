package br.edu.Baby_Clothes.strategy;

import java.time.LocalDateTime;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;

public class ComplementarDataCadastro implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		entidade.setDataCriacao(LocalDateTime.now());
		
		return null;
	}

}
