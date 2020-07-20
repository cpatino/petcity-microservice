package com.carpco.petcity.business.gateway.impl;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.gateway.UserGateway;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.User;
import com.carpco.petcity.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserGatewayImpl implements UserGateway {

  private final UserRepository userRepository;
  @Qualifier("userToSignInUser")
  private final Mapper<User, SignInUser> mapper;

  public UserGatewayImpl(UserRepository userRepository, Mapper<User, SignInUser> mapper) {
    this.userRepository = userRepository;
    this.mapper = mapper;
  }

  @Override
  public Optional<SignInUser> login(String userName, String password) {
    return userRepository.findByEmailAndPassword(userName, password)
        .map(mapper::map);
  }

  @Transactional
  @Override
  public User create(User user) {
    return Optional.of(user)
        .map(userRepository::save)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User cannot be saved, check your data"));
  }
}
