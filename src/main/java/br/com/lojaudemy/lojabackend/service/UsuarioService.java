package br.com.lojaudemy.lojabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lojaudemy.lojabackend.model.Usuario;
import br.com.lojaudemy.lojabackend.repository.UsuarioRepository;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarporId(Integer id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", Tipo: " + Usuario.class.getName()
        ));
    }
    
    public List<Usuario> buscarTodasCategorias() {
    	List<Usuario> obj = null;
    	try {
    	   obj =  usuarioRepository.findAll();
        }catch (Exception e) {
			new ObjectNotFoundException("Objetos do tipo " + Usuario.class.getName() + " não encontrados");
		}
        return obj;
    }
    
}
