package br.com.project.ServletController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.project.entidade.Usuario;
import br.com.project.entidade.UsuarioDAO;

@WebServlet("/usuController.do")
public class UsuarioController extends HttpServlet{
    
	public UsuarioController() {
		System.out.println("Novo servelt");
 	}
 
	@Override
	public void init() throws ServletException {
		System.out.println("Init....");
 		super.init();
	}
	
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		
//		 String login = req.getParameter("login");
//		 String nome = req.getParameter("nome");
//		 String senha = req.getParameter("senha");
//		 
//		 Usuario user = new Usuario();
//		 user.setLogin(login);
//		 user.setNome(nome);
//		 user.setSenha(senha);
//		 
//		 UsuarioDAO userDAO = new UsuarioDAO();
//		 userDAO.salvar(user);		
		 System.out.println("Chamou o get");
	}
	 
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 String login = req.getParameter("login");
		 String nome = req.getParameter("nome");
		 String senha = req.getParameter("senha");
		 
		 Usuario user = new Usuario();
		 user.setLogin(login);
		 user.setNome(nome);
		 user.setSenha(senha);
		 
		 UsuarioDAO userDAO = new UsuarioDAO();
		 userDAO.salvar(user);	
	}
	 
	 @Override
	public void destroy() {
		 System.out.println("irei destruir tudo");
 		super.destroy();
	}
}
