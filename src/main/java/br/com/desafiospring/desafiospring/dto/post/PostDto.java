package br.com.desafiospring.desafiospring.dto.post;

import br.com.desafiospring.desafiospring.dto.product.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class PostDto {
    private Integer userId;
    private Integer id_post;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ProductDto detail;

    private String category;
    private BigDecimal price;
    private Boolean hasPromo;
    private BigDecimal discount;
}
