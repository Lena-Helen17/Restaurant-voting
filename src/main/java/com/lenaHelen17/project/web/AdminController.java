package com.lenaHelen17.project.web;

import com.lenaHelen17.project.model.Voting;
import com.lenaHelen17.project.repository.RestaurantRepository;
import com.lenaHelen17.project.repository.VotingRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
@AllArgsConstructor
@Slf4j
@Tag(name = "Admin Controller")
public class AdminController {

    private final RestaurantRepository restaurantRepository;
    private final VotingRepository votingRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Voting> getAllVotingByDate() {
        log.info("get {}", "");
        return votingRepository.findByDateVoting(LocalDate.now());
    }

}
