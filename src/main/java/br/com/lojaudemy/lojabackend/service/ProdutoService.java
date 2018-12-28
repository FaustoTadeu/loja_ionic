package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.dto.ProdutoDTO;
import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.model.Produto;
import br.com.lojaudemy.lojabackend.repository.CategoriaRepository;
import br.com.lojaudemy.lojabackend.repository.ProdutoRepository;
import br.com.lojaudemy.lojabackend.service.exception.ConstraintViolationException;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto buscarProdutoPorId(Integer idProd) {
        Optional<Produto> obj = produtoRepository.findById(idProd);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + idProd + ", Tipo: " + Produto.class.getName()
        ));
    }

    public List<Produto> buscarTodosProdutos() {
        List<Produto> obj = null;
        try {
            obj =  produtoRepository.findAll();
        }catch (Exception e) {
            throw new ObjectNotFoundException("Objetos do tipo " + Produto.class.getName() + " não encontrados");
        }
        return obj;
    }

    public Produto inserirEditarProduto(Produto prod) {
        if (prod.getIdProduto() != null) {
            buscarProdutoPorId(prod.getIdProduto());
        }
        return produtoRepository.save(prod);
    }

    public void apagarProduto(Integer idProd) {
        Produto prod =  buscarProdutoPorId(idProd);
        try{
            produtoRepository.delete(prod);
        } catch (Exception e) {
            throw new ConstraintViolationException("Não é possivel excluir Produtos que possuem produtos cadastrados");
        }
    }

    @SuppressWarnings("deprecation")
    public Page<Produto> buscarTodosProdutosPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return produtoRepository.findAll(pageRequest);
    }

    @SuppressWarnings("deprecation")
    public Page<Produto> buscarProdutosPorNomeCategoriasPage(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List <Categoria> categorias = categoriaRepository.findAllById(ids);
        return produtoRepository.search(nome, categorias, pageRequest);
    }

    public Produto fromDTO (ProdutoDTO prodDto) {
        Produto teste = null;
        return teste;
//    	return new Produto(prodDto.getIdProduto(), prodDto.getNomeProduto());
    }

}
