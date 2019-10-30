package br.edu.Baby_Clothes.command;

import br.edu.Baby_Clothes.fachada.Fachada;
import br.edu.Baby_Clothes.fachada.IFachada;

public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();
	
}
