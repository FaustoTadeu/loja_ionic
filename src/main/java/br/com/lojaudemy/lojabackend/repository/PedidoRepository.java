package br.com.lojaudemy.lojabackend.repository;

import br.com.lojaudemy.lojabackend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


}
