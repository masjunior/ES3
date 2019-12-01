package br.edu.Baby_Clothes.command;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class AlterarCommand extends AbstractCommand{

	@Override
	public Resultado executar(EntidadeDominio entidade, String operacao) {
		return fachada.alterar(entidade, operacao);
	}

}
