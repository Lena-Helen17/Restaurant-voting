package com.lenaHelen17.project.repository;

import com.lenaHelen17.project.model.Restaurant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/admin")
@Tag(name = "Restaurant Controller")
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
