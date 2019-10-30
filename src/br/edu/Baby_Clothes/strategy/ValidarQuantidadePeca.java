package br.edu.Baby_Clothes.strategy;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class ValidarQuantidadePeca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Roupa roupa = (Roupa)entidade;
		String msgRetorno;
		
		if(roupa.getQuantidadeDisponivel() < 0) {
			msgRetorno = "Quantidade invalida. Esperado uma quantidade maior!";
		}else {
			msgRetorno = null;
		}
		
		return msgRetorno;
	}

	
	
}
