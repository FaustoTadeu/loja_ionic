package br.com.lojaudemy.lojabackend.repository;

import br.com.lojaudemy.lojabackend.model.ImagemProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemProdRepository extends JpaRepository<ImagemProd, Integer> {

}
