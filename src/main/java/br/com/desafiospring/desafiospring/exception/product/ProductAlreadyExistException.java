package br.com.desafiospring.desafiospring.exception.product;

public class ProductAlreadyExistException extends ProductException {
    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
