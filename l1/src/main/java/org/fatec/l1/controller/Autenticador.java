package org.fatec.l1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Autenticador {
	
	@GetMapping("/login")
	public String autenticar() {
		return "login";
	}
}
