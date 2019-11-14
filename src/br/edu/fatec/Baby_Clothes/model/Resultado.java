package br.edu.fatec.Baby_Clothes.model;

import java.util.ArrayList;
import java.util.List;

public class Resultado {

	private String mensagem;
	private List<EntidadeDominio> entidades;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<EntidadeDominio> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<EntidadeDominio> entidades) {
		this.entidades = entidades;
	}
	
	public List<EntidadeDominio> adicionarEntidades(EntidadeDominio entidade){
		if(entidades == null) {
			entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
		}else {
			entidades.add(entidade);
		}
	return entidades;
	}
	
}
