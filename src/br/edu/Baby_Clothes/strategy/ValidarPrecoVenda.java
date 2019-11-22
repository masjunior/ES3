package br.edu.Baby_Clothes.strategy;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class ValidarPrecoVenda implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Roupa roupa = (Roupa)entidade;
		String msgRetorno;
		if(roupa.getLote().getPrecoCompraUnidade() < roupa.getPrecoVenda()) {
			msgRetorno = "valor de venda inv�lido. Esperado um valor maior que o valor de compra!";
		}else {
			msgRetorno = null;
		}
		
		return msgRetorno;
	}

}
