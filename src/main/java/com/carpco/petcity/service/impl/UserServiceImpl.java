package com.carpco.petcity.service.impl;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.mapper.UserMapper;
import com.carpco.petcity.repository.UserRepository;
import com.carpco.petcity.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class UserServiceImpl implements UserService {
  
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  
  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }
  
  @Override
  public Optional<UserDto> login(String userName, String password) {
    return userRepository.findByEmailAndPassword(userName, password)
      .map(UserDto::new);
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
