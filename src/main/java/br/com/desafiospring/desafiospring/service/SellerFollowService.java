package br.com.desafiospring.desafiospring.service;

import br.com.desafiospring.desafiospring.exception.UserAlreadyFollowSellerException;
import br.com.desafiospring.desafiospring.exception.UserDoesNotExistingException;
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

    public SellerFollowService(SellerFollowRepository sellerFollowRepository) {
        this.sellerFollowRepository = sellerFollowRepository;
    }

    public void verifyExistSellerFollow(Integer userId, Integer sellerId){
        Optional<SellerFollow> sellerFollow = this.sellerFollowRepository.findById(new SellerFollowKey(userId, sellerId));
        if (sellerFollow.isPresent()) {
            throw new UserAlreadyFollowSellerException(String.format(SELLER_FOLLOW_EXISTING, userId, sellerId));
        }
    }

    public void save(SellerFollow sellerFollow) {
        this.sellerFollowRepository.save(sellerFollow);
    }

    public List<SellerFollow> findSellerById(Integer id){
        return this.sellerFollowRepository.findBySellerId(id);
    }

}
