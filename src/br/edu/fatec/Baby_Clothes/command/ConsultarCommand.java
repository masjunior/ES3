package br.edu.fatec.Baby_Clothes.command;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class ConsultarCommand extends AbstractCommand{

	@Override
	public Resultado executar(EntidadeDominio entidade, String operacao) {
		return fachada.consultar(entidade, operacao);
	}

}
