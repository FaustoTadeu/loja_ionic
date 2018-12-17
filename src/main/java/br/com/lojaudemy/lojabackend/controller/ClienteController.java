package br.com.lojaudemy.lojabackend.controller;

import java.util.List;

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
    private ClienteService clienteService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Cliente obj = clienteService.buscarporId(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Cliente> obj = clienteService.buscarTodosClientes();
        return ResponseEntity.ok().body(obj);
    }
    
}
