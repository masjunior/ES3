package br.edu.fatec.Baby_Clothes.model;

import java.time.LocalDateTime;

/**
 * @author Marco_Aurelio_de_Sa_Junior 
 *
 */
public class EntidadeDominio{

	protected Long id;

	protected LocalDateTime dataCriacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
} 
