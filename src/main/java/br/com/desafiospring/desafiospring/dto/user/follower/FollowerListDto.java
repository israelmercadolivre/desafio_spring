package br.com.desafiospring.desafiospring.dto.user.follower;

import br.com.desafiospring.desafiospring.dto.user.FollowDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowerListDto {
    private Integer userId;
    private String userName;
    private List<FollowDto> followers;

    public FollowerListDto() {
        this.followers = new ArrayList<>();
    }

    public void setFollowers(FollowDto followerDto){
        this.followers.add(followerDto);
    }
}
