package br.com.desafiospring.desafiospring.service.user;

import br.com.desafiospring.desafiospring.dto.user.followed.FollowedDto;
import br.com.desafiospring.desafiospring.dto.user.followed.FollowedListDto;
import br.com.desafiospring.desafiospring.exception.user.InvalidFollowUserException;
import br.com.desafiospring.desafiospring.exception.user.UserDoesNotExistingException;
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
    private static final String INVALID_FOLLOW_USER = "User [%s] can not follow User [%s]";

    public UserService(UserRepository userRepository, SellerService sellerService, SellerFollowService sellerFollowService) {
        this.userRepository = userRepository;
        this.sellerService = sellerService;
        this.sellerFollowService = sellerFollowService;
    }


    public ResponseEntity followUser(Integer userId, Integer userIdToFollow) {
        this.verifyUserFollow(userId, userIdToFollow);
        this.sellerFollowService.verifyExistSellerFollow(userId, userIdToFollow);

        User user = this.findById(userId);
        Seller seller = this.sellerService.findById(userIdToFollow);

        SellerFollow sellerFollow = new SellerFollow();
        sellerFollow.setSeller(seller);
        sellerFollow.setUser(user);

        this.sellerFollowService.save(sellerFollow);
        return ResponseEntity.ok().build();
    }

    private void verifyUserFollow(Integer userId, Integer userIdToFollow) {
        if(userId == userIdToFollow){
            throw new InvalidFollowUserException(String.format(INVALID_FOLLOW_USER, userId, userIdToFollow));
        }
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

    public User findById(Integer id) {
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
