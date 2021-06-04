package br.com.desafiospring.desafiospring.service.user;

import br.com.desafiospring.desafiospring.exception.user.UserAlreadyFollowSellerException;
import br.com.desafiospring.desafiospring.exception.user.UserAlreadyNotFollowSellerException;
import br.com.desafiospring.desafiospring.model.user.SellerFollow;
import br.com.desafiospring.desafiospring.model.user.SellerFollowKey;
import br.com.desafiospring.desafiospring.repository.user.SellerFollowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SellerFollowService {

    private SellerFollowRepository sellerFollowRepository;
    private static final String SELLER_FOLLOW_EXISTING = "User [%s] is already following Seller [%s]";
    private static final String SELLER_FOLLOW_NOT_EXISTING = "User [%s] is already not following Seller [%s]";

    public SellerFollowService(SellerFollowRepository sellerFollowRepository) {
        this.sellerFollowRepository = sellerFollowRepository;
    }

    public void verifyExistSellerFollow(Integer userId, Integer sellerId){
        Optional<SellerFollow> sellerFollow = this.findById(new SellerFollowKey(userId, sellerId));
        if (sellerFollow.isPresent()) {
            throw new UserAlreadyFollowSellerException(String.format(SELLER_FOLLOW_EXISTING, userId, sellerId));
        }
    }

    public SellerFollow findByUserIdAndSellerId(Integer userId, Integer sellerId){
        Optional<SellerFollow> sellerFollow = this.findById(new SellerFollowKey(userId, sellerId));
        if (sellerFollow.isEmpty()) {
            throw new UserAlreadyNotFollowSellerException(String.format(SELLER_FOLLOW_NOT_EXISTING, userId, sellerId));
        }

        return sellerFollow.get();
    }

    public void save(SellerFollow sellerFollow) {
        this.sellerFollowRepository.save(sellerFollow);
    }

    public void remove(SellerFollow sellerFollow){
        this.sellerFollowRepository.delete(sellerFollow);
    }

    private Optional<SellerFollow> findById(SellerFollowKey id){
        return this.sellerFollowRepository.findById(id);
    }

}
