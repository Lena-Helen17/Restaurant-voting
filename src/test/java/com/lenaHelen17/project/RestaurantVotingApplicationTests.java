package com.lenaHelen17.project;

import com.lenaHelen17.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestaurantVotingApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    void contextLoads() {
    }

    @Test
    void findAllUsers() {
        System.out.println(userRepository.findAll());
    }
}
