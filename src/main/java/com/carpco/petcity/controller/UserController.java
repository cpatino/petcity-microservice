package com.carpco.petcity.controller;

import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/user")
@Validated
public class UserController {
  
  private static final Logger log = LoggerFactory.getLogger(UserController.class);
  private final UserService userService;
  
  public UserController(UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping(value = "/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public UserDto login(@RequestBody @Valid LoginDto login) {
    log.info("Checking login...");
    return userService.login(login);
  }
  
  @PostMapping(value = {"", "/"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public UserDto create(@RequestBody @Valid UserDto userDto) {
    log.info("Trying to save a new user information");
    return userService.create(userDto);
  }
}
