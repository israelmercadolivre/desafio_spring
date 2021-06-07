package br.com.desafiospring.desafiospring.exception.order;

public class InvalidOrderException extends RuntimeException{
    public InvalidOrderException(String message) {
        super(message);
    }
}
