package br.com.desafiospring.desafiospring.repository.product;

import br.com.desafiospring.desafiospring.model.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
