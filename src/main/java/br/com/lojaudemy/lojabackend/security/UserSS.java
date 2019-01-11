package br.com.lojaudemy.lojabackend.security;

import br.com.lojaudemy.lojabackend.enums.PerfilUsuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSS implements UserDetails {

    private Integer idUser;
    private String emailUser;
    private String senhauser;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Integer idUser, String emailUser, String senhauser, Set<PerfilUsuario> perfis) {
        this.idUser = idUser;
        this.emailUser = emailUser;
        this.senhauser = senhauser;
        this.authorities = perfis.stream().map(x-> new SimpleGrantedAuthority(x.getNome())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getId() {
        return idUser;
    }

    @Override
    public String getPassword() {
        return emailUser;
    }

    @Override
    public String getUsername() {
        return  senhauser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
