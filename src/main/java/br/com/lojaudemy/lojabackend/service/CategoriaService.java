package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.dto.CategoriaDTO;
import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.repository.CategoriaRepository;
import br.com.lojaudemy.lojabackend.service.exception.DataIntegrityViolationException;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaPorId(Integer idCat) {
        Optional<Categoria> obj = categoriaRepository.findById(idCat);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + idCat + ", Tipo: " + Categoria.class.getName()
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

    public Categoria inserirEditarCategoria(Categoria cat) {
       if (cat.getIdCategoria() != null) {
          buscarCategoriaPorId(cat.getIdCategoria());
       }
       return categoriaRepository.save(cat);
    }

    public void apagarCategoria(Integer idCat) {
       Categoria cat =  buscarCategoriaPorId(idCat);
        try{
            categoriaRepository.delete(cat);
        } catch (Exception e) {
            throw new DataIntegrityViolationException("Não é possivel excluir categorias que possuem produtos cadastrados");
        }
    }

    @SuppressWarnings("deprecation")
	public Page<Categoria> buscarTodasCategoriasPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria fromDTO (CategoriaDTO catDto, Integer idCategoria) {
        return new Categoria(idCategoria == null ? null : idCategoria, catDto.getNomeCategoria(), catDto.getImagemCategoria() == null ? null : catDto.getImagemCategoria().getBytes());
    }
    
}
