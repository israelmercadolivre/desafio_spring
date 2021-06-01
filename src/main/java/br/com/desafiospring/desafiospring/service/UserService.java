package br.com.desafiospring.desafiospring.service;

import br.com.desafiospring.desafiospring.exception.UserDoesNotExistingException;
import br.com.desafiospring.desafiospring.model.Client;
import br.com.desafiospring.desafiospring.model.Seller;
import br.com.desafiospring.desafiospring.model.Type;
import br.com.desafiospring.desafiospring.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final String USER_NOTFOUND = "User [%s] of type [%s] not found";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void criaUser() {
        Client client = new Client();
        client.setName("Client1");
        Seller seller = new Seller();
        seller.setName("Seller1");
        userRepository.save(seller);
        userRepository.save(client);
    }

    public ResponseEntity followUser(Integer userId, Integer userIdToFollow) {
        Optional<Client> clientOptional = this.findByIdAndType(userId, Type.CLIENT);
        Optional<Seller> sellerOptional = this.findByIdAndType(userIdToFollow, Type.SELLER);

        Seller seller = sellerOptional.get();
        Client client = clientOptional.get();

        seller.addFollower(client);
        client.addSellers(seller);

        this.userRepository.saveAll(Arrays.asList(seller, client));
        return ResponseEntity.ok().build();
    }



    public ResponseEntity countFollowers(Integer userId, Type type) {
        return null;
    }

    private Optional findByIdAndType(Integer id, Type type) {
        Optional clientOptional = this.userRepository.findByIdAndType(id, type);
        if (clientOptional.isEmpty()) {
            throw new UserDoesNotExistingException(String.format(USER_NOTFOUND, id, type.name()));
        }
        return clientOptional;
    }
}
