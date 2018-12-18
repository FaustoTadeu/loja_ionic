package br.com.lojaudemy.lojabackend;

import br.com.lojaudemy.lojabackend.enums.EstadoPagamento;
import br.com.lojaudemy.lojabackend.enums.TipoCliente;
import br.com.lojaudemy.lojabackend.model.*;
import br.com.lojaudemy.lojabackend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class LojabackendApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;



    public static void main(String[] args) {
        SpringApplication.run(LojabackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	
//    	//Insert Categoria e Produtos
//        Categoria cat1 = new Categoria(null, "Informática");
//        Categoria cat2 = new Categoria(null, "Escritório");
//
//        Produto p1 = new Produto(null, "Computador", 220.3);
//        Produto p2 = new Produto(null, "Impressora", 320.7);
//        Produto p3 = new Produto(null, "Mouse", 22.3);
//
//    	cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//        cat2.getProdutos().addAll(Arrays.asList(p2));
//
//        p1.getCategorias().addAll(Arrays.asList(cat1));
//        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
//        p3.getCategorias().addAll(Arrays.asList(cat1));
//
//    	categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
//        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
//
//    	//Insert Cidade e Estado
//        Estado es1 = new Estado(null, "Minas Gerais", "MG");
//        Estado es2 = new Estado(null, "Paraná", "PR");
//        Estado es3 = new Estado(null, "Bahia", "BA");
//
//        Cidade cid1 = new Cidade(null , "Belo Horizonte", es1);
//        Cidade cid2 = new Cidade(null , "Arcos", es1);
//        Cidade cid3 = new Cidade(null , "Salvador", es3);
//        Cidade cid4 = new Cidade(null , "Curitiba", es2);
//        Cidade cid5 = new Cidade(null , "Portos", es2);
//
//        es1.getCidades().addAll(Arrays.asList(cid1, cid2));
//        es2.getCidades().addAll(Arrays.asList(cid4, cid5));
//        es3.getCidades().addAll(Arrays.asList(cid3));
//
//        estadoRepository.saveAll(Arrays.asList(es1, es2, es3));
//        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5));
//
//    	//Insert Cliente, endereços e telefones
//    	Cliente cli1 = new Cliente(null, "Fausto Tadeu", "fausto.tna@hotmail.com", "123456789-11",  TipoCliente.PESSOAFISICA);
//    	cli1.getTelefones().addAll(Arrays.asList("3332-6763", "99557-3544"));
//
//    	Endereco end1 = new Endereco(null, "R. Sebastião de Barros", "344", "Nova Granada", "Apto 101", "30431-325", cli1, cid1);
//    	Endereco end2 = new Endereco(null, "R. Padre Pedro Lambert", "489", "Centro", "Casa", "35588000", cli1, cid2);
//
//    	cli1.getEndereco().addAll(Arrays.asList(end1, end2));
//
//    	clienteRepository.saveAll(Arrays.asList(cli1));
//    	enderecoRepository.saveAll(Arrays.asList(end1, end2));
//
//        //Pedido e pagamento
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        Pedido pd1 = new Pedido(null, sdf.parse("30/09/2018 10:32"), cli1, end1);
//        Pedido pd2 = new Pedido(null, sdf.parse("10/10/2018 19:20"), cli1, end2);
//
//        Pagamento pgto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, pd1, 6);
//        pd1.setPagamento(pgto1);
//        Pagamento pgto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, pd2, sdf.parse("20/10/2018 06:11"), null);
//        pd2.setPagamento(pgto2);
//
//        cli1.getPedidos().addAll(Arrays.asList(pd1, pd2));
//
//        pedidoRepository.saveAll(Arrays.asList(pd1, pd2));
//        pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

    }
}
