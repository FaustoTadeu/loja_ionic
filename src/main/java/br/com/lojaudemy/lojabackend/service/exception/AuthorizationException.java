package br.com.lojaudemy.lojabackend.service.exception;

public class AuthorizationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthorizationException(String msg) {
        super(msg);
    }

    public AuthorizationException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
