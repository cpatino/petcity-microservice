package com.carpco.petcity.data.gateway;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.data.model.User;

import java.util.Optional;

public interface UserGateway {
  
  Optional<SignInUser> login(String userName, String password);
  
  User create(User user);
}
