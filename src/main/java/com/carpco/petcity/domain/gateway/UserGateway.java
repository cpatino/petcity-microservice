package com.carpco.petcity.domain.gateway;

import com.carpco.petcity.gui.dto.SignInUser;
import com.carpco.petcity.gui.dto.SignUpUser;

import java.util.Optional;

public interface UserGateway {
  
  Optional<SignInUser> login(String userName, String password);
  
  SignInUser register(SignUpUser signUpUser);
}
