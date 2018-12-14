package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.repository.CategoriaRepository;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarporId(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()
        ));
    }
    
    public List<Categoria> buscarTodasCategorias() {
    	List<Categoria> obj = null;
    	try {
    	   obj =  categoriaRepository.findAll();
        }catch (Exception e) {
			new ObjectNotFoundException("Objetos do tipo " + Categoria.class.getName() + " não encontrados");
		}
        return obj;
    }
    
}
