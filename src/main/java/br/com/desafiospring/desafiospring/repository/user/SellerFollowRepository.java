package br.com.desafiospring.desafiospring.repository.user;

import br.com.desafiospring.desafiospring.model.user.SellerFollow;
import br.com.desafiospring.desafiospring.model.user.SellerFollowKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerFollowRepository extends CrudRepository<SellerFollow, SellerFollowKey> {
}
