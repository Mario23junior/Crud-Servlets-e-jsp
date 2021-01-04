package br.com.project.entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.project.ConnectionData.ConnectionFactory;

public class UsuarioDAO {

	private Connection conn = ConnectionFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		String sql = "insert into usuario(nome, login ,senha) values(?,?,md5(?))";
		
	try(PreparedStatement preparador = conn.prepareStatement(sql)){
	    preparador.setString(1,usu.getNome());
	    preparador.setString(2, usu.getLogin());
	    preparador.setString(3, usu.getSenha());
	    
	    preparador.execute();
		    
		} catch (SQLException e) {
 			e.printStackTrace();
		}
	}
	
	
	public void atualizar(Usuario usu) {
			
	  String sql = "update usuario set nome=?, login=? , senha=md5(?) where id=?";
			
		try(PreparedStatement preparador = conn.prepareStatement(sql)){
			
			preparador.setInt(4, usu.getId());
		    preparador.setString(1,usu.getNome());
		    preparador.setString(2, usu.getLogin());
		    preparador.setString(3, usu.getSenha());
		    
		    preparador.execute();
			    
			} catch (SQLException e) {
	 			e.printStackTrace();
			}
		}
	
	
	public void excluir(Usuario usu) {
		  String sql = "delete from usuario where id=?";
			try(PreparedStatement preparador = conn.prepareStatement(sql)){
				
				preparador.setInt(1, usu.getId());
				 preparador.execute();    
				
				} catch (SQLException e) {
		 			e.printStackTrace();
				}
			}
	
      
	  public void salvar(Usuario usuario) {
		  if(usuario.getId() != null && usuario.getId() != 0) {
			  atualizar(usuario);
		  }else {
			  cadastrar(usuario);
		  }
	  }
	
	
	 /*Busca de dados no banco de por ID
	  *retorna um objeto usuario quando encontra os dados 
	  *ou null quando não encontra os dados */
	  
	  public Usuario buscarPorId(Integer id) {
		  String sql = "Select * from usuario where id =?;";
		 			  
		 try(PreparedStatement preparador = conn.prepareStatement(sql)){
			 preparador.setInt(1, id);
			 
			ResultSet result = preparador.executeQuery();
			
			 if(result.next()) {
				 Usuario usuario = new Usuario();
				 usuario.setId(result.getInt("id"));
				 usuario.setNome(result.getString("nome"));
				 usuario.setLogin(result.getString("login"));
				 usuario.setSenha(result.getString("senha"));
				 
				 return usuario;
			 }
			 
			} catch (SQLException e) {
				e.printStackTrace();
	 
 			}
		 
		    return null;
				  
	  	}
	  
	  /*buscar de todos os registros da tabela de usuarios 
	   * uma lists de objetos Usuarios contendo 0 elementos quando tiver registro
	   * ou n elementos quando tive null
	  */
	  public List<Usuario> buscarTodos() {
		  String sql = "Select * from usuario";
		 			  
		  List<Usuario> lista = new ArrayList<Usuario>();
		 try(PreparedStatement preparador = conn.prepareStatement(sql)){
 			 
			ResultSet result = preparador.executeQuery();
			
			 while(result.next()) {
				 Usuario usuario = new Usuario();
				 usuario.setId(result.getInt("id"));
				 usuario.setNome(result.getString("nome"));
				 usuario.setLogin(result.getString("login"));
				 usuario.setSenha(result.getString("senha"));
				 
				 //Adicionando usuario na lista
				 lista.add(usuario);
			 }
			 
			} catch (SQLException e) {
				e.printStackTrace();
	 
 			}
		 
		    return lista;
				  
	  } 
	  
	  public Usuario Autenticar(Usuario usuConsulta) {
		  String sql = "Select * from usuario where login=? and senha=md5(?)";
		  
		  try(PreparedStatement preparador = conn.prepareStatement(sql)){
			  preparador.setString(1, usuConsulta.getLogin());
			  preparador.setString(2, usuConsulta.getSenha());
			  
			 ResultSet resultado = preparador.executeQuery();
			 
			 if(resultado.next()) {
			 Usuario usuario = new Usuario();
			 usuario.setId(resultado.getInt("id"));
			 usuario.setNome(resultado.getString("nome"));
			 usuario.setLogin(resultado.getString("login"));
			 usuario.setSenha(resultado.getString("senha"));
			 
			 return usuario;
			 
			 }
			 
		  } catch (SQLException e) {
			e.printStackTrace();
		}
		  return null;
	  }
   }
