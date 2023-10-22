package com.paichato.userapi;

import com.paichato.userapi.domain.User;
import com.paichato.userapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    userRepository.saveAll(List.of(new User(null,"Marlon", "umemail@mail.com", "123",20.0)));
    }
}
