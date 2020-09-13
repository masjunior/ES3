package br.edu.fatec.Baby_Clothes.command;

import br.edu.fatec.Baby_Clothes.fachada.Fachada;
import br.edu.fatec.Baby_Clothes.fachada.IFachada;

public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();
	
}
