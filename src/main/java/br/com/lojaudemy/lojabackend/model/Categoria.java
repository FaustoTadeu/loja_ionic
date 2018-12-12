package br.com.lojaudemy.lojabackend.model;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {


    private Integer idCategoria;
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nomeCategoria) {
        super();
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(idCategoria, categoria.idCategoria) &&
                Objects.equals(nomeCategoria, categoria.nomeCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nomeCategoria);
    }
}
