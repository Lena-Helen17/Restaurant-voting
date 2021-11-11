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
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("user@gmail.com", "User_First", "UserName_First", "First_Password", Set.of(Role.ROLE_USER)));
        userRepository.save(new User("admin@gmail.com", "Admin_First", "adminName_First", "Admin_Password", Set.of(Role.ROLE_USER, Role.ROLE_ADMIN)));
        System.out.println(userRepository.findAll());
    }
}
