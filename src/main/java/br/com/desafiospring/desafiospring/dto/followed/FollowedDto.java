package br.com.desafiospring.desafiospring.dto.followed;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowedDto {
    private Integer userId;
    private String userName;
}
