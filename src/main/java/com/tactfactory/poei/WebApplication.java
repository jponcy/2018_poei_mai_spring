package com.tactfactory.poei;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tactfactory.poei.entity.Book;
import com.tactfactory.poei.entity.User;
import com.tactfactory.poei.repository.UserRepository;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(Arrays.asList(
            this.createUser("jonathan", "poncy", "jpjpjpjpjp"),
            this.createUser("mickael", "gaillard"),
            this.createUser("antoine", "cronier")
        ));
    }
    
    private User createUser(String firstname, String lastname) {
        return this.createUser(firstname, lastname, null);
    }
    
    private User createUser(String firstname, String lastname, String password) {
        User result = new User();
        
        result.setUsername(firstname + "." + lastname);
        result.setFirstname(firstname);
        result.setLastname(lastname);
        result.setEmail(result.getUsername() + "@tactfactory.com");
        
        if (password == null) {
            result.setPassword("" + System.currentTimeMillis());
        } else {
            result.setPassword(password);
        }
        
        return result;
    }
}
