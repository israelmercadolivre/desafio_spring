package br.com.desafiospring.desafiospring.repository.user;

import br.com.desafiospring.desafiospring.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
