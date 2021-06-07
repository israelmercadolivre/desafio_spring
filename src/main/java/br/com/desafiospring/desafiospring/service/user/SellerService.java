package br.com.desafiospring.desafiospring.service.user;

import br.com.desafiospring.desafiospring.dto.user.FollowDto;
import br.com.desafiospring.desafiospring.dto.user.follower.FollowerCountDto;
import br.com.desafiospring.desafiospring.dto.user.follower.FollowerListDto;
import br.com.desafiospring.desafiospring.exception.user.UserDoesNotExistingException;
import br.com.desafiospring.desafiospring.model.user.Seller;
import br.com.desafiospring.desafiospring.model.user.SellerFollow;
import br.com.desafiospring.desafiospring.repository.user.SellerRepository;
import br.com.desafiospring.desafiospring.service.user.order.Order;
import org.springframework.stereotype.Service;

import java.util.Comparator;

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

    public FollowerCountDto countFollowers(Integer sellerId) {
        Seller seller = this.findById(sellerId);
        return this.sellerToFollowerCountDto(seller);
    }

    public FollowerListDto listFollowers(Integer sellerId, String orderName){
        Seller seller = this.findById(sellerId);
        FollowerListDto followerListDto =  this.sellerToFollowerListDto(seller);
        if (orderName != null) {
            Order order = Order.getOrderByName(orderName);
            Comparator comparator = order.getComparator();
            followerListDto.getFollowers().sort(comparator);
        }

        return followerListDto;
    }

    public FollowerListDto sellerToFollowerListDto(Seller seller) {
        FollowerListDto followerListDto = new FollowerListDto();
        followerListDto.setUserId(seller.getId());
        followerListDto.setUserName(seller.getName());
        seller.getFollowers()
                .stream()
                .map(SellerFollow::getUser)
                .forEach(user -> followerListDto.setFollowers(new FollowDto(user.getId(), user.getName())));
        return followerListDto;
    }
}
