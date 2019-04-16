package br.com.lojaudemy.lojabackend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.lojaudemy.lojabackend.service.validation.ClienteInsert;

import java.sql.Blob;


@ClienteInsert
public class ClienteNewDTO {

    private static final long serialVersionUID = 1L;
    
    @NotEmpty (message = "Preenchimento obrigatório")
    @Size (min=5, max=120,  message = "O nome do cliente deve ter entre 5 e 120 caracteres")
    private String nomeCliente;

    private String fotoCliente;
	
    @NotEmpty(message = "Preenchimento obrigatório")	
    @Email (message = "Email inválido")
	private String emailCliente;
	
    @NotEmpty(message = "Preenchimento obrigatório")	
	private String cpfCnpjCliente;
	
	private Integer tipoCliente;
	
	@NotEmpty(message = "Preenchimento obrigatório")
    private String logradouroEndereco;
	
	 @NotEmpty(message = "Preenchimento obrigatório")	
	private String numeroEndereco;
	
	private String bairroEndereco;
	
	private String complementoEndereco;
	
	 @NotEmpty(message = "Preenchimento obrigatório")	
	private String cepEndereco;
	
	 @NotEmpty(message = "Preenchimento obrigatório")	
	private String telefoneUm;
	
	private String telefoneDois;
	
	private String telefoneTres;
	
	private Integer cidadeId;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String senhaCliente;
	
	public ClienteNewDTO () {
		
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getFotoCliente() { return fotoCliente; }

	public void setFotoCliente(String fotoCliente) { this.fotoCliente = fotoCliente; }

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
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

	public String getTelefoneUm() {
		return telefoneUm;
	}

	public void setTelefoneUm(String telefoneUm) {
		this.telefoneUm = telefoneUm;
	}

	public String getTelefoneDois() {
		return telefoneDois;
	}

	public void setTelefoneDois(String telefoneDois) {
		this.telefoneDois = telefoneDois;
	}

	public String getTelefoneTres() {
		return telefoneTres;
	}

	public void setTelefoneTres(String telefoneTres) {
		this.telefoneTres = telefoneTres;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getSenhaCliente() { return senhaCliente; }

	public void setSenhaCliente(String senhaCliente) { this.senhaCliente = senhaCliente; }
}
