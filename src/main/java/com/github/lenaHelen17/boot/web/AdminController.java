package com.github.lenaHelen17.boot.web;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin")
@AllArgsConstructor
@Slf4j
@Tag(name = "Admin Controller")
public class AdminController {


}
