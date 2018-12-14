package br.com.lojaudemy.lojabackend.repository;

import br.com.lojaudemy.lojabackend.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
