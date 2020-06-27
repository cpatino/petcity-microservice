package com.carpco.petcity.data.gateway;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.data.model.User;

import java.util.Optional;

public interface UserGateway {
  
  Optional<SignUpUser> login(String userName, String password);
  
  User create(User user);
}
