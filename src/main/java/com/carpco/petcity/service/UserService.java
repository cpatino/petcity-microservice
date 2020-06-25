package com.carpco.petcity.service;

import com.carpco.petcity.repository.model.User;

import java.util.Optional;

public interface UserService {
  
  Optional<User> login(String userName, String password);
  
  User create(User user);
}
