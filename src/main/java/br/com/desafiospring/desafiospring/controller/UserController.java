package br.com.desafiospring.desafiospring.controller;

import br.com.desafiospring.desafiospring.dto.followed.FollowedListDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerCountDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerListDto;
import br.com.desafiospring.desafiospring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //US 001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
       return this.userService.followUser(userId, userIdToFollow);
    }

    //US 002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDto> countFollowers(@PathVariable Integer userId){
        FollowerCountDto followerCountDto =  this.userService.countFollowers(userId);
        return ResponseEntity.ok().body(followerCountDto);
    }

    //US 003
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerListDto> listFollowers(@PathVariable Integer userId){
        FollowerListDto followerListDto =  this.userService.listFollowers(userId);
        return ResponseEntity.ok().body(followerListDto);
    }


    //US 004
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDto> listFollowed(@PathVariable Integer userId){
        FollowedListDto followedListDto =  this.userService.listFollowed(userId);
        return ResponseEntity.ok().body(followedListDto);
    }
}
