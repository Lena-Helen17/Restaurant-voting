package com.github.lenaHelen17.boot.web;

import com.github.lenaHelen17.boot.model.Voting;
import com.github.lenaHelen17.boot.repository.VotingRepository;
import com.github.lenaHelen17.boot.util.DateTimeUtil;
import com.github.lenaHelen17.boot.util.JsonUtil;
import com.github.lenaHelen17.boot.web.testData.RestaurantTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.NestedServletException;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.github.lenaHelen17.boot.web.testData.UserTestData.USER_ID;
import static com.github.lenaHelen17.boot.web.testData.UserTestData.USER_MAIL;
import static com.github.lenaHelen17.boot.web.testData.VotingTestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VotingControllerTest extends AbstractControllerTest {

    private static final String REST_URL = VotingController.REST_URL;

    @Autowired
    private VotingRepository votingRepository;

    @Test
    @WithUserDetails(value = USER_MAIL)
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTING_MATCHER.contentJson(voting1));
    }

    @Test
    void getUnauth() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void getNotFound() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + USER_ID))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    @WithUserDetails(value = USER_MAIL)
    void create() throws Exception {
        Voting newVoting = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .param("restaurantId", String.valueOf(RestaurantTestData.RESTAURANT_ID + 1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newVoting)));

        Voting created = VOTING_MATCHER.readFromJson(action);
        int newId = created.id();
        newVoting.setId(newId);
        if (DateTimeUtil.UserVotingTime(LocalTime.now())) {
            VOTING_MATCHER.assertMatch(created, newVoting);
            VOTING_MATCHER.assertMatch(votingRepository.getById(newId), newVoting);
        } else {
            org.assertj.core.api.Assertions.assertThatThrownBy( () ->
                    perform(MockMvcRequestBuilders.post(REST_URL))
                            .andExpect(status().isOk()))
                            .hasCause(new NestedServletException("Access is denied"));
        }
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void update() throws Exception {
        Voting updated = getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL)
                .param("restaurantId", String.valueOf(RestaurantTestData.RESTAURANT_ID + 1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        if (DateTimeUtil.UserVotingTime(LocalTime.now())) {
            VOTING_MATCHER.assertMatch(votingRepository.getById(VOTING1_ID), updated);
        } else {
            voting1.setDateVoting(votingRepository.getById(VOTING1_ID).getDateVoting());
            VOTING_MATCHER.assertMatch(votingRepository.getById(VOTING1_ID), voting1);
        }
    }

}