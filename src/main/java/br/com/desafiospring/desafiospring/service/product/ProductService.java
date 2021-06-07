package br.com.desafiospring.desafiospring.service.product;

import br.com.desafiospring.desafiospring.dto.post.PostDto;
import br.com.desafiospring.desafiospring.dto.product.ProductPromoCountDto;
import br.com.desafiospring.desafiospring.exception.product.ProductAlreadyExistException;
import br.com.desafiospring.desafiospring.mapper.product.ProductMapper;
import br.com.desafiospring.desafiospring.model.post.Post;
import br.com.desafiospring.desafiospring.model.product.Product;
import br.com.desafiospring.desafiospring.model.user.Seller;
import br.com.desafiospring.desafiospring.repository.product.ProductRepository;
import br.com.desafiospring.desafiospring.service.post.PostService;
import br.com.desafiospring.desafiospring.service.user.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private PostService postService;
    private ProductMapper mapper;
    private SellerService sellerService;
    private static final String POST_ALREADY_EXIST = "Product with [%s] already exist";

    public ProductService(ProductRepository productRepository, PostService postService, ProductMapper mapper, SellerService sellerService) {
        this.productRepository = productRepository;
        this.postService = postService;
        this.mapper = mapper;
        this.sellerService = sellerService;
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

    public ProductPromoCountDto getCountProductPromo(Integer userId){
        Seller seller = this.sellerService.findById(userId);
        ProductPromoCountDto dto = new ProductPromoCountDto();
        dto.setUserId(seller.getId());
        dto.setUserName(seller.getName());
        Long countProductPromo = seller.getPosts().stream()
                .filter(post -> post.getHasPromo() != null)
                .filter(Post::getHasPromo)
                .count();
        dto.setPromoproducts_count(countProductPromo);

        return dto;
    }
}
