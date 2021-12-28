package com.lenaHelen17.project.web;

import com.lenaHelen17.project.model.Food;
import com.lenaHelen17.project.repository.MenuRepository;
import com.lenaHelen17.project.util.ValidationUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/menu", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class MenuController {
    private final MenuRepository menuRepository;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Food get(@PathVariable int id) {
        log.info("get {}", id);
        System.out.println("Hello");
        return menuRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(int id) {
        log.info("delete {}", id);
        menuRepository.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Food> getAll(Integer restaurantsId) {
        return menuRepository.findByRestaurantsId(restaurantsId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Food food, @PathVariable int id) {
        log.info("update {} to {}", food, menuRepository.findById(id));
        Food oldFood = menuRepository.findById(id).get();
        ValidationUtil.assureIdConsistent(food, oldFood.id());
        menuRepository.save(food);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Food> createNewFood(@Valid @RequestBody Food food) {
        log.info("newFood {}", food);
        ValidationUtil.checkNew(food);
        menuRepository.save(food);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/menu" + "/{id}")
                .build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(food);
    }
}
