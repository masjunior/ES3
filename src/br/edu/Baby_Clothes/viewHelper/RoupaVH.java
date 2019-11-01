package br.edu.Baby_Clothes.viewHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class RoupaVH implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Roupa roupa = criarRoupa(request);
		
		return roupa;
	}


	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	private Roupa criarRoupa(HttpServletRequest request) {
		return null;
	}
}
