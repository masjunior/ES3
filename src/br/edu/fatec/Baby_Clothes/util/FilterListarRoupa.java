package br.edu.fatec.Baby_Clothes.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.edu.fatec.Baby_Clothes.dao.RoupaDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;
import br.edu.fatec.Baby_Clothes.model.Roupa;

//@WebFilter(urlPatterns = {"/login.jsp", "/cadastrarFornecedor.jsp", "/cadastrarLote.jsp", "/cadastrarRoupa.jsp",  "/listarFornecedor.jsp", "/listarLote.jsp", "/listarRoupa"})
@WebFilter(urlPatterns = {"/listarRoupa.jsp", "/editarRoupa.jsp"})
public class FilterListarRoupa implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Resultado resultado = (Resultado)request.getAttribute("ResultadoRoupaConsultar");
		String id = (String)request.getParameter("txtRoupaId");
		
		if(resultado == null) {
			resultado = new Resultado();
			if(resultado.getEntidades() == null) {
				RoupaDAO dao = new RoupaDAO();
				Roupa roupa = new Roupa();
				if(id != null) {
					roupa.setId(Long.parseLong(id));
				}
			
				List<EntidadeDominio> roupas = dao.listar(roupa); 
				
				
				
				if(roupas != null && !roupas.isEmpty()) {
					for(EntidadeDominio entidade : roupas) {
						if(entidade.isHabilitado()) {
							resultado.adicionarEntidades(entidade);
						}
						
					}
				}
				
				
				request.setAttribute("ResultadoRoupaConsultar", resultado);
			}
		}
		
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
