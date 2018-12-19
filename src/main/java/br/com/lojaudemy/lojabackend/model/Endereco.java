package br.com.lojaudemy.lojabackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;
	
	private String logradouroEndereco;
	
	private String numeroEndereco;
	
	private String bairroEndereco;
	
	private String complementoEndereco;
	
	private String cepEndereco;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;

	public Endereco() {
		super();
	}

	public Endereco(Integer idEndereco, String logradouroEndereco, String numeroEndereco, String bairroEndereco,
			String complementoEndereco, String cepEndereco, Cliente cliente, Cidade cidade) {
		super();
		this.idEndereco = idEndereco;
		this.logradouroEndereco = logradouroEndereco;
		this.numeroEndereco = numeroEndereco;
		this.bairroEndereco = bairroEndereco;
		this.complementoEndereco = complementoEndereco;
		this.cepEndereco = cepEndereco;
		this.cliente = cliente;	
		this.setCidade(cidade);
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouroEndereco() {
		return logradouroEndereco;
	}

	public void setLogradouroEndereco(String logradouroEndereco) {
		this.logradouroEndereco = logradouroEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
	
}