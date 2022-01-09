package com.lenaHelen17.project.util;

import com.lenaHelen17.project.model.Voting;

import java.util.*;

public class VotingLogiс {

    public static int getWinnersRestaurants(List<Voting> votingList) {
        if (votingList.isEmpty()) {
            return -1;
        }
        HashMap<Integer, Integer> mapCount = new HashMap<>();
       for (int i=0; i < votingList.size(); i++) {
           Voting voting = votingList.get(i);
           Integer keyMap = voting.getRestaurant().getId();
           Integer valueMap;
           try {
               valueMap = mapCount.get(keyMap) + 1;
           } catch (NullPointerException e) {
               valueMap = 1;
           }
           mapCount.put(keyMap,valueMap);
       }
       Integer winnerRestaurant = Collections.max(mapCount.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return winnerRestaurant;
    }

}
