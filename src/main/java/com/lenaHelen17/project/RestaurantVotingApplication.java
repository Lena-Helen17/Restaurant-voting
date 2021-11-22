package com.lenaHelen17.project;

import com.lenaHelen17.project.model.Role;
import com.lenaHelen17.project.model.User;
import com.lenaHelen17.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {
    private  final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(userRepository.findAll());
    }
}
