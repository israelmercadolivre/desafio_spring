package br.com.desafiospring.desafiospring.dto.follower;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowerListDto {
    private Integer userId;
    private String userName;
    private List<FollowerDto> followers;

    public FollowerListDto() {
        this.followers = new ArrayList<>();
    }

    public void setFollowers(FollowerDto followerDto){
        this.followers.add(followerDto);
    }
}
