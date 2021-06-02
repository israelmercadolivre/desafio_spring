package br.com.desafiospring.desafiospring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageError {

    private String message;
}
