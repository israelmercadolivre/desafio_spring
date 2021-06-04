package br.com.desafiospring.desafiospring.exception.post;

public class PostAlreadyExistException extends PostException{
    public PostAlreadyExistException(String message) {
        super(message);
    }
}
