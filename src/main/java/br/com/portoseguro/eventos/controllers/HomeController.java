package br.com.portoseguro.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String iniciar() {
		return "index";
	}
	
	@GetMapping("/empresa")
	public String mostrarEmpresa(Model model) {
		String empresa = "Porto Seguro";
		model.addAttribute("nome_empresa", empresa);
		return "empresa";
	}
}
