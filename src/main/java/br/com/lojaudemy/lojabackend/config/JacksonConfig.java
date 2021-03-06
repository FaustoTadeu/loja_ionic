package br.com.lojaudemy.lojabackend.config;

import br.com.lojaudemy.lojabackend.model.PagamentoBoleto;
import br.com.lojaudemy.lojabackend.model.PagamentoCartao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {


    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(PagamentoCartao.class);
                objectMapper.registerSubtypes(PagamentoBoleto.class);
                super.configure(objectMapper);
            }
        };
        return builder;
    }
}
