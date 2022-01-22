package com.github.lenaHelen17.boot.repository;

import com.github.lenaHelen17.boot.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface VotingRepository extends JpaRepository<Voting, Integer> {

    @Query("SELECT m FROM Voting m WHERE m.user.id = :userId")
    Optional<Voting> get(int userId);

    @Query("SELECT m FROM Voting m WHERE m.user.id = :id and m.dateVoting = :localDate")
    Optional<Voting> getByUserIdAndDateVoting(int id, LocalDate localDate);

}
