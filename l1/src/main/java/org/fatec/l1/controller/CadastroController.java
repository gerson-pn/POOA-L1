package org.fatec.l1.controller;

import org.fatec.l1.domain.Cliente;
import org.fatec.l1.domain.Telefone;
import org.fatec.l1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {
	@Autowired
	private ClienteRepository cr;

	@GetMapping("/cadastrar-clientes")
	public String cadastrarClientes() {
		return "cadastro";
	}

	@PostMapping("/cadastrar-clientes")
	public String cadastrarClientes(Cliente c, Telefone t) {
		c.getTelefones().add(t);
		cr.save(c);
		return "cadastro";
	}
}
