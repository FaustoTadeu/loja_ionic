package br.com.lojaudemy.lojabackend.repository;

import br.com.lojaudemy.lojabackend.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {


}
