package br.com.desafiospring.desafiospring.dto.user.followed;

import br.com.desafiospring.desafiospring.dto.user.FollowDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowedListDto {
    private Integer userId;
    private String userName;
    private List<FollowDto> followed;

    public FollowedListDto() {
        this.followed = new ArrayList<>();
    }

    public void setFollowed(FollowDto followDto){
        this.followed.add(followDto);
    }
}
