package br.com.desafiospring.desafiospring.controller;

import br.com.desafiospring.desafiospring.dto.user.followed.FollowedListDto;
import br.com.desafiospring.desafiospring.dto.user.follower.FollowerCountDto;
import br.com.desafiospring.desafiospring.dto.user.follower.FollowerListDto;
import br.com.desafiospring.desafiospring.service.user.SellerService;
import br.com.desafiospring.desafiospring.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private SellerService sellerService;

    public UserController(UserService userService, SellerService sellerService) {
        this.userService = userService;
        this.sellerService = sellerService;
    }


    //US 001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
       return this.userService.followUser(userId, userIdToFollow);
    }

    //US 002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDto> countFollowers(@PathVariable Integer userId){
        FollowerCountDto followerCountDto =  this.sellerService.countFollowers(userId);
        return ResponseEntity.ok().body(followerCountDto);
    }

    //US 003
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerListDto> listFollowers(@PathVariable Integer userId){
        FollowerListDto followerListDto =  this.sellerService.listFollowers(userId);
        return ResponseEntity.ok().body(followerListDto);
    }


    //US 004
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDto> listFollowed(@PathVariable Integer userId){
        FollowedListDto followedListDto =  this.userService.listFollowed(userId);
        return ResponseEntity.ok().body(followedListDto);
    }

    //US 007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return this.userService.unfollowUser(userId, userIdToUnfollow);
    }
}
