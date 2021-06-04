package br.com.desafiospring.desafiospring.controller;

import br.com.desafiospring.desafiospring.dto.post.PostDto;
import br.com.desafiospring.desafiospring.service.post.PostService;
import br.com.desafiospring.desafiospring.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private PostService postService;

    public ProductController(ProductService productService, PostService postService) {
        this.productService = productService;
        this.postService = postService;
    }

    //US005
    @PostMapping("/newpost")
    public ResponseEntity createPost(@RequestBody PostDto postDto){
        return this.productService.createProduct(postDto);
    }

    //US006
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity getListPostByUser(@PathVariable Integer userId, @PathParam("order") String order){
       return this.postService.getListPostByUser(userId, order);
    }

    //US0010
    @PostMapping( "/newpromopost")
    public ResponseEntity createPostPromo(@RequestBody PostDto postDto){
        return this.productService.createProductPromo(postDto);
    }
}
