package br.com.lojaudemy.lojabackend.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;

import br.com.lojaudemy.lojabackend.enums.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.lojaudemy.lojabackend.enums.TipoCliente;

@Entity(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;

	@Lob
	private byte[] fotoCliente;

	private String nomeCliente;
	
	@Column(unique=true)
	private String emailCliente;
	
	private String cpfCnpjCliente;
	
	private Integer tipoCliente;

	@JsonIgnore
	private String senhaCliente;

	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Endereco> endereco = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="PERFIL")
	private Set<Integer> perfis = new HashSet<>();

	@JsonIgnore
	@OneToMany( mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {
		setPerfil(PerfilUsuario.CLIENTE);
	}

	public Cliente(Integer idCliente, byte[] fotoCliente, String nomeCliente, String emailCliente, String cpfCnpjCliente,
			TipoCliente tipoCliente, String senhaCliente) {
		super();
		this.idCliente = idCliente;
		this.fotoCliente = fotoCliente;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.cpfCnpjCliente = cpfCnpjCliente;
		this.tipoCliente = (tipoCliente != null) ? tipoCliente.getCod() : null;
		this.senhaCliente = senhaCliente;
		setPerfil(PerfilUsuario.CLIENTE);
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public byte[] getFotoCliente() { return fotoCliente; }

	public void setFotoCliente(byte[] fotoCliente) { this.fotoCliente = fotoCliente; }

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailUsuarioCliente) {
		this.emailCliente = emailUsuarioCliente;
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}

	public String getSenhaCliente() { return senhaCliente; }

	public void setSenhaCliente(String senhaCliente) { this.senhaCliente = senhaCliente; }

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Set<PerfilUsuario> getPerfis () { return perfis.stream().map(x -> PerfilUsuario.toEnum(x)).collect(Collectors.toSet()); }

	public void setPerfil(PerfilUsuario perfil) { perfis.add(perfil.getCod()); }

	public List<Pedido> getPedidos() { return pedidos; }

	public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}

	
}
