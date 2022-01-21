package com.github.lenaHelen17.boot.repository;

import com.github.lenaHelen17.boot.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Transactional(readOnly = true)
public interface MealRepository extends JpaRepository<Meal, Integer> {

    @Query("SELECT m FROM Meal m WHERE m.dateTime=:dateTime")
    Optional<Meal> getAllByDateTime(LocalDate dateTime);


    @Query("SELECT m FROM Meal m JOIN FETCH m.restaurant WHERE m.id = :id and m.restaurant.id = :restaurantId")
    Optional<Meal> getWithRestaurantId(int id, int restaurantId);
}
