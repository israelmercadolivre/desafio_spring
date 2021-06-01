package br.com.desafiospring.desafiospring.dto;

import lombok.Data;

@Data
public class FollowerDto {
    private Integer userId;
    private String userName;
    private int followers_count;
}
