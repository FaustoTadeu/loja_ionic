package br.com.lojaudemy.lojabackend.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.lojaudemy.lojabackend.dto.ClienteDTO;
import br.com.lojaudemy.lojabackend.dto.ClienteNewDTO;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findClienteById(@PathVariable Integer idCliente) {
        Cliente obj = clienteService.buscarClientePorId(idCliente);
        return ResponseEntity.ok().body(obj);
    }

    @Transactional
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAllClientes() {
        List<Cliente> listClientes = clienteService.buscarTodosClientes();
        List <ClienteDTO> listClientesDto = listClientes.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listClientesDto);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InsertCliente(@Valid @RequestBody ClienteNewDTO cliNewDto) {
        Cliente cli = clienteService.fromDTO(cliNewDto, null);
        cli = clienteService.inserirEditarCliente(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idCliente}").buildAndExpand(cli.getIdCliente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idCliente}", method = RequestMethod.PUT)
    public ResponseEntity<Void> EditCliente(@Valid @RequestBody ClienteDTO cliDto, @PathVariable Integer idCliente) {
    	Cliente cli = clienteService.fromDTO(cliDto, idCliente);
        clienteService.inserirEditarCliente(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idCliente}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteClienteById(@PathVariable Integer idCliente) {
        clienteService.apagarCliente(idCliente);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findAllClientesPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nomeCliente") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Cliente> listClientes = clienteService.buscarTodosClientesPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listClientesDto = listClientes.map(obj -> new ClienteDTO(obj));
        return ResponseEntity.ok().body(listClientesDto);
    }

}
