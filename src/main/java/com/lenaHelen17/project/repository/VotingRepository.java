package com.lenaHelen17.project.repository;

import com.lenaHelen17.project.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface VotingRepository extends JpaRepository<Voting, Integer> {

}
