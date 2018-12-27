package br.com.lojaudemy.lojabackend.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.lojaudemy.lojabackend.controller.exception.FieldMessage;
import br.com.lojaudemy.lojabackend.dto.ClienteDTO;
import br.com.lojaudemy.lojabackend.dto.ClienteNewDTO;
import br.com.lojaudemy.lojabackend.enums.TipoCliente;
import br.com.lojaudemy.lojabackend.model.Cliente;
import br.com.lojaudemy.lojabackend.repository.ClienteRepository;
import br.com.lojaudemy.lojabackend.service.validation.utils.ValidationsBR;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize (ClienteUpdate ann) {
		
	}
	
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
	
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer idCliente = Integer.parseInt(map.get("idCliente"));
		
		
		Cliente cli = clienteRepository.findByEmailCliente(objDto.getEmailCliente());
		if(cli != null && !cli.getIdCliente().equals(idCliente)) {
			list.add(new FieldMessage ("emailCliente", "Email já cadastrado"));
		}
		
		for(FieldMessage fm : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fm.getMessage()).addPropertyNode(fm.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
