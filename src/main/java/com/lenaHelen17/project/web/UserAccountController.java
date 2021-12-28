package com.lenaHelen17.project.web;

import com.lenaHelen17.project.model.Restaurant;
import com.lenaHelen17.project.model.Voting;
import com.lenaHelen17.project.repository.RestaurantRepository;
import com.lenaHelen17.project.repository.VotingRepository;
import com.lenaHelen17.project.util.DateTimeUtil;
import com.lenaHelen17.project.util.ValidationUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/account/voting")
@AllArgsConstructor
@Slf4j
@Tag(name = "User Account Controller")
public class UserAccountController {
    private final RestaurantRepository restaurantRepository;
    private final VotingRepository votingRepository;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        log.info("get {}", "");
        return restaurantRepository.findByDateMenu(DateTimeUtil.UserVotingTime(LocalDateTime.now()));
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@RequestBody Voting voting) {
        log.info("register {}", voting);
        ValidationUtil.checkNew(voting);
        votingRepository.save(voting);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Voting voting) {
        log.info("update {} to {}", votingRepository.findById(voting.id()), voting);
        ValidationUtil.assureIdConsistent(voting, voting.id());
        votingRepository.save(voting);
    }
}
