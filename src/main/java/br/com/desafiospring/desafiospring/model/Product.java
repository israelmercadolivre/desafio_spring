package br.com.desafiospring.desafiospring.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Seller seller;
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
