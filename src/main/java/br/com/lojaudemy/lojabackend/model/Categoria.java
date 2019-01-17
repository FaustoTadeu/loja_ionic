package br.com.lojaudemy.lojabackend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    private String nomeCategoria;

    @Lob
    private byte[] imagemCategoria;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nomeCategoria, byte[] imagemCategoria) {
        super();
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.imagemCategoria = imagemCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<Produto> getProdutos() { return produtos; }

    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }

    public byte[] getImagemCategoria() { return imagemCategoria; }

    public void setImagemCategoria(byte[] imagemCategoria) { this.imagemCategoria = imagemCategoria; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(idCategoria, categoria.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria);
    }
}
