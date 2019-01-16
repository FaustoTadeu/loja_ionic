package br.com.lojaudemy.lojabackend.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lojaudemy.lojabackend.controller.exception.FieldMessage;
import br.com.lojaudemy.lojabackend.dto.ClienteNewDTO;
import br.com.lojaudemy.lojabackend.enums.TipoCliente;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.service.validation.utils.ValidationsBR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void initialize (ClienteInsert ann) {
		
	}
	
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCod()) && !ValidationsBR.isValidCPF(objDto.getCpfCnpjCliente())) {
			list.add(new FieldMessage("cpfCnpjCliente", "CPF inválido!"));
		}
		
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !ValidationsBR.isValidCNPJ(objDto.getCpfCnpjCliente())) {
			list.add(new FieldMessage("cpfCnpjCliente", "CNPJ inválido!"));
		}
		
		Cliente cli = clienteRepository.findByEmailCliente(objDto.getEmailCliente());
		if(cli != null) {
			list.add(new FieldMessage ("emailCliente", "Email já cadastrado"));
		}
		
		for(FieldMessage fm : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fm.getMessage()).addPropertyNode(fm.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
