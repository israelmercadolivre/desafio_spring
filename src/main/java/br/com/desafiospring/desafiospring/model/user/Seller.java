package br.com.desafiospring.desafiospring.model.user;

import br.com.desafiospring.desafiospring.model.post.Post;
import br.com.desafiospring.desafiospring.model.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "seller")
public class Seller extends User {

    @OneToMany(mappedBy = "seller")
    private List<SellerFollow> followers;

    @OneToMany(mappedBy = "seller")
    private List<Post> posts;

    public Seller() {
        this.setType(Type.SELLER);
    }
}
