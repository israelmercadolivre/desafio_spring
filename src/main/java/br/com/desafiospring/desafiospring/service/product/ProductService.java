package br.com.desafiospring.desafiospring.service.product;

import br.com.desafiospring.desafiospring.dto.post.PostDto;
import br.com.desafiospring.desafiospring.exception.product.ProductAlreadyExistException;
import br.com.desafiospring.desafiospring.mapper.product.ProductMapper;
import br.com.desafiospring.desafiospring.model.post.Post;
import br.com.desafiospring.desafiospring.model.product.Product;
import br.com.desafiospring.desafiospring.repository.product.ProductRepository;
import br.com.desafiospring.desafiospring.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private PostService postService;
    private static final String POST_ALREADY_EXIST = "Product with [%s] already exist";
    private ProductMapper mapper;

    public ProductService(ProductRepository productRepository, PostService postService, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.postService = postService;
        this.mapper = mapper;
    }


    public ResponseEntity createProductPromo(PostDto postDto) {
        this.postService.verifyExistPromo(postDto);
        return createProduct(postDto);
    }

    public ResponseEntity createProduct(PostDto postDto) {
        this.verifyExistProduct(postDto.getDetail().getProduct_id());
        Post post = this.postService.createPostByDto(postDto);
        Product product = this.mapper.productDtoToProduct(postDto.getDetail());

        product.setPost(post);
        this.productRepository.save(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyExistProduct(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);

        if (product.isPresent()) {
            throw new ProductAlreadyExistException(String.format(POST_ALREADY_EXIST, id));
        }
    }
}
