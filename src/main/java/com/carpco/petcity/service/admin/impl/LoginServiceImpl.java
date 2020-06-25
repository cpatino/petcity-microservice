package com.carpco.petcity.service.admin.impl;

import com.carpco.petcity.dto.SignUpUser;
import com.carpco.petcity.dto.mapper.UserToSignUpUserMapper;
import com.carpco.petcity.service.SessionService;
import com.carpco.petcity.service.UserService;
import com.carpco.petcity.service.admin.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
  
  private final SessionService sessionService;
  private final UserService userService;
  private final UserToSignUpUserMapper mapper;
  
  public LoginServiceImpl(SessionService sessionService, UserService userService, UserToSignUpUserMapper mapper) {
    this.sessionService = sessionService;
    this.userService = userService;
    this.mapper = mapper;
  }
  
  @Override
  public void registerSessionUser(SignUpUser signUpUser) {
    sessionService.registerSessionUser(signUpUser);
  }
  
  @Override
  public Optional<SignUpUser> login(String userName, String password) {
    return userService.login(userName, password)
      .map(mapper::map);
  }
}
