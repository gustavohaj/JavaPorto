package br.com.portoseguro.eventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.portoseguro.eventos.models.Convidado;
import br.com.portoseguro.eventos.repositories.ConvidadoRepository;


@Service
public class ConvidadoService {
	
	/*
	 * Podemos ter dois tipos de injeção de dependêcia
	 * 
	 * 1. por atributo:
	 * 		nesse caso, colocamos a anotação Autowired sobre o atributo da classe
	 * 
	 * 2. Por parametro do construtor
	 * 		nesse caso, o framework se encarrega de fornecer a instancia adequada para a classe
	 * 		atraves do construtor. Aqui não usamos anotação Autowired.
	 */
	
	//@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public ConvidadoService(ConvidadoRepository convidadoRepository) {
		this.convidadoRepository =  convidadoRepository;
	}
	
	public List<Convidado> listarConvidados(){
		return convidadoRepository.findAll();
	}
	
	public Convidado salvarConvidado(Convidado convidado) {
		return convidadoRepository.save(convidado);
	}
	
	public Convidado buscarConvidado(int id) {
		return convidadoRepository.getReferenceById(id);
	}

	public Convidado buscar(int id) {
		return convidadoRepository.findById(id)
				.orElseThrow(() -> new NullPointerException("Não encontramos registros com esse ID."));
//		if(convidado.isPresent()) {
//			return convidado.get();
//		}
//		return null;
	}
	
	
	public void remover(int id) {
		convidadoRepository.deleteById(id);
		
	}
	

}
