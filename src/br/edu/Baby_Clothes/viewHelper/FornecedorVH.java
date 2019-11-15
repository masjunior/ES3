package br.edu.Baby_Clothes.viewHelper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Fornecedor;
import br.edu.fatec.Baby_Clothes.model.Lote;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class FornecedorVH implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Fornecedor fornecedor = criarFornecedor(request);
		
		return fornecedor;
	}


	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;
		String operacao  = request.getParameter("operacao");
		
		if(resultado.getMensagem() != null && !resultado.getMensagem().trim().equals("")) {
			System.out.println(resultado.getMensagem());
			request.getSession().setAttribute("ResultadoFornecedor", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
		}else if(operacao.equalsIgnoreCase("SALVAR")) {
			resultado.setMensagem("Cadastro do fornecedor foi realizado com sucesso!");
			request.getSession().setAttribute("ResultadoFornecedorSalvar", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");

		}else if(operacao.equalsIgnoreCase("CONSULTAR")){
			resultado.setMensagem("Consulta de fornecedorrealizada com sucesso!");
			request.getSession().setAttribute("ResultadoFornecedorConsultar", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("ALTERAR")) {
			resultado.setMensagem("Alteração do fornecedor foi realizada com sucesso!");
			request.getSession().setAttribute("ResultadoFornecedorAlterar", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("EXCLUIR")) {
			resultado.setMensagem("O fornecedor foi excluido com sucesso!");
			request.getSession().setAttribute("ResultadoFornecedorExcluir", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}
		d.forward(request, response);
		
	}
		
	

	private Fornecedor criarFornecedor(HttpServletRequest request) {
		Fornecedor fornecedor = new Fornecedor();
		
		String operacao = request.getParameter("operacao");
		String idString = request.getParameter("txtId");
		Long id;
		
		System.out.println("ID" + idString);
		
		if(idString == null || idString.equals("")) {
			 System.out.println("ID NULO");
		}else {
			id = Long.parseLong(idString);
			fornecedor.setId(id);
		}
		
		
		
		String dataString = request.getParameter("txtData");
		
		
	
		if(dataString == null) {
			System.out.println("data vazia");
		}else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime date = LocalDateTime.parse(dataString, formatter);
			fornecedor.setDataCriacao(date);
		}
		
		
		String razaoSocial = request.getParameter("txtRazaoSocial");
		String cnpj = request.getParameter("txtCNPJ");
		String nomeFantasia = request.getParameter("txtNomeFantasia");
		String razaoResponsavel = request.getParameter("txtRazaoResponsavel");
		String email = request.getParameter("txtEmail");
		String telefone = request.getParameter("txtTelefone");
		List<Lote> lotes = new ArrayList<Lote>(); 
		
		/*
		 * if(id != null || id > 0) { fornecedor.setId(id); }
		 */
		
		/*
		 * if(date != null) { fornecedor.setDataCriacao(date); }
		 */
		
		if(razaoSocial != null || !razaoSocial.trim().equals("") || !razaoSocial.isEmpty()) {
			fornecedor.setRazaoSocial(razaoSocial);
		}
		
		if(cnpj != null || !cnpj.trim().equals("") || !cnpj.isEmpty()) {
			fornecedor.setCnpj(cnpj);
		}
	
		if(nomeFantasia != null || !nomeFantasia.trim().equals("") || !nomeFantasia.isEmpty()) {
			fornecedor.setNomeFantasia(nomeFantasia);
		}
			
		if(razaoResponsavel != null || !razaoResponsavel.trim().equals("") || !razaoResponsavel.isEmpty()) {
			fornecedor.setRazaoResponsavel(razaoResponsavel);
		}
		
		if(email != null || !email.trim().equals("") || !email.isEmpty()) {
			fornecedor.setEmail(email);
		}
		
		if(telefone != null || !telefone.trim().equals("") || !telefone.isEmpty()) {
			fornecedor.setTelefone(telefone);
		}
		
		fornecedor.setLotes(lotes);
		
		if(operacao.equalsIgnoreCase("SALVAR")) {
			HttpSession sessao = request.getSession();
			EntidadeDominio entidade = (EntidadeDominio) sessao.getAttribute("Resultado");
//			fornecedor.setId(entidade.getId());
			fornecedor.setId(Long.parseLong("5"));
		}
		
		
		return fornecedor;
	}

}
