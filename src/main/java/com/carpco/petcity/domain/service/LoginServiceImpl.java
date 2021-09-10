package com.carpco.petcity.domain.service;

import com.carpco.petcity.domain.gateway.UserGateway;
import com.carpco.petcity.gui.dto.SignInUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class LoginServiceImpl implements LoginService {
  
  private final UserGateway userGateway;
  
  public LoginServiceImpl(UserGateway userGateway) {
    this.userGateway = userGateway;
  }
  
  @Override
  public Optional<SignInUser> login(String userName, String password) {
    return userGateway.login(userName, password);
  }
}
