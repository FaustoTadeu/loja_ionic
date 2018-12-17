package br.com.lojaudemy.lojabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository usuarioRepository;

    public Cliente buscarporId(Integer id) {
        Optional<Cliente> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()
        ));
    }
    
    public List<Cliente> buscarTodosClientes() {
    	List<Cliente> obj = null;
    	try {
    	   obj =  usuarioRepository.findAll();	
        }catch (Exception e) {
			new ObjectNotFoundException("Objetos do tipo " + Cliente.class.getName() + " não encontrados");
		}
        return obj;
    }
    
//    public Cliente buscarporEmailSenha(String emailUsuario, String senhaUsuario) {
//        Optional<Cliente> obj = usuarioRepository.findByEmailSenha(emailUsuario, senhaUsuario);
//        return obj.orElseThrow(() -> new ObjectNotFoundException(
//                "Objeto não encontrado! email: " + emailUsuario + ", Tipo: " + Cliente.class.getName()
//        ));
//    }
//    
}
