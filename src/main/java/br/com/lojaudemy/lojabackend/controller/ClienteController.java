package br.com.lojaudemy.lojabackend.controller;

import java.util.List;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService categoriaService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findCategoriaById(@PathVariable Integer id) {
        Cliente obj = categoriaService.buscarCPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAllCategorias() {
        List<Categoria> listCategorias = categoriaService.buscarTodasCategorias();
        List <CategoriaDTO> listategoriasDto = listCategorias.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listategoriasDto);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InserirCategoria(@Valid @RequestBody CategoriaDTO catDto) {
        Categoria cat = categoriaService.fromDTO(catDto);
        cat = categoriaService.inserirEditarCategoria(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cat.getIdCategoria()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> Editar(@Valid @RequestBody Categoria cat, @PathVariable Integer id) {
        cat.setIdCategoria(id);
        categoriaService.inserirEditarCategoria(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> deleteCategoriaById(@PathVariable Integer id) {
        categoriaService.apagarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findAllCategoriasPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nomeCategoria") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Categoria> listCategorias = categoriaService.findAllPage(page, linesPerPage, orderBy, direction);
        Page<CategoriaDTO> listategoriasDto = listCategorias.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listategoriasDto);
    }


}
