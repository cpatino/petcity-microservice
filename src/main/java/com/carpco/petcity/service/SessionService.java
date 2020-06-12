package com.carpco.petcity.service;

import com.carpco.petcity.dto.UserDto;

import java.util.Optional;

public interface SessionService {
  
  Optional<UserDto> getSessionUser();
  
  void registerSessionUser(UserDto userDto);
}
