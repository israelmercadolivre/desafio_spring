package br.com.desafiospring.desafiospring.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "seller_follow")
public class SellerFollow {
    @EmbeddedId
    private SellerFollowKey id = new SellerFollowKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("sellerId")
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
