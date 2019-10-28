/**
 * 
 */
package br.edu.fatec.Baby_Clothes.controller;

/**
 * @author Marco_Aurelio_de_Sa_Junior 
 *
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.fatec.Baby_Clothes.dao.UsuarioDAO;
import br.edu.fatec.Baby_Clothes.model.Usuario;



@WebServlet("/Autenticacao")
public class Autenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Autenticacao() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");

		Usuario usuario = new Usuario();
		usuario.setEmail(login);
		usuario.setSenha(senha);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioAutenticado = null;
		
		usuarioAutenticado = (Usuario) usuarioDAO.listarPorEntidade(usuario);

		HttpSession sessao = request.getSession();

		if (usuarioAutenticado != null ) {
			sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);
			request.getRequestDispatcher("logado.jsp").forward(request, response);

		} else {
			response.sendRedirect("login.jsp");

		}

	}

}
