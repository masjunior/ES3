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
		System.out.println("passei no filter");
		
		
		
//		Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");
		Resultado resultado = new Resultado ();
//		if(resultado.getEntidades().size() <= 0) {
			FornecedorDAO dao = new FornecedorDAO();
			Fornecedor fornecedor = new Fornecedor();
			List<EntidadeDominio> fornecedores = dao.listar(fornecedor); 
			
			for(EntidadeDominio entidade : fornecedores) {
				resultado.adicionarEntidades(entidade);
			}
			
			request.setAttribute("ResultadoFornecedorConsultar", resultado);
//		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}