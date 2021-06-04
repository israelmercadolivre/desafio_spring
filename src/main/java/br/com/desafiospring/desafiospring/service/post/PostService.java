package br.com.desafiospring.desafiospring.service.post;

import br.com.desafiospring.desafiospring.dto.post.PostDto;
import br.com.desafiospring.desafiospring.exception.post.PostAlreadyExistException;
import br.com.desafiospring.desafiospring.model.post.Post;
import br.com.desafiospring.desafiospring.model.user.Seller;
import br.com.desafiospring.desafiospring.repository.post.PostRepository;
import br.com.desafiospring.desafiospring.service.user.SellerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private SellerService sellerService;
    private static final String POST_ALREADY_EXIST = "Post with [%s] already exist";

    public PostService(PostRepository postRepository, SellerService sellerService) {
        this.postRepository = postRepository;
        this.sellerService = sellerService;
    }

    private Post postDtoToPost(PostDto dto) {
        Seller seller = sellerService.findById(dto.getUserId());

        Post post = new Post();
        post.setId(dto.getId_post());
        post.setDate(dto.getDate());
        post.setSeller(seller);
        post.setCategory(dto.getCategory());
        post.setPrice(dto.getPrice());
        post.setDiscount(dto.getDiscount() != null ? dto.getDiscount() : BigDecimal.ZERO);
        post.setHasPromo(dto.getHasPromo() != null ? dto.getHasPromo() : false);
        return post;
    }

    public Post createPostByDto(PostDto dto) {
        this.verifyExistPost(dto.getId_post());
        Post post = this.postDtoToPost(dto);
        return this.postRepository.save(post);
    }

    private void verifyExistPost(Integer id) {
        Optional<Post> post = this.postRepository.findById(id);

        if (post.isPresent()) {
            throw new PostAlreadyExistException(String.format(POST_ALREADY_EXIST, id));
        }
    }
}
