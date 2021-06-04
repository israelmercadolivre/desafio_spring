package br.com.desafiospring.desafiospring.handler.product;

import br.com.desafiospring.desafiospring.exception.MessageError;
import br.com.desafiospring.desafiospring.exception.product.ProductAlreadyExistException;
import br.com.desafiospring.desafiospring.exception.product.ProductException;
import br.com.desafiospring.desafiospring.exception.user.InvalidFollowUserException;
import br.com.desafiospring.desafiospring.exception.user.UserAlreadyFollowSellerException;
import br.com.desafiospring.desafiospring.exception.user.UserDoesNotExistingException;
import br.com.desafiospring.desafiospring.exception.user.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(value = ProductAlreadyExistException.class)
    public ResponseEntity getExceptions(ProductAlreadyExistException e) {
        MessageError messageError = new MessageError(e.getMessage());
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }
}
