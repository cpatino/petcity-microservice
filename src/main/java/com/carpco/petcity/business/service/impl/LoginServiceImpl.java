package com.carpco.petcity.business.service.impl;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.gateway.UserGateway;
import com.carpco.petcity.business.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
  
  private final UserGateway userGateway;
  
  public LoginServiceImpl(UserGateway userGateway) {
    this.userGateway = userGateway;
  }
  
  @Override
  public Optional<SignInUser> login(String userName, String password) {
    return userGateway.login(userName, password);
  }
}
