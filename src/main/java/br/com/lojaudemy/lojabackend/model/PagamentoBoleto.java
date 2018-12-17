package br.com.lojaudemy.lojabackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import br.com.lojaudeny.lojabackend.enums.EstadoPagamento;

@Entity(name = "pagamento_boleto")
public class PagamentoBoleto extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
		
}
