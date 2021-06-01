package br.com.desafiospring.desafiospring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Client extends User{
    @ManyToMany(mappedBy = "followers")
    private List<Seller> sellers;
}
