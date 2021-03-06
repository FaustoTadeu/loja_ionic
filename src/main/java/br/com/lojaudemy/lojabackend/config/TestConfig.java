package br.com.lojaudemy.lojabackend.config;

import br.com.lojaudemy.lojabackend.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    public boolean  instantiateDatabase() throws ParseException {
        dbService.instatiateTestDatabase();
        return true;
    }

}
