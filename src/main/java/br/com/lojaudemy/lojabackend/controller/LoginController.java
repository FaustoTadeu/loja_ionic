package br.com.lojaudemy.lojabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojaudemy.lojabackend.service.UsuarioService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
    private UsuarioService loginService;

}
