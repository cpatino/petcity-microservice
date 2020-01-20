package com.carpco.petcity.service;

import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.dto.UserDto;

public interface UserService {
  
  UserDto login(LoginDto login);
  
  UserDto create(UserDto userDto);
}
