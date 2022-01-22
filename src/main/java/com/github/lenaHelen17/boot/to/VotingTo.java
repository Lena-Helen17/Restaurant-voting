package com.github.lenaHelen17.boot.to;

import io.swagger.v3.oas.annotations.media.Schema;


public class VotingTo {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected Integer restaurantId;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public VotingTo(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
