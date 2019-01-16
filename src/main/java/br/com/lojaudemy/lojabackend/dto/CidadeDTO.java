package br.com.lojaudemy.lojabackend.dto;

import br.com.lojaudemy.lojabackend.model.Cidade;

import java.io.Serializable;


public class CidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCidade;

    private String nomeCidade;

    public CidadeDTO () {
    }

    public CidadeDTO (Cidade cidade) {
        this.idCidade = cidade.getIdCidade();
        this.nomeCidade = cidade.getNomeCidade();
    }

    public CidadeDTO(Integer idCidade, String nomeCidade) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}
