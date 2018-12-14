package br.com.lojaudemy.lojabackend.repository;

import br.com.lojaudemy.lojabackend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


}
