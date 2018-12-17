package br.com.lojaudemy.lojabackend.controller;

import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Categoria obj = categoriaService.buscarporId(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Categoria> obj = categoriaService.buscarTodasCategorias();
        return ResponseEntity.ok().body(obj);
    }
    
}
