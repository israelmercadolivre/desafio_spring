package br.com.desafiospring.desafiospring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Seller extends User {
    @ManyToMany
    @JoinTable(name = "seller_client", joinColumns = @JoinColumn(name = "seller_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> followers;
    @OneToMany(mappedBy = "seller")
    private List<Product> products;
    @OneToMany(mappedBy = "seller")
    private List<Post> posts;
}