package com.github.lenaHelen17.boot.web;

import com.github.lenaHelen17.boot.AuthUser;
import com.github.lenaHelen17.boot.model.Voting;
import com.github.lenaHelen17.boot.repository.VotingRepository;
import com.github.lenaHelen17.boot.service.VotingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping(value = VotingController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class VotingController {
    static final String REST_URL = "/api/user/voting";

    private final VotingService service;
    private final VotingRepository repository;

    @GetMapping()
    public ResponseEntity<Voting> get(@AuthenticationPrincipal AuthUser authUser) {
        log.info("get voting {} for user {}", authUser.id());
        return ResponseEntity.of(repository.get(authUser.id()));
    }

    @PostMapping()
    public ResponseEntity<Voting> create(@AuthenticationPrincipal AuthUser authUser, @RequestParam @Nullable Integer restaurantId) {
        int userId = authUser.id();
        log.info("create {} for user {}", restaurantId, userId);
        Voting created = service.save(null, userId, restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL)
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@AuthenticationPrincipal AuthUser authUser, @RequestParam @Nullable Integer restaurantId) {
        int userId = authUser.id();
        Voting voting = repository.get(userId).get();
        log.info("update {} for user {}", voting, userId);
        service.save(voting, userId, restaurantId);
    }

}
