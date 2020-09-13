package br.edu.fatec.Baby_Clothes.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatec.Baby_Clothes.command.AlterarCommand;
import br.edu.fatec.Baby_Clothes.command.ConsultarCommand;
import br.edu.fatec.Baby_Clothes.command.ExcluirCommand;
import br.edu.fatec.Baby_Clothes.command.ICommand;
import br.edu.fatec.Baby_Clothes.command.SalvarCommand;
import br.edu.fatec.Baby_Clothes.viewHelper.FornecedorVH;
import br.edu.fatec.Baby_Clothes.viewHelper.FuncionarioVH;
import br.edu.fatec.Baby_Clothes.viewHelper.IViewHelper;
import br.edu.fatec.Baby_Clothes.viewHelper.LoteVH;
import br.edu.fatec.Baby_Clothes.viewHelper.RoupaVH;
import br.edu.fatec.Baby_Clothes.model.EntidadeDominio;
import br.edu.fatec.Baby_Clothes.model.Resultado;

@WebServlet(urlPatterns = {"/FuncionarioController", "/ProdutoController", "/FornecedorController", "/LoteController"})
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private Map<String, ICommand> commands;
	private Map<String, IViewHelper> viewHelpers;
	
	public Controller() {
		commands = new HashMap<String, ICommand>();
		commands.put("SALVAR", new SalvarCommand());
		commands.put("ALTERAR", new AlterarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		viewHelpers = new HashMap<String, IViewHelper>();
		viewHelpers.put("/es3_2020/FuncionarioController", new FuncionarioVH());
		viewHelpers.put("/es3_2020/ProdutoController", new RoupaVH());
		viewHelpers.put("/es3_2020/FornecedorController", new FornecedorVH());
		viewHelpers.put("/es3_2020/LoteController", new LoteVH());
	}
	
	
	protected void Processar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String uri = request.getRequestURI();
		String operacao = request.getParameter("operacao");
		
		IViewHelper viewHelper = viewHelpers.get(uri);
		
		EntidadeDominio entidade = viewHelper.getEntidade(request);
		
		ICommand command = commands.get(operacao);
		
		
		Resultado resultado = command.executar(entidade, operacao);
		
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
