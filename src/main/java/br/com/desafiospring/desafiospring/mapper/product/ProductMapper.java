package br.com.desafiospring.desafiospring.mapper.product;

import br.com.desafiospring.desafiospring.dto.product.ProductDto;
import br.com.desafiospring.desafiospring.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product productDtoToProduct(ProductDto dto){
        Product product = new Product();
        product.setId(dto.getProduct_id());
        product.setName(dto.getProductName());
        product.setType(dto.getType());
        product.setBrand(dto.getBrand());
        product.setColor(dto.getColor());
        product.setNotes(dto.getNotes());

        return product;
    }

    public ProductDto productToProductDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setProduct_id(product.getId());
        dto.setProductName(product.getName());
        dto.setType(product.getType());
        dto.setBrand(product.getBrand());
        dto.setColor(product.getColor());
        dto.setNotes(product.getNotes());

        return dto;
    }
}
