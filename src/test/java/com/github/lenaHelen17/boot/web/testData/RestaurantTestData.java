package com.github.lenaHelen17.boot.web.testData;

import com.github.lenaHelen17.boot.model.Restaurant;

public class RestaurantTestData {
    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Restaurant.class, "user");

    public static final int RESTAURANT_ID = 1;


    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT_ID, "Restaurant_First", "Adress_First");
    public static final Restaurant restaurantNew = new Restaurant(RESTAURANT_ID + 1, "Restaurant_Second", "Adress_2");

}
