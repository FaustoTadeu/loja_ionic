package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.dto.PedidoDTO;
import br.com.lojaudemy.lojabackend.model.Pedido;
import br.com.lojaudemy.lojabackend.repository.PedidoRepository;
import br.com.lojaudemy.lojabackend.service.exception.ConstraintViolationException;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPedidoPorId(Integer idPed) {
        Optional<Pedido> obj = pedidoRepository.findById(idPed);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + idPed + ", Tipo: " + Pedido.class.getName()
        ));
    }

    public List<Pedido> buscarTodosPedidos() {
        List<Pedido> obj = null;
        try {
            obj =  pedidoRepository.findAll();
        }catch (Exception e) {
            throw new ObjectNotFoundException("Objetos do tipo " + Pedido.class.getName() + " não encontrados");
        }
        return obj;
    }

    public Pedido inserirEditarPedido(Pedido ped) {
        if (ped.getIdPedido() != null) {
            buscarPedidoPorId(ped.getIdPedido());
        }
        return pedidoRepository.save(ped);
    }

    public void apagarPedido(Integer idPed) {
        Pedido ped =  buscarPedidoPorId(idPed);
        try{
            pedidoRepository.delete(ped);
        } catch (Exception e) {
            throw new ConstraintViolationException("Não é possivel excluir pedidos que possuem produtos cadastrados");
        }
    }

    @SuppressWarnings("deprecation")
	public Page<Pedido> buscarTodosPedidosPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return pedidoRepository.findAll(pageRequest);
    }

    public Pedido fromDTO (PedidoDTO pedDto) {
     Pedido teste = null;
     return teste;
//    	return new Pedido(pedDto.getIdPedido(), pedDto.getDataPedido());
    }
    
}
