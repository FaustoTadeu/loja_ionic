package br.com.lojaudemy.lojabackend.dto;

import br.com.lojaudemy.lojabackend.model.Categoria;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Blob;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCategoria;


    @NotNull(message = "Não pode ser nulo!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(min=3, message="O tamanho deve ser pelo menos 3 caracteres!")
    private String nomeCategoria;

    @Lob
    private byte[] imagemCategoria;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria cat)  {
        idCategoria = cat.getIdCategoria();
        nomeCategoria = cat.getNomeCategoria();
        imagemCategoria = cat.getImagemCategoria();
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

    public byte[] getImagemCategoria() { return imagemCategoria; }

    public void setImagemCategoria(byte[] imagemCategoria) { this.imagemCategoria = imagemCategoria; }
}
