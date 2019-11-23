package br.edu.Baby_Clothes.viewHelper;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class LoteVH implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Lote lote = criarLote(request);
		
		return lote;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		RequestDispatcher d = null;
		String operacao = request.getParameter("operacao");
		
		if(resultado.getMensagem() != null && !resultado.getMensagem().trim().equals("")) {
			request.setAttribute("ResutladoLote", resultado);
			d = request.getRequestDispatcher("cadastroLote.jsp");
			
		}else if(operacao.equalsIgnoreCase("SALVAR")) {
			resultado.setMensagem("Cadastro de Lote realizado com Sucesso.");
			request.setAttribute("ResultadoLoteSalvo", resultado);
			response.sendRedirect("listarLote.jsp");
//			d = request.getRequestDispatcher("cadastroLote.jsp");
			
		}else if(operacao.equalsIgnoreCase("CONSULTAR")) {
			resultado.setMensagem("Consulta Realizada");
			request.setAttribute("ResultadoConsultaLote", resultado);
			d = request.getRequestDispatcher("listarLote.jsp");
			
		}else if(operacao.equalsIgnoreCase("ALTERAR")) {
			resultado.setMensagem("Alteração realizada com Sucesso.");
			request.setAttribute("ResultadoAlterarLote", resultado);
			d = request.getRequestDispatcher("listarLote.jsp");
			
		}else if(operacao.equalsIgnoreCase("EXCLUIR")) {
			resultado.setMensagem("Lote excluido com Sucesso.");
			request.setAttribute("ResultadoExcluirLote", resultado);
			d = request.getRequestDispatcher("listarLote.jsp");
		}
		
		d.forward(request, response);
		
	}

	private Lote criarLote(HttpServletRequest request) {
		Lote lote = new Lote();
		Fornecedor fornecedor = new Fornecedor();
		
		
//		Long id = Long.parseLong(request.getParameter("txtId"));
		
//		String dataString = request.getParameter("txtData");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		LocalDateTime data = LocalDateTime.parse(dataString, formatter);
		
		String habilitadoString = request.getParameter("txtHabilitado");
		boolean habilitado = Boolean.getBoolean(habilitadoString);
		
		String precoString = request.getParameter("txtPrecoCompraUnidade");
		double precoCompraUnidade = Double.parseDouble(precoString);
		
		String quantidadeString = request.getParameter("txtQuantidadePecas");
		int quantidadePecas = Integer.parseInt(quantidadeString);
		
		Long idFornecedor = Long.parseLong(request.getParameter("txtFornecedor"));
		
//		if(id != null || !id.equals("") || id > 0) {
//			lote.setId(id);
//		}
		
//		if(data != null || !data.equals("")) {
			lote.setDataCriacao(LocalDateTime.now());
//		}
		
		if(habilitado == true || habilitado == false) {
			lote.setHabilitado(habilitado);
		}
		
		if(precoCompraUnidade >=0) {
			lote.setPrecoCompraUnidade(precoCompraUnidade);
		}
		
		if(quantidadePecas >= 0) {
			lote.setQuantidadePecas(quantidadePecas);
		}
		
		if(idFornecedor != null || !idFornecedor.equals("") || idFornecedor > 0) {
			fornecedor.setId(idFornecedor);
			lote.setFornecedor(fornecedor);
		}
		
		return lote;
	}
}
