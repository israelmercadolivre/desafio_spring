package br.com.desafiospring.desafiospring.service.post;

import br.com.desafiospring.desafiospring.dto.post.PostDto;
import br.com.desafiospring.desafiospring.dto.post.SellerPostsDto;
import br.com.desafiospring.desafiospring.exception.post.PostAlreadyExistException;
import br.com.desafiospring.desafiospring.mapper.post.PostMapper;
import br.com.desafiospring.desafiospring.model.post.Post;
import br.com.desafiospring.desafiospring.model.user.Seller;
import br.com.desafiospring.desafiospring.repository.post.PostRepository;
import br.com.desafiospring.desafiospring.service.user.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;
    private SellerService sellerService;
    private PostMapper postMapper;

    private static final String POST_ALREADY_EXIST = "Post with [%s] already exist";

    public PostService(PostRepository postRepository, SellerService sellerService, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.sellerService = sellerService;
        this.postMapper = postMapper;
    }

    public Post createPostByDto(PostDto dto) {
        this.verifyExistPost(dto.getId_post());
        Post post = this.postMapper.postDtoToPost(dto);
        return this.postRepository.save(post);
    }

    private void verifyExistPost(Integer id) {
        Optional<Post> post = this.postRepository.findById(id);

        if (post.isPresent()) {
            throw new PostAlreadyExistException(String.format(POST_ALREADY_EXIST, id));
        }
    }

    public ResponseEntity<SellerPostsDto> getListPostByUser(Integer userId) {
        Seller seller = this.sellerService.findById(userId);
        List<Post> posts = getPostsTwoWeekAgo(seller);

        List<PostDto> postsDto = new ArrayList<>();
        posts.stream().forEach(post -> postsDto.add(this.postMapper.postToPostDto(post)));

        SellerPostsDto sellerPostsDto = new SellerPostsDto();
        sellerPostsDto.setUserId(userId);
        sellerPostsDto.setPosts(postsDto);

        return ResponseEntity.ok().body(sellerPostsDto);
    }

    private List<Post> getPostsTwoWeekAgo(Seller seller) {
        LocalDate twoWeekAgo = LocalDate.now().minusDays(14);

        return seller.getPosts()
                .stream()
                .filter(post -> post.getDate().isAfter(twoWeekAgo))
                .filter(post -> post.getDate().isBefore(LocalDate.now().plusDays(1)))
                .collect(Collectors.toList());
    }


}
