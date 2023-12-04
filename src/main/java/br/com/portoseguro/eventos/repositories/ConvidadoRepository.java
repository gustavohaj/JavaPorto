package br.com.portoseguro.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portoseguro.eventos.models.Convidado;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Integer>{

}
