package br.edu.Baby_Clothes.strategy;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class ValidarPrecoVenda implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Roupa roupa = (Roupa)entidade;
		String msgRetorno = "";
		
		double valorCompra = roupa.getPrecoCompra();
		double valorVenda = roupa.getPrecoVenda();
		
		
		
		if(valorCompra > valorVenda) {
//			System.out.println("pre�o vendo invalido");
			msgRetorno = "Pre�o de venda inv�lido";
		}
		
		
		return msgRetorno;
	}

}
