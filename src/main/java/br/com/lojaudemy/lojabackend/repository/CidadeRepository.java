package br.com.lojaudemy.lojabackend.repository;

import br.com.lojaudemy.lojabackend.model.Cidade;
import br.com.lojaudemy.lojabackend.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
