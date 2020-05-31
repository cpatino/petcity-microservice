package com.carpco.petcity.service.impl;

import com.carpco.petcity.repository.UserRepository;
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
  
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  
  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }
  
  @Override
  public UserDto login(LoginDto login) {
    return userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
      .map(UserDto::new)
      .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Email or password does not match any valid user"));
  }
  
  @Transactional
  @Override
  public UserDto create(UserDto userDto) {
    return Optional.of(userDto)
      .map(userMapper::map)
      .map(userRepository::save)
      .map(UserDto::new)
      .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "User cannot be saved, check your data"));
  }
}
