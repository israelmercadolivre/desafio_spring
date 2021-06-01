package br.com.desafiospring.desafiospring.repository;

import br.com.desafiospring.desafiospring.model.Type;
import br.com.desafiospring.desafiospring.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository<T extends User> extends CrudRepository<T, Integer> {
    Optional<T> findByIdAndType(Integer id, Type type);

}
