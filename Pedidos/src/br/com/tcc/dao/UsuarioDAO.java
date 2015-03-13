package br.com.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.tcc.model.Usuario;

@Repository
public class UsuarioDAO {
	
	private EntityManagerFactory factory;
	
	public UsuarioDAO(){
		this.factory = Persistence.createEntityManagerFactory("usuario");
	}
	
	public void adiciona(Usuario usuario){
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		System.out.println("ID do usuario" + usuario.getId());
		
		manager.close();
	}
	
	public void altera(Usuario usuario){
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		
		manager.close();
		
	}

	public Usuario consultaPorLogin(String nome){
		
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Usuario> query = manager.createQuery(
		        "SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
		    return query.setParameter("login", nome).getSingleResult();
		
	}
	
	public boolean autenticaUsuario(Usuario usuario) {
		if(consultaPorLogin(usuario.getLogin()).getSenha().equals(usuario.getSenha())){
			return true;
		}
		return false;
	}
	
	public List<Usuario> lista(){
		
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("SELECT u FROM Usuario u");
		List<Usuario> usuarios = query.getResultList();
		
		return usuarios;
	}
	
}
