package com.lenaHelen17.project.repository;

import com.lenaHelen17.project.model.Food;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Tag(name = "Menu Controller")
@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Food, Integer> {

    @RestResource(rel = "by-restaurantsId", path = "by-restaurantsId")
    List<Food> findByRestaurantsId(Integer restaurantsId);
}
