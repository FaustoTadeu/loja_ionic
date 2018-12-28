package br.com.lojaudemy.lojabackend.controller;

import br.com.lojaudemy.lojabackend.controller.utils.URL;
import br.com.lojaudemy.lojabackend.dto.ProdutoDTO;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.model.Produto;
import br.com.lojaudemy.lojabackend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idProduto}", method = RequestMethod.GET)
    public ResponseEntity<Produto> findProdutoById(@PathVariable Integer idProduto) {
        Produto obj = produtoService.buscarProdutoPorId(idProduto);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProdutoDTO>> findAllProdutos() {
        List<Produto> listProdutos = produtoService.buscarTodosProdutos();
        List <ProdutoDTO> listProdutosDto = listProdutos.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listProdutosDto);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InsertProduto(@Valid @RequestBody ProdutoDTO prodDto) {
        Produto prod =   null;//produtoService.fromDTO(prodDto);
        prod = produtoService.inserirEditarProduto(prod);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idProduto}").buildAndExpand(prod.getIdProduto()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idProduto}", method = RequestMethod.PUT)
    public ResponseEntity<Void> EditProduto(@Valid @RequestBody ProdutoDTO prodDto, @PathVariable Integer idProduto) {
    	Produto prod =   null;//clienteService.fromDTO(prodDto);
    	prod.setIdProduto(idProduto);
        produtoService.inserirEditarProduto(prod);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idProduto}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteProdutoById(@PathVariable Integer idProduto) {
        produtoService.apagarProduto(idProduto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ProdutoDTO>> findAllProdutosPage(
            @RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value = "categorias", defaultValue = "") String categorias,
            @RequestParam(value = "page", defaultValue = "0")    Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nomeProduto") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        String decodedNome = URL.decodeString(nome);
        List<Integer> ids = URL.decodeIntList(categorias);
        Page<Produto> listProdutos = produtoService.buscarProdutosPorNomeCategoriasPage(decodedNome, ids, page, linesPerPage, orderBy, direction);
        Page<ProdutoDTO> listProdutosDto = listProdutos.map(obj -> new ProdutoDTO(obj));
        return ResponseEntity.ok().body(listProdutosDto);
    }
    
}
