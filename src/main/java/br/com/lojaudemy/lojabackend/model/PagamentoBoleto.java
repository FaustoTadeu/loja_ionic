package br.com.lojaudemy.lojabackend.model;

import java.util.Date;
import javax.persistence.Entity;
import br.com.lojaudemy.lojabackend.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "pagamento_boleto")
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataVencimento;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
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
