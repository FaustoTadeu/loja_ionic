package br.com.lojaudemy.lojabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lojaudemy.lojabackend.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
