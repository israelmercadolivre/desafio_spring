package br.com.desafiospring.desafiospring.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowDto {
    private Integer userId;
    private String userName;
}
