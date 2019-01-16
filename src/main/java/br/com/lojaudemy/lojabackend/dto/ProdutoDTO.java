package br.com.lojaudemy.lojabackend.dto;

import br.com.lojaudemy.lojabackend.model.Produto;

import java.io.Serializable;
import java.util.Date;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProduto;
    private String nomeProduto;
    private Double preco;


    public ProdutoDTO() {}

    public ProdutoDTO(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.preco = produto.getPreco();
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

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }
}
