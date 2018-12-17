package br.com.lojaudemy.lojabackend.model;

import java.util.Date;

import br.com.lojaudeny.lojabackend.enums.EstadoPagamento;

public class PagamentoBoleto extends Pagamento {
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoBoleto() {
		super();
	}

	public PagamentoBoleto(Integer idPagamento, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagemento) {
		super(idPagamento, estadoPagamento, pedido);
		this.dataPagamento = dataPagemento;
		this.dataVencimento = dataVencimento;
	}
	
	
	

	
}
