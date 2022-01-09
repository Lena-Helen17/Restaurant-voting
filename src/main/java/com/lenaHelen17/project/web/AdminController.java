package com.lenaHelen17.project.web;

import com.lenaHelen17.project.model.Restaurant;
import com.lenaHelen17.project.model.Voting;
import com.lenaHelen17.project.repository.RestaurantRepository;
import com.lenaHelen17.project.repository.VotingRepository;
import com.lenaHelen17.project.util.DateTimeUtil;
import com.lenaHelen17.project.util.VotingLogiс;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
@AllArgsConstructor
@Slf4j
@Tag(name = "Admin Controller")
public class AdminController {

    @Autowired
    private final RestaurantRepository restaurantRepository;
    private final VotingRepository votingRepository;

    @GetMapping("/votings")
    public List<Voting> getAllVotingByDate( @PathVariable String localDate) {
        log.info("get {}", "");
        return votingRepository.findByDateVoting(localDate);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant getWinnersRestaurant() {
        log.info("get {}", "");
        List<Voting> votingList = votingRepository.findByDateVoting(LocalDate.now().format(DateTimeUtil.DATE_FORMATTER));
        int winnerRestaurantId = VotingLogiс.getWinnersRestaurants(votingList);
        return restaurantRepository.getOne(winnerRestaurantId);
    }
}
