package com.lenaHelen17.project.repository;

import com.lenaHelen17.project.model.Restaurant;
import com.lenaHelen17.project.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface VotingRepository extends JpaRepository<Voting, Integer> {

    @RestResource(rel = "by-userIdAndDateVoting", path = "by-userIdAndDateVoting")
    Voting findByUserIdAndDateVoting(int userId, LocalDate dateVoting);

    @RestResource(rel = "by-dateVoting", path = "by-dateVoting")
    List<Voting> findByDateVoting(LocalDate dateVoting);
}
