package com.carpco.petcity.service.admin.impl;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.service.SessionService;
import com.carpco.petcity.service.UserService;
import com.carpco.petcity.service.admin.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
  
  private final transient SessionService sessionService;
  private final transient UserService userService;
  
  public LoginServiceImpl(SessionService sessionService, UserService userService) {
    this.sessionService = sessionService;
    this.userService = userService;
  }
  
  @Override
  public void registerSessionUser(UserDto userDto) {
    sessionService.registerSessionUser(userDto);
  }
  
  @Override
  public Optional<UserDto> login(String userName, String password) {
    return userService.login(userName, password);
  }
}
