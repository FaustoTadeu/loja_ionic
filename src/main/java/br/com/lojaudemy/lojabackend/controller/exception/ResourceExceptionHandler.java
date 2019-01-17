package br.com.lojaudemy.lojabackend.controller.exception;

import br.com.lojaudemy.lojabackend.service.exception.AuthorizationException;
import br.com.lojaudemy.lojabackend.service.exception.ConstraintViolationException;
import br.com.lojaudemy.lojabackend.service.exception.DataIntegrityViolationException;
import br.com.lojaudemy.lojabackend.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Objeto não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityViolationException e, HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Dados inconsistentes", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> dataIntegrity(ConstraintViolationException e, HttpServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Restrição de chave estrangeira", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> dataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", e.getMessage(), request.getRequestURI());
        for (FieldError er : e.getBindingResult().getFieldErrors()) {
            error.addErros(er.getField(), er.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorizationException(AuthorizationException e, HttpServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

}
