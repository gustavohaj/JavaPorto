package br.com.portoseguro.eventos.advisors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(NullPointerException.class)
	public String handleConvidadoException(NullPointerException e, Model model) {
		model.addAttribute("msg_erro", "ERRO:  "+ e.toString());
		return "error";
		
	}

}
