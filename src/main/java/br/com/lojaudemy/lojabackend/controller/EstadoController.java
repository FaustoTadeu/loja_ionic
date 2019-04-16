package br.com.lojaudemy.lojabackend.controller;

import br.com.lojaudemy.lojabackend.dto.CidadeDTO;
import br.com.lojaudemy.lojabackend.dto.EstadoDTO;
import br.com.lojaudemy.lojabackend.model.Cidade;
import br.com.lojaudemy.lojabackend.model.Estado;
import br.com.lojaudemy.lojabackend.service.CidadeService;
import br.com.lojaudemy.lojabackend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeService cidadeService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EstadoDTO>> findAllEstados() {
       List<Estado> listEstados = estadoService.buscarTodosEstados();
        List <EstadoDTO> listEstadosDto = listEstados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listEstadosDto);
    }

    @RequestMapping(value = "/{idEstado}/cidades", method = RequestMethod.GET)
    public ResponseEntity<List<CidadeDTO>> findCidadesPorIdEstado(@PathVariable Integer idEstado) {
        List<Cidade> listCidades = cidadeService.buscarCidadesPorEstado(idEstado);
        List <CidadeDTO> listCidadesDto = listCidades.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listCidadesDto);
        }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<EstadoDTO>> findAllEstadosPage(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "nomeEstado") String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
            Page<Estado> listEstados = estadoService.buscarTodosEstadosPage(page, linesPerPage, orderBy, direction);
            Page<EstadoDTO> listEstadosDto = listEstados.map(obj -> new EstadoDTO(obj));
            return ResponseEntity.ok().body(listEstadosDto);
    }
    
}
