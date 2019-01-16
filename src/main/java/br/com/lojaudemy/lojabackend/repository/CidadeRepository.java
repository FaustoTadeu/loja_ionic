package br.com.lojaudemy.lojabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lojaudemy.lojabackend.model.Cidade;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Cidade c WHERE c.estado.idEstado = :estadoId ORDER BY c.nomeCidade")
    public List<Cidade> findByEstado(@Param("estadoId") Integer estadoId);

}
