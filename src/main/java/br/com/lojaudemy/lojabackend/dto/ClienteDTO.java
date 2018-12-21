package br.com.lojaudemy.lojabackend.dto;

import br.com.lojaudemy.lojabackend.model.Cliente;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClienteDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;

    @NotEmpty (message = "Preenchimento obrigatório")
    @Size (min=3, message = "O nome do cliente deve ter mais que 3 caracteres")
    private String nomeCliente;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email (message = "Email inválido")
    private String emailCliente;

    public ClienteDTO () {}

    public ClienteDTO (Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCliente = cliente.getNomeCliente();
        this.emailCliente = cliente.getEmailCliente();
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
