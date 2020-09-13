package br.edu.fatec.Baby_Clothes.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Usuario;

public class ValidarSenha implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		boolean numero = false;
		boolean caracter = false;
		boolean caracterMaiusculo = false;
		boolean caracterEspecial;
		boolean tamanho = false;
		
		Usuario usuario = (Usuario)entidade;
		String senha = usuario.getSenha();
		char[] c = senha.toCharArray();
		
		for(int i = 0; i < c.length; i++) {
			if(Character.isDigit(c[i])) {
				numero = true;
			}
			
			if(Character.isUpperCase(c[i])) {
				caracterMaiusculo = true;
			}
			
			if(Character.isLowerCase(c[i])) {
				caracter = true;
			}
			
		}
		
		Pattern p = Pattern.compile("^A-Za-z0-9]");
		Matcher m = p.matcher(senha);
		caracterEspecial = m.find();
		
		StringBuilder sb = new StringBuilder();
		
		if(senha.length() < 8) {
//			sb.append("A senha precisa ter o tamanho minimo de 8 caracteres");
		}
		
		if(!numero) {
//			sb.append("Falta a presença de um número");
		}
		
		if(!caracter) {
//			sb.append("Falta a presença de uma Letra");
		}
		
		if(!caracterMaiusculo) {
//			sb.append("Falta a presença de uma Letra Maiuscula");
		}
		
		if(!caracterEspecial) {
//			sb.append(", Falta a presença de um Caracter Especial");
		}
	
		return sb.toString();
	}

}
