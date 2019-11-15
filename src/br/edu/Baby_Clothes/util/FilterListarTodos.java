package br.edu.Baby_Clothes.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.edu.Baby_Clothes.dao.FornecedorDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Resultado;

@WebFilter(urlPatterns = {"/listarFornecedor.jsp"})
public class FilterListarTodos implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		System.out.println("Entrou FIlter");
		
		Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");
		
		if(resultado == null) {
			System.out.println("primero if");
			resultado = new Resultado();
			/*
			 * List<EntidadeDominio> entidades = resultado.getEntidades();
			 * 
			 * if(entidades == null) { System.out.println("entidade nula"); }
			 */
			
			
			if(resultado.getEntidades() == null) {
				System.out.println("Segundo if");
				FornecedorDAO dao = new FornecedorDAO();
				Fornecedor fornecedor = new Fornecedor();
				List<EntidadeDominio> fornecedores = dao.listar(fornecedor); 
				
				if(fornecedores != null && !fornecedores.isEmpty()) {
					for(EntidadeDominio entidade : fornecedores) {
						resultado.adicionarEntidades(entidade);
					}
				}
				
				
				System.out.println("final segundo if");
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
