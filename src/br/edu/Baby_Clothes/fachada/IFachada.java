package br.edu.Baby_Clothes.fachada;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public interface IFachada {

	public Resultado salvar(EntidadeDominio entidade, String operacao);
	public Resultado alterar(EntidadeDominio entidade, String operacao);
	public Resultado excluir(EntidadeDominio entidade, String operacao);
	public Resultado consultar(EntidadeDominio entidade, String operacao);
	
}
