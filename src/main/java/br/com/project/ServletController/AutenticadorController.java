package br.com.project.ServletController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.project.entidade.Usuario;
import br.com.project.entidade.UsuarioDAO;

 
@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  String login = req.getParameter("login");
	  String senha = req.getParameter("senha");
	  
	  Usuario usuario = new Usuario();
	  usuario.setLogin(login);
	  usuario.setSenha(senha);
	  
	  UsuarioDAO userDAO = new UsuarioDAO();
	  Usuario userAutenticado = userDAO.Autenticar(usuario);
	  
	  if(userAutenticado != null) {
		 HttpSession sessao = req.getSession();
		 sessao.setAttribute("userAutenticado", userAutenticado);		 
		 sessao.setMaxInactiveInterval(60*5);
		 
 		 req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp); 
	  }else {
		  resp.getWriter().print("<script> window.alert ('Usuairo não encontrado(a)'); location.href='login.html' </script>");
		  
	  }

	}
}
