package br.com.desafiospring.desafiospring.controller;

import br.com.desafiospring.desafiospring.dto.FollowerDto;
import br.com.desafiospring.desafiospring.model.Type;
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

    @GetMapping
    public ResponseEntity criaUsuario(){
        this.userService.criaUser();
        return ResponseEntity.ok().body("");
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
       return this.userService.followUser(userId, userIdToFollow);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerDto> countFollowers(@PathVariable Integer userId){
        FollowerDto followerDto =  this.userService.countFollowers(userId);
        return ResponseEntity.ok().body(followerDto);
    }
}
