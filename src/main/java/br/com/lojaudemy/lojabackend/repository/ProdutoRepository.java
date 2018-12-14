package br.com.lojaudemy.lojabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lojaudemy.lojabackend.model.Produto;
		
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
