package br.com.lojaudemy.lojabackend.dto;

import java.io.Serializable;

public class CredenciaisDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeUsuario;
    private String senhaUsuario;

    public CredenciaisDTO() {

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}

