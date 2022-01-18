package com.github.lenaHelen17.boot.web;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user/voting")
@AllArgsConstructor
@Slf4j
@Tag(name = "User Account Controller")
public class UserAccountController {

}
