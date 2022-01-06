package com.lenaHelen17.project.web;

import com.lenaHelen17.project.AuthUser;
import com.lenaHelen17.project.model.Restaurant;
import com.lenaHelen17.project.model.User;
import com.lenaHelen17.project.model.Voting;
import com.lenaHelen17.project.repository.RestaurantRepository;
import com.lenaHelen17.project.repository.UserRepository;
import com.lenaHelen17.project.repository.VotingRepository;
import com.lenaHelen17.project.util.DateTimeUtil;
import com.lenaHelen17.project.util.ValidationUtil;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user/voting")
@AllArgsConstructor
@Slf4j
@Tag(name = "User Account Controller")
public class UserAccountController {
    private final RestaurantRepository restaurantRepository;
    private final VotingRepository votingRepository;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAllRestarants() {
        log.info("get {}", "");
        return restaurantRepository.findByDateMenu(DateTimeUtil.UserVotingTime(LocalDateTime.now()));
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveVoting(@RequestBody int id, @AuthenticationPrincipal AuthUser authUser) {
        Voting voting = new Voting(authUser.getUser(), restaurantRepository.findById(id).get(), DateTimeUtil.UserVotingTime(LocalDateTime.now()));
        log.info("register {}", voting);
        Voting buferVoting = votingRepository.findByUserIdAndDateVoting(voting.getUser().id(), voting.getDateVoting());
        if (buferVoting == null) {
            ValidationUtil.checkNew(voting);
            votingRepository.save(voting);
        } else {
            voting.setId(buferVoting.getId());
            votingRepository.save(voting);
        }
    }
}
