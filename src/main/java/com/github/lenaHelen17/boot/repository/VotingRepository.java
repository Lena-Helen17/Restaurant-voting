package com.github.lenaHelen17.boot.repository;

import com.github.lenaHelen17.boot.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;




@Transactional(readOnly = true)
public interface VotingRepository extends JpaRepository<Voting, Integer> {

}
