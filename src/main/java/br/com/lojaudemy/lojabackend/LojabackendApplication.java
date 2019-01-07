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

    public static void main(String[] args) {
        SpringApplication.run(LojabackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
