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


//@WebFilter(urlPatterns = {"/login.jsp", "/cadastrarFornecedor.jsp", "/cadastroLote.jsp", "/cadastrarProduto.jsp",  "/listarFornecedor.jsp", "/listarLote.jsp"})
@WebFilter(urlPatterns = { "/listarFornecedor.jsp", "/cadastroLote.jsp", "/editarFornecedor.jsp", "/editarLote.jsp"})
public class FilterListarFornecedor implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Resultado resultado = (Resultado)request.getAttribute("ResultadoFornecedorConsultar");
		String id = (String)request.getParameter("txtId");
		
		if(resultado == null) {
			resultado = new Resultado();
			if(resultado.getEntidades() == null) {
				FornecedorDAO dao = new FornecedorDAO();
				Fornecedor fornecedor = new Fornecedor();
				if(id != null) {
					fornecedor.setId(Long.parseLong(id));
				}
				List<EntidadeDominio> fornecedores = dao.listar(fornecedor); 
				
				if(fornecedores != null && !fornecedores.isEmpty()) {
					for(EntidadeDominio entidade : fornecedores) {
						if(entidade.isHabilitado()) {
							resultado.adicionarEntidades(entidade);
						}
						
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
