package com.github.lenaHelen17.boot.web;

import com.github.lenaHelen17.boot.model.Meal;
import com.github.lenaHelen17.boot.repository.MealRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/admin/meals", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class MealController {

    private final MealRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Meal> get(@PathVariable int id) {
        log.info("get meal {} ", id);
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete meal {} ", id);
        repository.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<Meal> getAll(@RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate localDate) {
        log.info("getAll meal {} ", localDate);
        return ResponseEntity.of(repository.getAllByDateTime(localDate));
    }

}
