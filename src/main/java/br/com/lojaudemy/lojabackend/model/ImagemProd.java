package br.com.lojaudemy.lojabackend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;


@Entity(name = "ImagemProd")
public class ImagemProd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagemProd;

    private Blob imagemBinary;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ImagemProd() {
    }

    public ImagemProd(Integer idImagemProd, Blob imagemBinary, Produto produto) {
        this.idImagemProd = idImagemProd;
        this.imagemBinary = imagemBinary;
        this.produto = produto;
    }

    public Integer getIdImagemProd() {
        return idImagemProd;
    }

    public void setIdImagemProd(Integer idImagemProd) {
        this.idImagemProd = idImagemProd;
    }

    public Blob getImagemBinary() {
        return imagemBinary;
    }

    public void setImagemBinary(Blob imagemBinary) {
        this.imagemBinary = imagemBinary;
    }

    public Produto getProdutos() { return produto; }

    public void setProdutos(Produto produto) { this.produto = produto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagemProd imgProd = (ImagemProd) o;
        return Objects.equals(idImagemProd, imgProd.idImagemProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImagemProd);
    }
}
