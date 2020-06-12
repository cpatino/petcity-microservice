package com.carpco.petcity.service.admin;

import com.carpco.petcity.dto.UserDto;

import java.util.Optional;

public interface LoginService {
  
  void registerSessionUser(UserDto userDto);
  
  Optional<UserDto> login(String userName, String password);
}
