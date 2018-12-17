package br.com.lojaudemy.lojabackend.model;

import java.io.Serializable;

import br.com.lojaudeny.lojabackend.enums.EstadoPagamento;

public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Integer idPagamento;
	
	private EstadoPagamento estadoPagamento;
	
	private Pedido pedido;

	public Pagamento() {
		super();
	}

	public Pagamento(Integer idPagamento, EstadoPagamento estadoPagamento, Pedido pedido) {
		super();
		this.idPagamento = idPagamento;
		this.estadoPagamento = estadoPagamento;
		this.pedido = pedido;
	}
	
	

}
