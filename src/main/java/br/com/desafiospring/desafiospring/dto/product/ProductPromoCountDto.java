package br.com.desafiospring.desafiospring.dto.product;

import lombok.Data;

@Data
public class ProductPromoCountDto {
    private Integer userId;
    private String userName;
    private Integer promoproducts_count;
}
