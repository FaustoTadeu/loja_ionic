package br.com.lojaudemy.lojabackend.controller;

import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> findCategoriaById(@PathVariable Integer id) {
        Categoria obj = categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> findAllCategorias() {
        List<Categoria> obj = categoriaService.buscarTodasCategorias();
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InserirEditarCategoria(@RequestBody Categoria cat) {
        cat.setIdCategoria(null);
        cat = categoriaService.inserirEditarCategoria(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cat.getIdCategoria()).toUri();
         return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> Editar(@RequestBody Categoria cat, @PathVariable Integer id) {
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


}
