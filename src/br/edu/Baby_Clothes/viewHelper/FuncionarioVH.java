package br.edu.Baby_Clothes.viewHelper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;
import br.edu.fatec.Baby_Clothes.model.NivelAcesso;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class FuncionarioVH implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Funcionario funcionario = salvarFuncionario(request);
		
		return funcionario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		RequestDispatcher d = null;
		String operacao  = request.getParameter("operacao");
		
		if(resultado.getMensagem() != null && !resultado.getMensagem().trim().equals("")) {
			request.getSession().setAttribute("ResultadoFuncionario", resultado);
			d = request.getRequestDispatcher("cadastrarUsuario.jsp");
			d.forward(request, response);
			
		}else if(operacao.equalsIgnoreCase("SALVAR")) {
			resultado.setMensagem("Cadastro do funcion�rio foi realizado com sucesso!");
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("listaFuncionario.jsp");
			response.sendRedirect("listaFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("CONSULTAR")){
			resultado.setMensagem("Consulta de funcionário realizada com sucesso!");
			request.getSession().setAttribute("ResultadoFuncionarioConsultar", resultado);
			d = request.getRequestDispatcher("editarFuncionario.jsp");
			//d.forward(request, response);
			response.sendRedirect("editarFuncionario.jsp");

			
		}else if(operacao.equalsIgnoreCase("ALTERAR")) {
			resultado.setMensagem("Altera��o do funcion�rio foi realizada com sucesso!");
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("listaFuncionario.jsp");
			response.sendRedirect("listaFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("EXCLUIR")) {
			resultado.setMensagem("O funcion�rio foi excluido com sucesso!");
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("listaFuncionario.jsp");
			d.forward(request, response);
		}
		 
		//d.forward(request, response);
		
	}
	
	private Funcionario salvarFuncionario(HttpServletRequest request) {
		Funcionario funcionario = new Funcionario();
		
		String id = request.getParameter("txtId");
		String dtCadastro = request.getParameter("txtDtCadastro");
		String habilitado = request.getParameter("txtHabilitado");
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCPF");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		String nivelAcesso = request.getParameter("txtNivelAcesso");
		
		if(id != null ) {
			if(!id.trim().equalsIgnoreCase("") || !id.isEmpty()) {
				funcionario.setId(Long.parseLong(id));
			}
		}
		
		if(dtCadastro != null) {
			if( !dtCadastro.trim().equalsIgnoreCase("") || dtCadastro.isEmpty()) {
				LocalDateTime date = LocalDateTime.parse(dtCadastro);
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM--dd HH:mm:ss");
//				funcionario.setDataCriacao(LocalDateTime.parse(dtCadastro, formatter));
				funcionario.setDataCriacao(date);
			}
		}
		
		if(habilitado != null ) {
			funcionario.setHabilitado(Boolean.valueOf(habilitado));
		}
			
		if(nome != null) {
			if(!nome.trim().equals("") || !nome.isEmpty()) {
				funcionario.setNome(nome);
			}
		}
		
		if(cpf != null) {
			if(!cpf.trim().equals("") || !cpf.isEmpty()) {
				funcionario.setCpf(cpf);
			}
		}
		
		if(email != null) {
			if(!email.trim().equals("") || !email.isEmpty()) {
				funcionario.setEmail(email);
			}
		}
		
		if(senha != null) {
			if(!senha.trim().equals("") || !senha.isEmpty()) {
				funcionario.setSenha(senha);
			}
		}
		
		if(nivelAcesso != null) {
			funcionario.setNivelAcesso(NivelAcesso.valueOf(nivelAcesso));
		}
		
//		if(operacao.equalsIgnoreCase("SALVAR")) {
//			HttpSession sessao = request.getSession();
//			EntidadeDominio entidade = (EntidadeDominio) sessao.getAttribute("Resultado");
//			funcionario.setId(entidade.getId());
//			funcionario.setId(Long.parseLong("5"));
//		}
	
	
		return funcionario;
	}

}
