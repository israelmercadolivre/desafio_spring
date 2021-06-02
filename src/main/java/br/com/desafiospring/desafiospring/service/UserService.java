package br.com.desafiospring.desafiospring.service;

import br.com.desafiospring.desafiospring.dto.followed.FollowedDto;
import br.com.desafiospring.desafiospring.dto.followed.FollowedListDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerCountDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerListDto;
import br.com.desafiospring.desafiospring.exception.UserDoesNotExistingException;
import br.com.desafiospring.desafiospring.model.user.*;
import br.com.desafiospring.desafiospring.repository.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private SellerService sellerService;
    private SellerFollowService sellerFollowService;
    private static final String USER_NOTFOUND = "User [%s] not found";

    public UserService(UserRepository userRepository, SellerService sellerService, SellerFollowService sellerFollowService) {
        this.userRepository = userRepository;
        this.sellerService = sellerService;
        this.sellerFollowService = sellerFollowService;
    }


    public ResponseEntity followUser(Integer userId, Integer userIdToFollow) {
        this.sellerFollowService.verifyExistSellerFollow(userId, userIdToFollow);
        User user = this.findById(userId);
        Seller seller = this.sellerService.findById(userIdToFollow);

        SellerFollow sellerFollow = new SellerFollow();
        sellerFollow.setSeller(seller);
        sellerFollow.setUser(user);

        this.sellerFollowService.save(sellerFollow);
        return ResponseEntity.ok().build();
    }


    public FollowerCountDto countFollowers(Integer sellerId) {
        Seller seller = this.sellerService.findById(sellerId);
        return this.sellerService.sellerToFollowerCountDto(seller);
    }

    public FollowerListDto listFollowers(Integer sellerId){
        Seller seller = this.sellerService.findById(sellerId);
        return this.sellerService.sellerToFollowerListDto(seller);
    }

    public FollowedListDto listFollowed(Integer userId){
        User user = this.findById(userId);
        return this.userToFollowedListDto(user);
    }


    private Optional findByIdAndType(Integer id, Type type) {
        Optional clientOptional = this.userRepository.findByIdAndType(id, type);
        if (clientOptional.isEmpty()) {
            throw new UserDoesNotExistingException(String.format(USER_NOTFOUND, id, type.name()));
        }
        return clientOptional;
    }

    private User findById(Integer id) {
        return this.userRepository.findById(id)
                .orElseThrow(
                        () -> new UserDoesNotExistingException(String.format(USER_NOTFOUND, id)));
    }

    private FollowedListDto userToFollowedListDto(User user) {
        FollowedListDto followedListDto = new FollowedListDto();
        followedListDto.setUserId(user.getId());
        followedListDto.setUserName(user.getName());
        user.getFollowed()
                .stream()
                .map(SellerFollow::getSeller)
                .forEach(seller -> followedListDto.setFollowed(new FollowedDto(seller.getId(), seller.getName())));

        return followedListDto;
    }

}
