package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.PagamentoBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
public class BoletoService {

    public void preencherPagamentoComBoleto (PagamentoBoleto pgto, Date dataPedido) {

       //Trocar pela chamada do webservice de pagamento que retornará a data de pagamento
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataPedido);
        cal.add(Calendar.DAY_OF_MONTH, 10);
        pgto.setDataVencimento(cal.getTime());
    }
}
