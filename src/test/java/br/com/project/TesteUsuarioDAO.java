package br.com.project;

import br.com.project.entidade.Usuario;
import br.com.project.entidade.UsuarioDAO;

public class TesteUsuarioDAO {
   
	
	public static void main(String[] args) {
		testeExcluir();
	}
	
	public static void testeAlterar() {
		Usuario usu = new Usuario();
		usu.setId(1);
  		usu.setNome("Sasuke Uchira");
  		usu.setLogin("Sasuke");
  		usu.setSenha("matarUmsertoAlguem");
  		
  		UsuarioDAO usuDAO = new UsuarioDAO();
  		usuDAO.update(usu);
  		
  		System.out.println("Usuario Alterado som sucesso !!!");
	}
  		
  		
  		
      public static void testeCadastrar(){
		Usuario usu = new Usuario();
  		usu.setNome("lucas code");
  		usu.setLogin("lucas");
  		usu.setSenha("lucalua@1222");
  		
  		UsuarioDAO usuDAO = new UsuarioDAO();
  		usuDAO.cadastrar(usu);
  		
  		System.out.println("Cadastrado com sucesso !!!!!");
      }
      
      

      public static void testeExcluir(){
		Usuario usu = new Usuario();
		usu.setId(2);
  		
  		UsuarioDAO usuDAO = new UsuarioDAO();
  		usuDAO.excluir(usu);
  		
  		System.out.println("excluido com sucesso !!!!!");
      }
	
}
