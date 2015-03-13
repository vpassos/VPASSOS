package br.com.tcc.test;

import java.util.List;

import org.junit.Test;

import br.com.tcc.dao.UsuarioDAO;
import br.com.tcc.model.Usuario;

public class TestUsuarioDAO {

	//@Test
	public void usuarioDAO_consultaPorLogin() {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultaPorLogin("vinicius");
		
		System.out.println(usuario.getSenha());
		
	}
	
//	@Test
	public void autenticaUsuario(){
		Usuario usuario = new Usuario();
		
		usuario.setLogin("vinicius");
		usuario.setSenha("1234");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		boolean autentica = dao.autenticaUsuario(usuario);
		System.out.println(autentica);
	}
	
//	@Test
	public void alteraUsuario(){
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin("vinicius");
		usuario.setSenha("123456");
		usuario.setId(1);
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.altera(usuario);
		
	}
	
	@Test
	public void listaUsuario(){
		
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.lista();
		
		for(Usuario usuario : usuarios){
			System.out.println(usuario.getId());
		}
	}

}
