package br.com.portoseguro.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.portoseguro.eventos.models.Convidado;
import br.com.portoseguro.eventos.services.ConvidadoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;
	
	
	@GetMapping("/lista")
	public ModelAndView listar() {
		List<Convidado> convidados = convidadoService.listarConvidados();
		return new ModelAndView("convidados/listaConvidados", "lista_convidados", convidados);
	}
	
	
	@GetMapping("/novo")
	public String incluir(Convidado convidado) {
		return "convidados/novoConvidado";
	}
	
	@PostMapping("/novo")
	public String incluir(@Valid Convidado convidado,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "convidados/novoConvidado";
		}
		convidadoService.salvarConvidado(convidado);
		return "redirect:/convidados/lista";
	}
	
	@GetMapping("/alteracao/{id}")
	public ModelAndView alterar(@PathVariable int id) {	
		
			Convidado convidado = convidadoService.buscar(id);
			return new ModelAndView("convidados/alterarConvidado", "convidado", convidado);
	}
	
	
	@PostMapping("/alteracao")
	public String alterar(@Valid Convidado convidado, BindingResult result) {
		if(result.hasErrors()) {
			return "convidados/alterarConvidado";
		}
		convidadoService.salvarConvidado(convidado);
		return "redirect:/convidados/lista";
	}
	
	@GetMapping("/remocao/{id}")
	public ModelAndView remover(@PathVariable int id) {
		Convidado convidado = convidadoService.buscar(id);
		return new ModelAndView("convidados/removerConvidado", "convidado", convidado);
		
	}
	
	@PostMapping("remocao")
	public String remover(Convidado convidado){
		convidadoService.remover(convidado.getId());
		return "redirect:/convidados/lista";
	}
	
}
