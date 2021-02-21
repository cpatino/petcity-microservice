package com.carpco.petcity.business.gateway;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.SignUpUser;

import java.util.Optional;

public interface UserGateway {
  
  Optional<SignInUser> login(String userName, String password);
  
  SignInUser register(SignUpUser signUpUser);
}
