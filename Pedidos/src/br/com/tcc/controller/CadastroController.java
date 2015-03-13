package br.com.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tcc.dao.UsuarioDAO;
import br.com.tcc.model.Usuario;

@Controller
public class CadastroController {
	
	private final UsuarioDAO dao;
	
	@Autowired
	public CadastroController(UsuarioDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping("/adicionaUsuario")
	public String adiciona(Usuario usuario){
		dao.adiciona(usuario);
		return "login";
	}
}
