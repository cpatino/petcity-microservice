package com.carpco.petcity.repository.gateway;

import com.carpco.petcity.repository.model.User;

import java.util.Optional;

public interface UserGateway {
  
  Optional<User> login(String userName, String password);
  
  User create(User user);
}
