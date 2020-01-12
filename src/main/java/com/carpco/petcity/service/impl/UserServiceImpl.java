package com.carpco.petcity.service.impl;

import com.carpco.petcity.dao.UserDao;
import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {
  
  private final UserDao userDao;
  
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }
  
  @Override
  public UserDto login(LoginDto login) {
    return Optional.of(login)
      .map(given -> userDao.findByEmailAndPassword(given.getEmail(), given.getPassword()))
      .map(UserDto::new)
      .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Email or password does not match any valid user"));
  }
}
