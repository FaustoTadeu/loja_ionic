package br.com.lojaudemy.lojabackend.dto;

import br.com.lojaudemy.lojabackend.model.Cliente;

import java.io.Serializable;

public class ClienteDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;
    private String nomeCliente;
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
