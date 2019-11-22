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

import br.edu.Baby_Clothes.dao.FuncionarioDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;
import br.edu.fatec.Baby_Clothes.model.Resultado;

@WebFilter(urlPatterns= {"/login.jsp", "/listaFuncionario.jsp"})
public class FilterListarFuncionario implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Resultado resultado = (Resultado)request.getAttribute("ResultadoFuncionarioConsultar");
		
		if(resultado == null) {
			resultado = new Resultado();
			if(resultado.getEntidades() == null) {
				FuncionarioDAO dao = new FuncionarioDAO();
				Funcionario funcionario  = new Funcionario();
				List<EntidadeDominio> funcionarios = dao.listar(funcionario); 
				
				
				if(funcionarios != null && !funcionarios.isEmpty()) {
					for(EntidadeDominio entidade : funcionarios) {
						if(entidade.isHabilitado() != null) {
							if(entidade.isHabilitado()) {
								resultado.adicionarEntidades(entidade);
							}
							
						}
						
					}
				}
				
				
				request.setAttribute("ResultadoFuncionarioConsultar", resultado);
			}
		}
		
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
