package com.carpco.petcity.repository.gateway.impl;

import com.carpco.petcity.repository.UserRepository;
import com.carpco.petcity.repository.gateway.UserGateway;
import com.carpco.petcity.repository.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserGatewayImpl implements UserGateway {
  
  private final UserRepository userRepository;
  
  public UserGatewayImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @Override
  public Optional<User> login(String userName, String password) {
    return userRepository.findByEmailAndPassword(userName, password);
  }
  
  @Transactional
  @Override
  public User create(User user) {
    return Optional.of(user)
      .map(userRepository::save)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User cannot be saved, check your data"));
  }
}
