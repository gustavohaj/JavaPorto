package br.com.portoseguro.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.portoseguro.eventos.models.Usuario;



public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	
	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	public Usuario getUserByUsername(@Param("username") String username);
	

}
