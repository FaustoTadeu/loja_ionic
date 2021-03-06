package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    private Random rand = new Random();

    public String setNewPassword(String email) {
        Cliente cliente = clienteRepository.findByEmailCliente(email);
        if(cliente == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPassword = newPassword();
        cliente.setSenhaCliente(pe.encode(newPassword));
        clienteRepository.save(cliente);

        return newPassword;
    }

    private String newPassword() {
        char[] pass = new char[10];
        for(int i = 0; i < pass.length; i++) {
            pass[i] = randonChar();
        }
        return new String(pass);
    }

    private char randonChar() {
        int opt = rand.nextInt(3);
        if(opt == 0) {
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1){
            return (char) (rand.nextInt(26) + 65);
        } else {
            return (char) (rand.nextInt(26) + 97);
        }
    }
}
