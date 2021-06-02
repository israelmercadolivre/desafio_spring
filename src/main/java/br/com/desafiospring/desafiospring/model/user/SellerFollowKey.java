package br.com.desafiospring.desafiospring.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SellerFollowKey implements Serializable {
    @Column(name = "user_id")
    Integer userId;

    @Column(name = "seller_id")
    Integer sellerId;

}