package br.com.desafiospring.desafiospring.repository.user;

import br.com.desafiospring.desafiospring.model.user.Type;
import br.com.desafiospring.desafiospring.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByIdAndType(Integer id, Type type);

}
