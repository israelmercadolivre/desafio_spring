package br.com.desafiospring.desafiospring.controller;

import br.com.desafiospring.desafiospring.dto.FollowerCountDto;
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
    public ResponseEntity<FollowerCountDto> listFollowers(@PathVariable Integer userId){
        FollowerCountDto followerCountDto =  this.userService.countFollowers(userId);
        return ResponseEntity.ok().body(followerCountDto);
    }
}
