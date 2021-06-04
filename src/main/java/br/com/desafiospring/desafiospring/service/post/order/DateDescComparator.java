package br.com.desafiospring.desafiospring.service.post.order;

import br.com.desafiospring.desafiospring.dto.post.PostDto;

import java.time.LocalDate;
import java.util.Comparator;

public class DateDescComparator implements Comparator<PostDto> {

    @Override
    public int compare(PostDto dto1, PostDto dto2) {
        return dto2.getDate().compareTo(dto1.getDate());
    }
}
