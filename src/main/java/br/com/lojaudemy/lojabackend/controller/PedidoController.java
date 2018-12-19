package br.com.lojaudemy.lojabackend.controller;

import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.model.Pedido;
import br.com.lojaudemy.lojabackend.service.CategoriaService;
import br.com.lojaudemy.lojabackend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        Pedido obj = pedidoService.buscarporId(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> obj = pedidoService.buscarTodasCategorias();
        return ResponseEntity.ok().body(obj);
    }
    
}
