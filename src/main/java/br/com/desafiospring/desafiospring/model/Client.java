package br.com.desafiospring.desafiospring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Client extends User{
    @ManyToMany(mappedBy = "followers")
    private List<Seller> sellers;

    public void addSellers(Seller seller) {
        if (this.sellers == null) this.sellers = new ArrayList<>();
        this.sellers.add(seller);
    }

    public Client() {
        this.setType(Type.CLIENT);
    }
}
