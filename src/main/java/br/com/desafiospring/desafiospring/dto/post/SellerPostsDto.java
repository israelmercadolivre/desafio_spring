package br.com.desafiospring.desafiospring.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class SellerPostsDto {
    private Integer userId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;
    private List<PostDto> posts;
}
