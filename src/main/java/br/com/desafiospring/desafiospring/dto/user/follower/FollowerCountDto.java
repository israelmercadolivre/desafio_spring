package br.com.desafiospring.desafiospring.dto.user.follower;

import lombok.Data;

@Data
public class FollowerCountDto {
    private Integer userId;
    private String userName;
    private int followers_count;
}
