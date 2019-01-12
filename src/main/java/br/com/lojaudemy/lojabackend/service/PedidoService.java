package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.enums.EstadoPagamento;
import br.com.lojaudemy.lojabackend.model.*;
import br.com.lojaudemy.lojabackend.repository.*;
import br.com.lojaudemy.lojabackend.security.UserSS;
import br.com.lojaudemy.lojabackend.service.exception.AuthorizationException;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private BoletoService boletoService;

      @Autowired
      private PagamentoRepository pagamentoRepository;

     @Autowired
     private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteService clienteService;

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

    @Transactional
    public Pedido inserirPedido(Pedido obj) {
        obj.setIdPedido(null);
        obj.setDataPedido(new Date());
        obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if(obj.getPagamento() instanceof PagamentoBoleto) {
            PagamentoBoleto pgto = (PagamentoBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pgto, obj.getDataPedido());
        }
        obj = pedidoRepository.save(obj);
        pagamentoRepository.save(obj.getPagamento());

        for(ItemPedido item: obj.getItens()) {
            item.setDescontoItemPedido(0.0);
            Produto prod = produtoRepository.findById(item.getProduto().getIdProduto()).get();
            item.setPrecoItemPedido(prod.getPreco());
            item.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        return obj;
    }

    public Page<Pedido> buscarTodosPedidosPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Cliente cliente =  clienteService.buscarClientePorId(user.getId());
        return pedidoRepository.findByCliente(cliente, pageRequest);
    }

}
