package br.edu.Baby_Clothes.strategy;

import java.util.InputMismatchException;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;

public class ValidarCPF implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
	
		Funcionario funcionario = (Funcionario)entidade;
		String msgRetorno = "";
		String cpf = funcionario.getCpf();
		
		if(cpf.equals("00000000000") || cpf.equals("11111111111")
			|| cpf.equals("22222222222") || cpf.equals("33333333333")
			|| cpf.equals("44444444444") || cpf.equals("55555555555")
			|| cpf.equals("66666666666") || cpf.equals("77777777777")
			|| cpf.equals("88888888888") || cpf.equals("99999999999")
			|| cpf.length() != 11) {
			
//			msgRetorno = "CPF Inv�lido";
		}
		
		char dig10, dig11;
		int soma, i, numero, peso, resultado;
		
		try {
			soma = 0;
			peso = 10;
			for(i = 0; i < 9; i++) {
				//Converte a letra em numero pela tabela ASCII
				numero = (int)(cpf.charAt(i) - 48);
				soma = soma + (numero + peso);
				peso--;
			}
		
			resultado = 11 - (soma % 11);
			if((resultado == 10) || (resultado ==11)) {
				dig10 = '0';
			}else {
				dig10 = (char)(resultado + 48);
			}
			
			//Segundo Digito
			soma = 0;
			peso = 11;
			for(i = 0; i < 10; i++) {
				numero = (int)(cpf.charAt(i)-48);
				soma = soma + (numero * peso);
				peso--;
			}
			
			resultado = 11 - (soma % 11);
			if((resultado == 10) || (resultado == 11)) {
				dig11 = '0';
			}else {
				dig11 = (char)(resultado + 48);
			}
			
			//Verifica se os digitos calculados conferem os digitos informados
			if((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
//				msgRetorno = null;
			}else {
//				msgRetorno = "CPF Inv�lido";
			}
		}catch (InputMismatchException erro){
//				msgRetorno = "Um erro inesperado aconteceu, tente novamente mais tarde!";
		}
		
	
		
		
		return msgRetorno;
	}

}
