package br.edu.Baby_Clothes.strategy;

import java.util.InputMismatchException;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;

public class ValidarCNPJ implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Fornecedor fornecedor = (Fornecedor)entidade;
		String msgRetorno;
		String cnpj = fornecedor.getCnpj();
		
		if(cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
			|| cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
			|| cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
			|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
			|| cnpj.equals("88888888888888") || cnpj.equals("99999999999999")
			|| cnpj.length() != 14) {
			
			msgRetorno = "CNPJ Inv�lido";
		}
		
		char dig13, dig14;
		int soma, i, resultado, numero, peso;
		
		try {
			soma = 0;
			peso = 2;
			for(i = 11; i >=0; i--) {
				numero = (int)(cnpj.charAt(i) - 48);
				soma = soma + (numero * peso);
				peso++;
				if(peso == 10) {
					peso = 2;
				}
			}
			
			resultado = soma % 11;
			if((resultado == 0) || (resultado == 1)) {
				dig13 = '0';
			}else {
				dig13 = (char)((11 - resultado) + 48);
			}
			
			//Segundo Digito
			soma = 0;
			peso = 2;
			for(i = 12; i >=0; i--) {
				numero = (int)(cnpj.charAt(i) - 48);
				soma = soma + (numero * peso);
				peso++;
				if(peso == 10) {
					peso = 2;
				}
			}
			
			resultado = soma % 11;
			if((resultado == 0) || (resultado == 1)) {
				dig14 = '0';
			}else {
				dig14 = (char)((11 - resultado) + 48);
			}
			
			if((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
				msgRetorno = null;
			}else {
				msgRetorno = "CNPJ Inv�lido";
			}
			
		}catch (InputMismatchException erro) {
			msgRetorno = "Um erro inesperado aconteceu, tente novamente mais tarde!";
		}
		
		
		return msgRetorno;
	}

}
