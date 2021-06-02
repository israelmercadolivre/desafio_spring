package br.com.desafiospring.desafiospring.model.post;

import br.com.desafiospring.desafiospring.model.product.Product;
import br.com.desafiospring.desafiospring.model.user.Seller;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @ManyToOne
    private Seller seller;

    @OneToMany(mappedBy = "seller")
    private List<Product> products;
}
