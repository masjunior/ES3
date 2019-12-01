package br.edu.Baby_Clothes.command;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public interface ICommand {

	public Resultado executar(EntidadeDominio entidade, String operacao);
	
}
