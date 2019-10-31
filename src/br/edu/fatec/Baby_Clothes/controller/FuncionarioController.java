package br.edu.fatec.Baby_Clothes.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.Baby_Clothes.command.AlterarCommand;
import br.edu.Baby_Clothes.command.ConsultarCommand;
import br.edu.Baby_Clothes.command.ExcluirCommand;
import br.edu.Baby_Clothes.command.ICommand;
import br.edu.Baby_Clothes.command.SalvarCommand;
import br.edu.Baby_Clothes.viewHelper.FuncionarioVH;
import br.edu.Baby_Clothes.viewHelper.IViewHelper;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;

@WebServlet(urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private Map<String, ICommand> commands;
	private Map<String, IViewHelper> viewHelpers;
	
	public FuncionarioController() {
		commands = new HashMap<String, ICommand>();
		commands.put("SALVAR", new SalvarCommand());
		commands.put("ALTERAR", new AlterarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		
		viewHelpers = new HashMap<String, IViewHelper>();
		viewHelpers.put("/ES3/FuncionarioController", new FuncionarioVH());
	}
	
	
	protected void Processar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String uri = request.getRequestURI();
		String operacao = request.getParameter("OPERACAO");
		
		IViewHelper viewHelper = viewHelpers.get(uri);
		EntidadeDominio entidade = viewHelper.getEntidade(request);
		
		ICommand command = commands.get(operacao);
		Resultado resultado = command.executar(entidade);
		
		viewHelper.setView(resultado, request, response);
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Processar(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Processar(req, resp);
	}

}