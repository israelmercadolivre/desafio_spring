package br.com.desafiospring.desafiospring.service.post.order;

import br.com.desafiospring.desafiospring.dto.post.PostDto;

import java.util.Comparator;

public class NameAscComparator implements Comparator<PostDto> {

    @Override
    public int compare(PostDto dto1, PostDto dto2) {
        return dto1.getDetail().getProductName().compareTo(dto2.getDetail().getProductName());
    }
}
