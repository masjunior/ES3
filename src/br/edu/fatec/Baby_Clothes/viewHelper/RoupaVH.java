package br.edu.fatec.Baby_Clothes.viewHelper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatec.Baby_Clothes.model.Cor;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Resultado;
import br.edu.fatec.Baby_Clothes.model.Roupa;
import br.edu.fatec.Baby_Clothes.model.Tamanho;

public class RoupaVH implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Roupa roupa = criarRoupa(request);
		
		return roupa;
	}


	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher d = null;
		String operacao = request.getParameter("operacao");
		
		if(resultado.getMensagem() != null && !resultado.getMensagem().trim().equalsIgnoreCase("")) {
			request.getSession().setAttribute("ResultadoRoupa", resultado);
			//System.out.println("1");
			d = request.getRequestDispatcher("cadastrarRoupa.jsp");
			d.forward(request, response);
			
		}else if(operacao.equalsIgnoreCase("SALVAR")) {
			resultado.setMensagem("Roupa Cadastrada com Sucesso.");
			request.setAttribute("ResultadoRoupaSalvar", resultado);
			System.out.println("2");
			d = request.getRequestDispatcher("listarRoupa.jsp");
			response.sendRedirect("listarRoupa.jsp");
			
			
		}else if(operacao.equalsIgnoreCase("CONSULTAR")) {
			resultado.setMensagem("Roupa Consultada.");
			request.setAttribute("ResultadoRoupaConsultar", resultado);
			System.out.println("3");
			d = request.getRequestDispatcher("listarRoupa.jsp");
			d.forward(request, response);
			
		}else if(operacao.equalsIgnoreCase("ALTERAR")) {
			resultado.setMensagem("Roupa Alterada com Sucesso.");
			request.setAttribute("ResultadoRoupaAlterar", resultado);
			System.out.println("4");
			d = request.getRequestDispatcher("listarRoupa.jsp");
			response.sendRedirect("listarRoupa.jsp");
			
		}else if(operacao.equalsIgnoreCase("EXCLUIR")) {
			resultado.setMensagem("Roupa Excluida com Sucesso.");
			request.setAttribute("ResultadoRoupaExcluir", resultado);
			System.out.println("5");
			d = request.getRequestDispatcher("listarRoupa.jsp");
			d.forward(request, response);
			
		}
		
	//	d.forward(request, response);
		
	}

	private Roupa criarRoupa(HttpServletRequest request) {
		Roupa roupa = new Roupa();
		Lote lote = new Lote();
		Cor cor = new Cor();
		Long id = null ;
		
		if(request.getParameter("txtRoupaId")!= "") {
			id = Long.parseLong(request.getParameter("txtRoupaId"));
		}
		String dataString = request.getParameter("txtDataCadastro");

		if(dataString == null) {
			System.out.println("data vazia");
		}else {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime data = LocalDateTime.parse(dataString);
			
			roupa.setDataCriacao(data);
		}
		
		String habilitadoString = request.getParameter("txtHabilitado");
		
		String marca = request.getParameter("txtMarca");
		
		String precoString = request.getParameter("txtPrecoVenda");
		double precoVenda = 0;
		if(precoString != null) {
			precoVenda = Double.parseDouble(precoString);
		}
		
		String quantidadeString = request.getParameter("txtQuantidadeDisponivel");
		int quantidadeDisponivel = 0;
		
		if(quantidadeString != null) {
			quantidadeDisponivel = Integer.parseInt(quantidadeString);
		}
		
		String tamanho = request.getParameter("cbTamanho");
		
		String corString = request.getParameter("txtCor");
		
		String idLote = request.getParameter("txtLote");
		
		if(id != null) {
			roupa.setId(id);
		}
		
//		if(data != null) {
//		}
		
		if(habilitadoString != null) {
			roupa.setHabilitado(Boolean.valueOf(habilitadoString));
		}
		
		System.out.println("RopuaVH Habilitado " + roupa.isHabilitado());
		
		if(marca != null && !marca.trim().equals("") && !marca.isEmpty()) {
			roupa.setMarca(marca);
		}
		
		if(precoVenda > 0) {
			roupa.setPrecoVenda(precoVenda);
		}
		
		if(quantidadeDisponivel > 0) {
			roupa.setQuantidadeDisponivel(quantidadeDisponivel);
		}
		
		if(tamanho != null) {
			roupa.setTamanho(Tamanho.valueOf(tamanho));
		}
		
		if(corString != null && !corString.trim().equals("") && !corString.isEmpty()) {
			cor.setDescricao(corString);
			roupa.setCor(cor);
		}
		
		if(idLote != null){
			
			lote.setId(Long.parseLong(idLote));
			roupa.setLote(lote);
		}
		
		return roupa;
	}
}
