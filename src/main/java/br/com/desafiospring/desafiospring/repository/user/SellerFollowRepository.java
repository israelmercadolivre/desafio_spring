package br.com.desafiospring.desafiospring.repository.user;

import br.com.desafiospring.desafiospring.model.user.SellerFollow;
import br.com.desafiospring.desafiospring.model.user.SellerFollowKey;
import br.com.desafiospring.desafiospring.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerFollowRepository extends CrudRepository<SellerFollow, SellerFollowKey> {
    List<SellerFollow> findByUserId(Integer userId);

    List<SellerFollow> findBySellerId(Integer userId);
}
