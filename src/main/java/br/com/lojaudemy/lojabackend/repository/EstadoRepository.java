package br.com.lojaudemy.lojabackend.repository;

import br.com.lojaudemy.lojabackend.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
