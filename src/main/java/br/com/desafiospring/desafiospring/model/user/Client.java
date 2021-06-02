package br.com.desafiospring.desafiospring.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "client")
public class Client extends User{
    public Client() {
        this.setType(Type.CLIENT);
    }
}
