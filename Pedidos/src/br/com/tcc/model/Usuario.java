package br.com.tcc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = -7851096374831269286L;

	@GeneratedValue
	@Id
	private int id;
	
	
	@NotNull(message="login não pode ser nulo!")
	@Column(unique=true)
	private String login;
	
	@Size(max=8)
	@NotNull(message="Campo senha não pode ser vazio!")
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}
