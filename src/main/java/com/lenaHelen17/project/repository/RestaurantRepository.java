package com.lenaHelen17.project.repository;

import com.lenaHelen17.project.model.Restaurant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping(value = "/api/admin")
@Tag(name = "Restaurant Controller")
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @RestResource(rel = "by-dateMenu", path = "by-dateMenu")
    List<Restaurant> findByDateMenu(LocalDate dateMenu);
}

