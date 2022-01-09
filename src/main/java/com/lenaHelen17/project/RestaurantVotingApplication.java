package com.lenaHelen17.project;

import com.lenaHelen17.project.util.DateTimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication  {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }
}
