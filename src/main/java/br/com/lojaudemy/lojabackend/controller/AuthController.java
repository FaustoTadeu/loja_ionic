package br.com.lojaudemy.lojabackend.controller;

import br.com.lojaudemy.lojabackend.dto.EmailDTO;
import br.com.lojaudemy.lojabackend.security.JWTUtil;
import br.com.lojaudemy.lojabackend.security.UserSS;
import br.com.lojaudemy.lojabackend.service.AuthService;
import br.com.lojaudemy.lojabackend.service.EmailService;
import br.com.lojaudemy.lojabackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken (HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/esqueci_senha", method = RequestMethod.POST)
    public ResponseEntity<Void> forgotPassword (@Valid @RequestBody EmailDTO emailDTO) {
        authService.setNewPassword(emailDTO.getEmail());
        return ResponseEntity.noContent().build();
    }

}
