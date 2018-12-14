package br.com.lojaudemy.lojabackend;

import br.com.lojaudemy.lojabackend.model.Categoria;
import br.com.lojaudemy.lojabackend.model.Cidade;
import br.com.lojaudemy.lojabackend.model.Estado;
import br.com.lojaudemy.lojabackend.model.Produto;
import br.com.lojaudemy.lojabackend.repository.CategoriaRepository;
import br.com.lojaudemy.lojabackend.repository.CidadeRepository;
import br.com.lojaudemy.lojabackend.repository.EstadoRepository;
import br.com.lojaudemy.lojabackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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


    public static void main(String[] args) {
        SpringApplication.run(LojabackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Categoria cat1 = new Categoria(null, "Informática");
//        Categoria cat2 = new Categoria(null, "Escritório");
//
//        Produto p1 = new Produto(null, "Computador", 220.3);
//        Produto p2 = new Produto(null, "Impressora", 320.7);
//        Produto p3 = new Produto(null, "Mouse", 22.3);
//
//        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//        cat2.getProdutos().addAll(Arrays.asList(p2));
//
//        p1.getCategorias().addAll(Arrays.asList(cat1));
//        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
//        p3.getCategorias().addAll(Arrays.asList(cat1));
//
//       categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
//       produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
//
//        Estado es1 = new Estado(null, "Minas Gerais", "MG");
//        Estado es2 = new Estado(null, "Paraná", "PR");
//        Estado es3 = new Estado(null, "Bahia", "BA");
//
//        Cidade cid1 = new Cidade(null , "Arcos", es1);
//        Cidade cid2 = new Cidade(null , "Formiga", es1);
//        Cidade cid3 = new Cidade(null , "Salvador", es3);
//        Cidade cid4 = new Cidade(null , "Curitiba", es2);
//        Cidade cid5 = new Cidade(null , "Portos", es2);
//
//        es1.getCidades().addAll(Arrays.asList(cid1, cid2));
//        es2.getCidades().addAll(Arrays.asList(cid4, cid5));
//        es3.getCidades().addAll(Arrays.asList(cid3));
//
//
//        estadoRepository.saveAll(Arrays.asList(es1, es2, es3));
//        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5));

    }
}
