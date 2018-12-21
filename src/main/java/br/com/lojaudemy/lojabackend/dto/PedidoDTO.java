package br.com.lojaudemy.lojabackend.dto;

import br.com.lojaudemy.lojabackend.model.Pedido;
import java.io.Serializable;
import java.util.Date;

public class PedidoDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idPedido;
    private Date dataPedido;

    public PedidoDTO () {}

    public PedidoDTO (Pedido pedido) {
        this.idPedido = pedido.getIdPedido();
        this.dataPedido = pedido.getDataPedido();
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
}
