package org.fatec.l1.controller;

import javax.servlet.http.HttpSession;

import org.fatec.l1.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String paginaInicial(HttpSession sessao) {
		// entenda a sessao, como um mapa, ou dicionario
		Usuario u = (Usuario) sessao.getAttribute("usuario");
		if(u == null) {
			return "redirect:login";
		}else {
			return "index";	
		}
		
	}
	
	@GetMapping("/login")
	public String autenticacao() {
		return "login";
	}
	
	@PostMapping("/login")
	public String autenticar(HttpSession sessao, Usuario u) {
		// ir no banco, verificar...
		sessao.setAttribute("usuario", u);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String sair(HttpSession sessao) {
		sessao.invalidate();
		return "login";
	}
	
}
