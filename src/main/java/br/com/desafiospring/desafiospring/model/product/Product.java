package br.com.desafiospring.desafiospring.model.product;

import br.com.desafiospring.desafiospring.model.post.Post;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Integer id;
    @OneToOne
    private Post post;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
