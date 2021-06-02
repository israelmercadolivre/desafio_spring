package br.com.desafiospring.desafiospring.service;

import br.com.desafiospring.desafiospring.dto.follower.FollowerCountDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerDto;
import br.com.desafiospring.desafiospring.dto.follower.FollowerListDto;
import br.com.desafiospring.desafiospring.exception.UserDoesNotExistingException;
import br.com.desafiospring.desafiospring.model.user.Seller;
import br.com.desafiospring.desafiospring.model.user.SellerFollow;
import br.com.desafiospring.desafiospring.repository.user.SellerRepository;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    private SellerRepository sellerRepository;
    private static final String SELLER_NOTFOUND = "Seller [%s] not found";

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller findById(Integer id){
       return this.sellerRepository.findById(id)
                .orElseThrow(
                        () -> new UserDoesNotExistingException(String.format(SELLER_NOTFOUND, id)));
    }

    public FollowerCountDto sellerToFollowerCountDto(Seller seller) {
        FollowerCountDto followerCountDto = new FollowerCountDto();
        followerCountDto.setUserId(seller.getId());
        followerCountDto.setUserName(seller.getName());
        followerCountDto.setFollowers_count(seller.getFollowers().size());

        return followerCountDto;
    }

    public FollowerListDto sellerToFollowerListDto(Seller seller) {
        FollowerListDto followerListDto = new FollowerListDto();
        followerListDto.setUserId(seller.getId());
        followerListDto.setUserName(seller.getName());
        seller.getFollowers()
                .stream()
                .map(SellerFollow::getUser)
                .forEach(user -> followerListDto.setFollowers(new FollowerDto(user.getId(), user.getName())));
        return followerListDto;
    }
}