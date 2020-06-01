package com.carpco.petcity.service;

import com.carpco.petcity.dto.UserDto;

import java.util.Optional;

public interface UserService {
  
  Optional<UserDto> login(String userName, String password);
  
  UserDto create(UserDto userDto);
}
