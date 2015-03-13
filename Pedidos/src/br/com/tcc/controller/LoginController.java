package br.com.tcc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tcc.dao.UsuarioDAO;
import br.com.tcc.model.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario,HttpSession session){
		if(new UsuarioDAO().autenticaUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "home";
		}
		return "redirect:loginForm";
	}
}
