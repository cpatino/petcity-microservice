package com.carpco.petcity.service.impl;

import com.carpco.petcity.dto.SignUpUser;
import com.carpco.petcity.dto.mapper.UserToSignUpUserMapper;
import com.carpco.petcity.repository.service.UserService;
import com.carpco.petcity.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
  
  private final UserService userService;
  private final UserToSignUpUserMapper mapper;
  
  public LoginServiceImpl(UserService userService, UserToSignUpUserMapper mapper) {
    this.userService = userService;
    this.mapper = mapper;
  }
  
  @Override
  public Optional<SignUpUser> login(String userName, String password) {
    return userService.login(userName, password)
      .map(mapper::map);
  }
}
