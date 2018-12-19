package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.Pedido;
import br.com.lojaudemy.lojabackend.repository.PedidoRepository;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarporId(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName()
        ));
    }
    
    public List<Pedido> buscarTodasCategorias() {
    	List<Pedido> obj = null;
    	try {
    	   obj =  pedidoRepository.findAll();
        }catch (Exception e) {
			new ObjectNotFoundException("Objetos do tipo " + Pedido.class.getName() + " não encontrados");
		}
        return obj;
    }
    
}
