package com.lenaHelen17.project.web;

import com.lenaHelen17.project.repository.RestaurantRepository;
import com.lenaHelen17.project.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin")
@AllArgsConstructor
@Slf4j
@Tag(name = "Admin Controller")
public class AdminController {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;


}
