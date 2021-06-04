package br.com.desafiospring.desafiospring.dto.user.followed;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowedListDto {
    private Integer userId;
    private String userName;
    private List<FollowedDto> followed;

    public FollowedListDto() {
        this.followed = new ArrayList<>();
    }

    public void setFollowed(FollowedDto followedDto){
        this.followed.add(followedDto);
    }
}
