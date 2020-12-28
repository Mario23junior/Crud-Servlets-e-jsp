package br.com.project.entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.project.ConnectionData.ConnectionFactory;

public class UsuarioDAO {

	private Connection conn = ConnectionFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		String sql = "insert usuario(nome, login ,senha) values(?,?,?)";
		
	try(PreparedStatement preparador = conn.prepareStatement(sql)){
	    preparador.setString(1,usu.getNome());
	    preparador.setString(2, usu.getLogin());
	    preparador.setString(3, usu.getSenha());
	    
	    preparador.execute();
		    
		} catch (SQLException e) {
 			e.printStackTrace();
		}
	}
	
	
	public void update(Usuario usu) {
			
	  String sql = "update usuario set nome=?, login=? , senha=? where id=?";
			
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

}
