package br.com.desafiospring.desafiospring.mapper.post;

import br.com.desafiospring.desafiospring.dto.post.PostDto;
import br.com.desafiospring.desafiospring.dto.product.ProductDto;
import br.com.desafiospring.desafiospring.mapper.product.ProductMapper;
import br.com.desafiospring.desafiospring.model.post.Post;
import br.com.desafiospring.desafiospring.model.user.Seller;
import br.com.desafiospring.desafiospring.service.user.SellerService;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    private ProductMapper productMapper;
    private SellerService sellerService;

    public PostMapper(ProductMapper productMapper, SellerService sellerService) {
        this.productMapper = productMapper;
        this.sellerService = sellerService;
    }

    public PostDto postToPostDto(Post post){
        PostDto dto = new PostDto();

        dto.setId_post(post.getId());
        dto.setDate(post.getDate());
        dto.setCategory(post.getCategory());
        dto.setPrice(post.getPrice());
        dto.setDiscount(post.getDiscount());
        dto.setHasPromo(post.getHasPromo());
        ProductDto productDto = this.productMapper.productToProductDto(post.getProduct());
        dto.setDetail(productDto);

        return dto;
    }

    public Post postDtoToPost(PostDto dto) {
        Seller seller = sellerService.findById(dto.getUserId());

        Post post = new Post();
        post.setId(dto.getId_post());
        post.setDate(dto.getDate());
        post.setSeller(seller);
        post.setCategory(dto.getCategory());
        post.setPrice(dto.getPrice());
        post.setDiscount(dto.getDiscount());
        post.setHasPromo(dto.getHasPromo());
        return post;
    }
}
