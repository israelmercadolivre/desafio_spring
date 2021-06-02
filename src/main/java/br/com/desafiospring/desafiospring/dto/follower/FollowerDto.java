package br.com.desafiospring.desafiospring.dto.follower;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowerDto {
    private Integer userId;
    private String userName;
}
