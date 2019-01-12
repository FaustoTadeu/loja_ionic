package br.com.lojaudemy.lojabackend.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.lojaudemy.lojabackend.dto.PedidoDTO;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.model.Pedido;
import br.com.lojaudemy.lojabackend.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/{idPedido}", method=RequestMethod.GET)
    public ResponseEntity<Pedido> findById(@PathVariable Integer idPedido) {
        Pedido obj = pedidoService.buscarPedidoPorId(idPedido);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insertPedido(@Valid @RequestBody Pedido obj) {
        obj = pedidoService.inserirPedido(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idPedido}").buildAndExpand(obj.getIdPedido()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Page<Pedido>> findAllPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="dataPedido") String orderBy,
            @RequestParam(value="direction", defaultValue="DESC") String direction) {
        Page<Pedido> list = pedidoService.buscarTodosPedidosPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }
    
}
