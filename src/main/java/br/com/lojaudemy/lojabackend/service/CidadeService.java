package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.Cidade;
import br.com.lojaudemy.lojabackend.model.Estado;
import br.com.lojaudemy.lojabackend.repository.CidadeRepository;
import br.com.lojaudemy.lojabackend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarCidadesPorEstado (Integer idEstado) {
        return cidadeRepository.findByEstado(idEstado);
    }

//    @SuppressWarnings("deprecation")
//    public Page<Estado> buscarTodosEstadosPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
//        return estadoRepository.findAll(pageRequest);
//    }
}