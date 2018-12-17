package br.com.lojaudemy.lojabackend.model;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private Integer idPedido;
	
	private Date dataPedido;
	
	private Pagamento pagamento;
	
	private Cliente cliente;
	
	private Endereco enderecoEntrega;

	public Pedido() {
		super();
	}

	public Pedido(Integer idPedido, Date dataPedido, Pagamento pagamento, Cliente cliente, Endereco enderecoEntrega) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}
	
	

}
