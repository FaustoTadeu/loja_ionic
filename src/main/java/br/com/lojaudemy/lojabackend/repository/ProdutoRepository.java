package br.com.lojaudemy.lojabackend.repository;

import java.util.List;

import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Transactional(readOnly=true)
    @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE lower(obj.nomeProduto) LIKE lower(concat('%', :nome, '%')) AND cat IN :categorias")
    Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
}