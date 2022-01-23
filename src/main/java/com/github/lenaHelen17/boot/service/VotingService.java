package com.github.lenaHelen17.boot.service;

import com.github.lenaHelen17.boot.model.Voting;
import com.github.lenaHelen17.boot.repository.RestaurantRepository;
import com.github.lenaHelen17.boot.repository.UserRepository;
import com.github.lenaHelen17.boot.repository.VotingRepository;
import com.github.lenaHelen17.boot.util.DateTimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@AllArgsConstructor
public class VotingService {
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final VotingRepository votingRepository;

    @Transactional
    public Voting save(Voting voting, int userId, int restaurantId) {
        LocalTime localTime = LocalTime.now();
        if (DateTimeUtil.UserVotingTime(localTime)) {
            if (voting == null) {
                voting = new Voting();
            }
            voting.setUser(userRepository.getById(userId));
            voting.setRestaurant(restaurantRepository.getById(restaurantId));
            voting.setDateVoting(LocalDate.now().toString());
            return votingRepository.save(voting);
        }
        return null;
    }
}
