package br.com.desafiospring.desafiospring.service.user.order;

import br.com.desafiospring.desafiospring.dto.post.PostDto;
import br.com.desafiospring.desafiospring.dto.user.FollowDto;

import java.util.Comparator;

public class NameAscComparator implements Comparator<FollowDto> {

    @Override
    public int compare(FollowDto o1, FollowDto o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }
}
