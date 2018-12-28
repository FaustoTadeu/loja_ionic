package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.dto.PedidoDTO;
import br.com.lojaudemy.lojabackend.enums.EstadoPagamento;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.model.ItemPedido;
import br.com.lojaudemy.lojabackend.model.PagamentoBoleto;
import br.com.lojaudemy.lojabackend.model.Pedido;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.repository.PedidoRepository;
import br.com.lojaudemy.lojabackend.repository.ProdutoRepository;
import br.com.lojaudemy.lojabackend.service.exception.ConstraintViolationException;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

//    @Autowired
//    private BoletoService boletoService;

    //  @Autowired
    //  private PagamentoRepository pagamentoRepository;

     @Autowired
     private ProdutoRepository produtoRepository;

//    @Autowired
//    private ItemPedidoRepository itemPedidoRepository;
//
    @Autowired
    private ClienteRepository clienteRepository;

//    @Autowired
//    private EmailService emailService;

    public Pedido buscarPedidoPorId(Integer idPedido) {
        Pedido obj = pedidoRepository.findById(idPedido).get();
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + idPedido
                    + ", Tipo: " + Pedido.class.getName());
        }
        return obj;
    }

    public Pedido inserirEditarPedido(Pedido obj) {
        obj.setIdPedido(null);
        obj.setDataPedido(new Date());
        obj.setCliente(clienteRepository.findById(obj.getCliente().getIdCliente()).get());
        obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoBoleto) {
            PagamentoBoleto pagto = (PagamentoBoleto) obj.getPagamento();
       //     boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = pedidoRepository.save(obj);
 //       pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDescontoItemPedido(0.0);
     //       ip.setProduto(produtoRepository.findOne(ip.getProduto().getId()));
            ip.setPrecoItemPedido(ip.getProduto().getPreco());
       //     ip.setPedido(obj);
        }
    //    itemPedidoRepository.save(obj.getItens());
     //   emailService.sendOrderConfirmationEmail(obj);
        return obj;
    }

    public Page<Pedido> buscarTodosPedidosPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
     //   UserSS user = UserService.authenticated();
    //    if (user == null) {
    //        throw new AuthorizationException("Acesso negado");
   //     }
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Cliente cliente =  clienteRepository.findById(1).get();
        return pedidoRepository.findByCliente(cliente, pageRequest);
    }

}
