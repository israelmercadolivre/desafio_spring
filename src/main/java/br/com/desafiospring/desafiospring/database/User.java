package br.com.desafiospring.desafiospring.database;

import br.com.desafiospring.desafiospring.model.user.Client;
import br.com.desafiospring.desafiospring.model.user.Seller;
import br.com.desafiospring.desafiospring.repository.user.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class User implements ApplicationRunner {
    private UserRepository userRepository;

    public User(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private void createClient() {
        Client client1 = new Client();
        client1.setName("Client1");
        Client client2 = new Client();
        client2.setName("Client2");
        Client client3 = new Client();
        client3.setName("Client3");

        userRepository.saveAll(Arrays.asList(client1,client2,client3));
    }

    private void createSeller(){
        Seller seller1 = new Seller();
        seller1.setName("Seller1");
        Seller seller2 = new Seller();
        seller2.setName("Seller2");
        Seller seller3 = new Seller();
        seller3.setName("Seller3");
        userRepository.saveAll(Arrays.asList(seller1,seller2,seller3));
    }

    @Override
    public void run(ApplicationArguments args) {
        this.createClient();
        this.createSeller();
    }
}
