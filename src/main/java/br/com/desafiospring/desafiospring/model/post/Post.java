package br.com.desafiospring.desafiospring.model.post;

import br.com.desafiospring.desafiospring.model.product.Product;
import br.com.desafiospring.desafiospring.model.user.Seller;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    private Integer id;
    private LocalDate date;
    @ManyToOne
    private Seller seller;
    private String category;
    private BigDecimal price;
    private Boolean hasPromo;
    private BigDecimal discount;
    @OneToOne(mappedBy = "post")
    private Product products;

    public Post() {
        this.hasPromo = false;
        this.discount = new BigDecimal(0);
    }
}
