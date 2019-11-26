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
			d.forward(request, response);
		}else if(operacao.equalsIgnoreCase("SALVAR")) {
			resultado.setMensagem("Cadastro de Lote realizado com Sucesso.");
			request.setAttribute("ResultadoLoteSalvo", resultado);
			response.sendRedirect("listarLote.jsp");
//			d = request.getRequestDispatcher("cadastroLote.jsp");
			
		}else if(operacao.equalsIgnoreCase("CONSULTAR")) {
			resultado.setMensagem("Consulta Realizada");
			request.setAttribute("ResultadoConsultaLote", resultado);
			d = request.getRequestDispatcher("listarLote.jsp");
			d.forward(request, response);
			
		}else if(operacao.equalsIgnoreCase("ALTERAR")) {
			resultado.setMensagem("Alteração realizada com Sucesso.");
			request.setAttribute("ResultadoAlterarLote", resultado);
			d = request.getRequestDispatcher("listarLote.jsp");
			response.sendRedirect("listarLote.jsp");
			
		}else if(operacao.equalsIgnoreCase("EXCLUIR")) {
			resultado.setMensagem("Lote excluido com Sucesso.");
			request.setAttribute("ResultadoExcluirLote", resultado);
			d = request.getRequestDispatcher("listarLote.jsp");
			d.forward(request, response);
		}
		

		
	}

	private Lote criarLote(HttpServletRequest request) {
		Lote lote = new Lote();
		Fornecedor fornecedor = new Fornecedor();
		
		
		Long id;
		
		String dataString = request.getParameter("txtData");
		
		String idString = request.getParameter("txtLoteId");
		
		String habilitadoString = request.getParameter("txtHabilitado");
		
		String precoString = request.getParameter("txtPrecoCompraUnidade");
		double precoCompraUnidade = 0;
		
		if(precoString == null || precoString.equals("")) {
			System.out.println("PRECO VAZIO");
		}else {
			precoCompraUnidade = Double.parseDouble(precoString);
		}
		
		
		String quantidadeString = request.getParameter("txtQuantidadePecas");
		int quantidadePecas = 0;
		
		if(quantidadeString == null || quantidadeString.equals("")) {
			System.out.println("QUANTIDADE VAZIA");
		}else {
			quantidadePecas =  Integer.parseInt(quantidadeString);
		}
		
		String idFornecedorString = request.getParameter("cbFornecedor");
		Long idFornecedor;
		
		if(idString == null || idString.equals("")) {
			 System.out.println("ID NULO");
		}else {
			id = Long.parseLong(idString);
			lote.setId(id);
		}
		
		if(dataString == null) {
			System.out.println("DATA VAZIA");
		}else {
			LocalDateTime date = LocalDateTime.parse(dataString);
			lote.setDataCriacao(date);
		}
		
		if(habilitadoString != null) {
			lote.setHabilitado(Boolean.parseBoolean(habilitadoString));
		}
		
		if(precoCompraUnidade > 0) {
			lote.setPrecoCompraUnidade(precoCompraUnidade);
		}
		
		if(quantidadePecas > 0) {
			lote.setQuantidadePecas(quantidadePecas);
		}
		
		if(idFornecedorString == null || idFornecedorString.equals("")) {
			System.out.println("ID FORNECEDOR VAZIO");
		}else {
			idFornecedor = Long.parseLong(idFornecedorString);
			fornecedor.setId(idFornecedor);
			lote.setFornecedor(fornecedor);
		}
		
		return lote;
	}
}
