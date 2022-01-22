package com.github.lenaHelen17.boot.web.testData;

import com.github.lenaHelen17.boot.model.Voting;

import java.util.List;

public class VotingTestData {
    public static final MatcherFactory.Matcher<Voting> VOTING_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Voting.class, "user");

    public static final int VOTING1_ID = 1;


    public static final Voting voting1 = new Voting(VOTING1_ID, UserTestData.userTest, RestaurantTestData.restaurant1);
    public static final Voting voting2 = new Voting(VOTING1_ID + 1, UserTestData.adminTest, RestaurantTestData.restaurantNew);

    public static final List<Voting> votings = List.of(voting1,voting2);

    public static Voting getNew() {
        return new Voting(null,  UserTestData.userTest, RestaurantTestData.restaurantNew);
    }

    public static Voting getUpdated() {
        return new Voting(VOTING1_ID, UserTestData.userTest, RestaurantTestData.restaurantNew);
    }
}
