package br.com.lojaudemy.lojabackend.security;

import br.com.lojaudemy.lojabackend.dto.CredenciaisDTO;
import br.com.lojaudemy.lojabackend.service.UserDetailServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private UserDetailsService userDetailsService;

    private JWTUtil jwtUtil;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailsService =userDetailsService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer ")) {
            UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));
            if(auth != null) {
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if(jwtUtil.tokenValido(token)) {
            String userName = jwtUtil.getUsername(token);
            UserDetails user = userDetailsService.loadUserByUsername(userName);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }

        return null;
    }


}