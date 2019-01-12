package br.com.lojaudemy.lojabackend.service;

import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.model.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido ped);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail (Cliente cliente, String newPass);


}
