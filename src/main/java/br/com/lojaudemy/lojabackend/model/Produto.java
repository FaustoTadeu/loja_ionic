package br.com.lojaudemy.lojabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "Produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    private String nomeProduto;

    private Double preco;

    @JsonIgnore
    @ManyToMany
    @JoinTable( name = "PRODUTO_CATEGORIA",
                joinColumns = @JoinColumn(name = "produto_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<ImagemProd> imagens = new ArrayList<>();

    public Produto() {
    }

    public Produto(Integer idProduto, String nomeProduto, Double preco) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

    @JsonIgnore
    public List<Pedido> getPedidos () {
        List<Pedido> listaPedido = new ArrayList<>();
        for(ItemPedido x : itens) {
            listaPedido.add(x.getPedido());
        }
        return listaPedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<ImagemProd> getImagens() { return imagens; }

    public void setImagens(List<ImagemProd> imagens) { this.imagens = imagens; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(idProduto, produto.idProduto) &&
                Objects.equals(nomeProduto, produto.nomeProduto) &&
                Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, nomeProduto, preco);
    }
}
