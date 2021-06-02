package br.com.desafiospring.desafiospring.service;

import br.com.desafiospring.desafiospring.dto.FollowerCountDto;
import br.com.desafiospring.desafiospring.dto.FollowerListDto;
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
}
