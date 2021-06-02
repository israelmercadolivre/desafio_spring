package br.com.desafiospring.desafiospring.service;

import br.com.desafiospring.desafiospring.dto.FollowerCountDto;
import br.com.desafiospring.desafiospring.exception.UserDoesNotExistingException;
import br.com.desafiospring.desafiospring.model.user.Seller;
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

    public FollowerCountDto sellerToFollowerDto(Seller seller) {
        FollowerCountDto followerCountDto = new FollowerCountDto();
        followerCountDto.setUserId(seller.getId());
        followerCountDto.setUserName(seller.getName());
        followerCountDto.setFollowers_count(seller.getFollowers().size());

        return followerCountDto;
    }
}
