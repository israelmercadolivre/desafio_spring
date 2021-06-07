package br.com.desafiospring.desafiospring.handler.order;

import br.com.desafiospring.desafiospring.exception.MessageError;
import br.com.desafiospring.desafiospring.exception.order.InvalidOrderException;
import br.com.desafiospring.desafiospring.exception.post.InvalidValuesPostPromoException;
import br.com.desafiospring.desafiospring.exception.post.PostAlreadyExistException;
import br.com.desafiospring.desafiospring.exception.post.PostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(value = InvalidOrderException.class)
    public ResponseEntity getExceptions(InvalidOrderException e) {
        MessageError messageError = new MessageError(e.getMessage());
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }
}
