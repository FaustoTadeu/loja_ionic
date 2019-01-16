package br.com.lojaudemy.lojabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lojaudemy.lojabackend.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	
//	@Query("SELECT u FROM usuario u where u.emailUsuario = :emailUsuario AND u.senhaUsuario = :senhaUsuario")
//    public Optional<Cliente> findByEmailSenha(String emailUsuario, String senhaUsuario);
	
	@Transactional(readOnly = true)
	Cliente findByEmailCliente (String emailCliente);

}
