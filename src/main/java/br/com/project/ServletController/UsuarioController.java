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
	private static final long serialVersionUID = 1L;

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
         
		 String acao = req.getParameter("acao");
		 
		 if(acao.equals("excluir")) {
			 String id = req.getParameter("id");
			 Usuario userUsuario = new Usuario();
			 
			 if(id != null) {				 
				 userUsuario.setId(Integer.parseInt(id));
				 
				 UsuarioDAO userDAO = new UsuarioDAO();
				 userDAO.excluir(userUsuario);
				 
				 resp.getWriter().print("<h1>O peração de exclusão realizada com sucesso</h1>");
			 }else if(acao.equals("list")){
				 
			 }
		 }
	 }
	 
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 String id = req.getParameter("id");
		 String nome = req.getParameter("nome");
		 String login = req.getParameter("login");
		 String senha = req.getParameter("senha");
		 
		 Usuario user = new Usuario();
		    if(id != null) {		    	
		      user.setId(Integer.parseInt(id));
		    }
		 user.setLogin(login);
		 user.setNome(nome);
		 user.setSenha(senha);
		 
		 UsuarioDAO userDAO = new UsuarioDAO();
		 userDAO.salvar(user);	
		 
		 resp.getWriter().print("<h1>O operação realizada com sucesso</h1>");
		 
	}
	 
	 @Override
	public void destroy() {
		 System.out.println("destruir tudo");
 		super.destroy();
	}
}
