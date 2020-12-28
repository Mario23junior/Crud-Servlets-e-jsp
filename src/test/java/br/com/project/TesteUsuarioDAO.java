package br.com.project;

import br.com.project.entidade.Usuario;
import br.com.project.entidade.UsuarioDAO;

public class TesteUsuarioDAO {
   
	
	public static void main(String[] args) {
		testSalvar();
	}
	
	public static void testeAlterar() {
		Usuario usu = new Usuario();
		usu.setId(1);
  		usu.setNome("Sasuke Uchira");
  		usu.setLogin("Sasuke");
  		usu.setSenha("matarUmsertoAlguem");
  		
  		UsuarioDAO usuDAO = new UsuarioDAO();
  		usuDAO.atualizar(usu);
  		
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
      
      
      
      
      public static void testSalvar() {
    	  Usuario usuario = new Usuario();
    	  //usuario.setId(3);
    	  usuario.setNome("Nicole whaterson");
    	  usuario.setLogin("Nicole");
    	  usuario.setSenha("232criptwww");
    	  
    	  UsuarioDAO usuDAO = new UsuarioDAO();
    	  usuDAO.salvar(usuario);
    	  
    	  System.out.println("Salvo com sucesso !");
      }
      
      
      
      
      
      
      
      
      
      
      
	
}
