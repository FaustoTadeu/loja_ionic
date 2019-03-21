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
    private String imagemCategoria;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria cat)  {
        idCategoria = cat.getIdCategoria();
        nomeCategoria = cat.getNomeCategoria();
        imagemCategoria = new String(cat.getImagemCategoria());
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

    public String getImagemCategoria() { return imagemCategoria; }

    public void setImagemCategoria(String imagemCategoria) { this.imagemCategoria = imagemCategoria; }
}
