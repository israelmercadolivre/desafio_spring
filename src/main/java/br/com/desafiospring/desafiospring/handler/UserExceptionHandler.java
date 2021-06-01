package br.com.desafiospring.desafiospring.handler;

import br.com.desafiospring.desafiospring.exception.UserDoesNotExistingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserDoesNotExistingException.class)
    public ResponseEntity<Object> linkDoesNotExistingException(UserDoesNotExistingException e, WebRequest request) {
        return new ResponseEntity<>(e.getMessage()  , HttpStatus.NOT_FOUND);
    }
}
