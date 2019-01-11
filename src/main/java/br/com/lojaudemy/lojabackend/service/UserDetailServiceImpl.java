package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmailCliente(email);
        if(cliente == null) {
            throw new UsernameNotFoundException(email + " não encontrado");
        }
        return new UserSS(cliente.getIdCliente(), cliente.getEmailCliente(), cliente.getSenhaCliente(), cliente.getPerfis());
    }
}
