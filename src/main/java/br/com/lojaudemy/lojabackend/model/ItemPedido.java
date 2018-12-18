package br.com.lojaudemy.lojabackend.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;


@Entity(name = "itemPedido")
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double descontoItemPedido;

    private Integer quantItemPedido;

    private Double precoItemPedido;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double descontoItemPedido, Integer quantItemPedido, Double precoItemPedido) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.descontoItemPedido = descontoItemPedido;
        this.quantItemPedido = quantItemPedido;
        this.precoItemPedido = precoItemPedido;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDescontoItemPedido() {
        return descontoItemPedido;
    }

    public void setDescontoItemPedido(Double descontoItemPedido) {
        this.descontoItemPedido = descontoItemPedido;
    }

    public Integer getQuantItemPedido() {
        return quantItemPedido;
    }

    public void setQuantItemPedido(Integer quantItemPedido) {
        this.quantItemPedido = quantItemPedido;
    }

    public Double getPrecoItemPedido() {
        return precoItemPedido;
    }

    public void setPrecoItemPedido(Double precoItemPedido) {
        this.precoItemPedido = precoItemPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
