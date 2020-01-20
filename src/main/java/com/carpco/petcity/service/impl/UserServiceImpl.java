package com.carpco.petcity.service.impl;

import com.carpco.petcity.dao.UserDao;
import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.mapper.UserMapper;
import com.carpco.petcity.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {
  
  private final UserDao userDao;
  private final UserMapper userMapper;
  
  public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
    this.userDao = userDao;
    this.userMapper = userMapper;
  }
  
  @Override
  public UserDto login(LoginDto login) {
    return Optional.of(login)
      .map(given -> userDao.findByEmailAndPassword(given.getEmail(), given.getPassword()))
      .map(UserDto::new)
      .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Email or password does not match any valid user"));
  }
  
  @Transactional
  @Override
  public UserDto create(UserDto userDto) {
    return Optional.of(userDto)
      .map(userMapper::map)
      .map(userDao::save)
      .map(UserDto::new)
      .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "User cannot be saved, check your data"));
  }
}
