package br.com.lojaudemy.lojabackend.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping(value ="/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> findPedidoById(@PathVariable Integer idPedido) {
        Pedido obj = pedidoService.buscarPedidoPorId(idPedido);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PedidoDTO>> findAllPedidos() {
        List<Pedido> listPedidos = pedidoService.buscarTodosPedidos();
        List <PedidoDTO> listPedidosDto = listPedidos.stream().map(obj -> new PedidoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listPedidosDto);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InsertPedido(@Valid @RequestBody PedidoDTO pedDto) {
        Pedido ped =   null;//pedidoService.fromDTO(pedDto);
        ped = pedidoService.inserirEditarPedido(ped);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idPedido}").buildAndExpand(ped.getIdPedido()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idPedido}", method = RequestMethod.PUT)
    public ResponseEntity<Void> EditPedido(@Valid @RequestBody PedidoDTO pedDto, @PathVariable Integer idPedido) {
    	Pedido ped =   null;//clienteService.fromDTO(cliDto);
    	ped.setIdPedido(idPedido);
        pedidoService.inserirEditarPedido(ped);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idPedido}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deletePedidoById(@PathVariable Integer idPedido) {
        pedidoService.apagarPedido(idPedido);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<PedidoDTO>> findAllPedidosPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nomePedido") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Pedido> listPedidos = pedidoService.buscarTodosPedidosPage(page, linesPerPage, orderBy, direction);
        Page<PedidoDTO> listPedidosDto = listPedidos.map(obj -> new PedidoDTO(obj));
        return ResponseEntity.ok().body(listPedidosDto);
    }
    
}
