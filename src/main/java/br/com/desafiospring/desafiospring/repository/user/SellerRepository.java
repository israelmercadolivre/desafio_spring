package br.com.desafiospring.desafiospring.repository.user;

import br.com.desafiospring.desafiospring.model.user.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {
}
