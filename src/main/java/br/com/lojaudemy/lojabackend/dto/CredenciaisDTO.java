package br.com.lojaudemy.lojabackend.dto;

import java.io.Serializable;

public class CredenciaisDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String emailCliente;
    private String senhaCliente;

    public CredenciaisDTO() {

    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }
}

