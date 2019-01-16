package br.com.lojaudemy.lojabackend.dto;

import br.com.lojaudemy.lojabackend.model.Estado;

import java.io.Serializable;

public class EstadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEstado;

    private String nomeEstado;

    private String siglaEstado;

    public EstadoDTO () {

    }

    public EstadoDTO (Estado estado) {
        this.idEstado = estado.getIdEstado();
        this.nomeEstado = estado.getNomeEstado();
        this.siglaEstado = estado.getSiglaEstado();

    }

    public EstadoDTO(Integer idEstado, String nomeEstado, String siglaEstado) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.siglaEstado = siglaEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }
}
