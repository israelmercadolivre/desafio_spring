package br.com.desafiospring.desafiospring.repository.post;

import br.com.desafiospring.desafiospring.model.post.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
