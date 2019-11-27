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

import br.edu.Baby_Clothes.dao.LoteDAO;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Resultado;

//@WebFilter(urlPatterns = {"/login.jsp", "/cadastrarFornecedor.jsp", "/cadastroLote.jsp", "/cadastrarProduto.jsp",  "/listarFornecedor.jsp", "/listarLote.jsp"})
@WebFilter(urlPatterns = {"/listarLote.jsp", "/cadastrarProduto.jsp","/editarLote.jsp", "/editarRoupa.jsp"})
public class FilterListarLote implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Resultado resultado = (Resultado)request.getAttribute("ResultadoLoteConsulta");
		String id = (String)request.getParameter("txtLoteId");
		
		if(resultado == null) {
			resultado = new Resultado();
			
			if(resultado.getEntidades() == null) {
//				System.out.println("ENTROU IF CONSULTA");
				LoteDAO dao = new LoteDAO();
				Lote lote = new Lote();
				if(id != null) {
					lote.setId(Long.parseLong(id));
				}
				
				lote.setHabilitado(true);
				List<EntidadeDominio>lotes = dao.listar(lote);
				
				
				
				if(lotes == null || lotes.isEmpty()) {
//					System.out.println("LISTA NULA");
				}
				
				if(lotes != null && !lotes.isEmpty()) {
					for(EntidadeDominio entidade : lotes) {
						if(entidade.isHabilitado()) {
							resultado.adicionarEntidades(entidade);
						}
						
					}
				}
				
				
//			System.out.println("Tamanho LIsta Filter" + resultado.getEntidades().size());
			request.setAttribute("ResultadoLoteConsulta", resultado);
			}
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
