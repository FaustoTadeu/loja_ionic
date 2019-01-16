package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.model.Pedido;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Pedido ped) {
        SimpleMailMessage email = prepareSimpleMailMessageFromPedido(ped);
        sendEmail(email);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido ped) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(ped.getCliente().getEmailCliente());
        sm.setFrom(sender);
        sm.setSubject("Pedido confirmado" + ped.getIdPedido());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(ped.toString());
        return sm;
    }


    @Override
    public void sendEmail(SimpleMailMessage msg) {

    }

    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage email = prepareNewPasswordEmail(cliente, newPass);
        sendEmail(email);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(cliente.getEmailCliente());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Sua nova senha de acesso é: " + newPass );
        return sm;
    }
}
