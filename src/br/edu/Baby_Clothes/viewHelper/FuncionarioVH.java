package br.edu.Baby_Clothes.viewHelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Funcionario;
import br.edu.fatec.Baby_Clothes.model.NivelAcesso;
import br.edu.fatec.Baby_Clothes.model.Resultado;

public class FuncionarioVH implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Funcionario funcionario = criarFuncionario(request);
		
		return funcionario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		RequestDispatcher d = null;
		String operacao  = request.getParameter("OPERACAO");
		
		if(resultado.getMensagem() != null && !resultado.getMensagem().trim().equals("")) {
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("SALVAR")) {
			resultado.setMensagem("Cadastro do funcionário foi realizado com sucesso!");
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("CONSULTAR")){
			resultado.setMensagem("Consulta de funcinário realizada com sucesso!");
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("ALTERAR")) {
			resultado.setMensagem("Alteração do funcionário foi realizada com sucesso!");
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}else if(operacao.equalsIgnoreCase("EXCLUIR")) {
			resultado.setMensagem("O funcionário foi excluido com sucesso!");
			request.getSession().setAttribute("Resultado", resultado);
			d = request.getRequestDispatcher("InicialFuncionario.jsp");
			
		}
		
		d.forward(request, response);
		
	}
	
	private Funcionario criarFuncionario(HttpServletRequest request) {
		Funcionario funcionario = new Funcionario();
		
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCPF");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		String nivelAcesso = request.getParameter("txtNivelAcesso");
		
		if(nome != null || !nome.trim().equals("") || !nome.isEmpty()) {
			funcionario.setNome(nome);
		}
		
		if(cpf != null || !cpf.trim().equals("") || !cpf.isEmpty()) {
			funcionario.setCpf(cpf);
		}
		
		if(email != null || !email.trim().equals("") || !email.isEmpty()) {
			funcionario.setEmail(email);
		}
		
		if(senha != null || !senha.trim().equals("") || !senha.isEmpty()) {
			funcionario.setSenha(senha);
		}
		
		if(nivelAcesso != null || nivelAcesso.trim().equals("") || nivelAcesso.isEmpty()) {
			funcionario.setNivelAcesso(NivelAcesso.valueOf(nivelAcesso));
		}
	
	
		return funcionario;
	}

}
