package br.com.lojaudemy.lojabackend.controller;

import br.com.lojaudemy.lojabackend.dto.CategoriaDTO;
import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.service.CategoriaService;
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
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idCategoria}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> findCategoriaById(@PathVariable Integer idCategoria) {
        Categoria obj = categoriaService.buscarCategoriaPorId(idCategoria);
        return ResponseEntity.ok().body(obj);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAllCategorias() {
        List<Categoria> listCategorias = categoriaService.buscarTodasCategorias();
        List <CategoriaDTO> listCategoriasDto = listCategorias.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listCategoriasDto);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InsertCategoria(@Valid @RequestBody CategoriaDTO catDto) {
        Categoria cat = categoriaService.fromDTO(catDto, null);
        cat = categoriaService.inserirEditarCategoria(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idCategoria}").buildAndExpand(cat.getIdCategoria()).toUri();
         return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idCategoria}", method = RequestMethod.PUT)
    public ResponseEntity<Void> EditCategoria(@Valid @RequestBody CategoriaDTO catDto, @PathVariable Integer idCategoria) {
    	Categoria cat = categoriaService.fromDTO(catDto, idCategoria);
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
            Page<Categoria> listCategorias = categoriaService.buscarTodasCategoriasPage(page, linesPerPage, orderBy, direction);
            Page<CategoriaDTO> listCategoriasDto = listCategorias.map(obj -> new CategoriaDTO(obj));
            return ResponseEntity.ok().body(listCategoriasDto);
    }
    
}
