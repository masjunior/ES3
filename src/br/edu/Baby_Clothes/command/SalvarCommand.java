package br.edu.Baby_Clothes.command;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class SalvarCommand extends AbstractCommand {

	@Override
	public Resultado executar(EntidadeDominio entidade) {
		
		System.out.println("ID COMMAND " + entidade.getId());
		
		return fachada.salvar(entidade);
		
	}
	
}
