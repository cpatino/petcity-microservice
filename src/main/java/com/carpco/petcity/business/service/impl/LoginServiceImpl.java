package com.carpco.petcity.business.service.impl;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.business.service.LoginService;
import com.carpco.petcity.repository.gateway.UserGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
  
  private final UserGateway userGateway;
  
  public LoginServiceImpl(UserGateway userGateway) {
    this.userGateway = userGateway;
  }
  
  @Override
  public Optional<SignUpUser> login(String userName, String password) {
    return userGateway.login(userName, password);
  }
}
