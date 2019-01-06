package br.com.lojaudemy.lojabackend.model;

import javax.persistence.Entity;
import br.com.lojaudemy.lojabackend.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;


@Entity(name = "pagamento_cartao")
@JsonTypeName("pagamentoCartao")
public class PagamentoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numParcelas;

	public PagamentoCartao() {
		super();
	}

	public PagamentoCartao(Integer idPagamento, EstadoPagamento estadoPagamento, Pedido pedido, Integer numParcelas) {
		super(idPagamento, estadoPagamento, pedido);
		this.numParcelas = numParcelas;
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}

}
