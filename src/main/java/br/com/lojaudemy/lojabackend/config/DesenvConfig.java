package br.com.lojaudemy.lojabackend.config;

import br.com.lojaudemy.lojabackend.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("desenv")
public class DesenvConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean  instantiateDatabase() throws ParseException {
        if(!strategy.equals("create")) {
            return false;
        }
        dbService.instatiateTestDatabase();
        return true;
    }

}
