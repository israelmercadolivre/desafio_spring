package br.com.desafiospring.desafiospring.model.product;

import br.com.desafiospring.desafiospring.model.post.Post;
import br.com.desafiospring.desafiospring.model.user.Seller;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Post seller;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private String category;
    private BigDecimal price;
    private Boolean hasPromo;
    private BigDecimal discount;
}
