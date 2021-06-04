package br.com.desafiospring.desafiospring.dto.post;

import lombok.Data;

import java.util.List;

@Data
public class SellerPostsDto {
    private Integer userId;
    private List<PostDto> posts;
}
