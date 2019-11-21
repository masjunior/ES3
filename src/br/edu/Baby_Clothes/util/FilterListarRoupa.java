package br.edu.Baby_Clothes.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.edu.Baby_Clothes.dao.RoupaDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;
import br.edu.fatec.Baby_Clothes.model.Roupa;

public class FilterListarRoupa implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");
		
		if(resultado == null) {
			resultado = new Resultado();
			if(resultado.getEntidades() == null) {
				RoupaDAO dao = new RoupaDAO();
				Roupa roupa = new Roupa();
				List<EntidadeDominio> fornecedores = dao.listar(roupa); 
				
				if(fornecedores != null && !fornecedores.isEmpty()) {
					for(EntidadeDominio entidade : fornecedores) {
						resultado.adicionarEntidades(entidade);
					}
				}
				
				
				request.setAttribute("ResultadoFornecedorConsultar", resultado);
			}
		}
		
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}