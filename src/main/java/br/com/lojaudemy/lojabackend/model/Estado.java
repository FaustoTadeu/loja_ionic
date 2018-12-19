package br.com.lojaudemy.lojabackend.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Estado")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;

    private String nomeEstado;

    private String siglaEstado;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(Integer idEstado, String nomeEstado, String siglaEstado) {
        super();
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

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(idEstado, estado.idEstado) &&
                Objects.equals(nomeEstado, estado.nomeEstado) &&
                Objects.equals(siglaEstado, estado.siglaEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, nomeEstado, siglaEstado);
    }
}
