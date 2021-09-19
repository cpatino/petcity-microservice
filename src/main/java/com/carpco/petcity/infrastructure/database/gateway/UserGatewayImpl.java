package com.carpco.petcity.infrastructure.database.gateway;

import com.carpco.petcity.gui.dto.SignInUser;
import com.carpco.petcity.gui.dto.SignUpUser;
import com.carpco.petcity.gui.gateway.UserGateway;
import com.carpco.petcity.infrastructure.database.entity.User;
import com.carpco.petcity.infrastructure.database.mapper.Mapper;
import com.carpco.petcity.infrastructure.database.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
class UserGatewayImpl implements UserGateway {
  
  private final UserRepository userRepository;
  private final Mapper<User, SignInUser> userToSignInUser;
  private final Mapper<SignUpUser, User> signUpUserToUser;
  
  public UserGatewayImpl(UserRepository userRepository, Mapper<User, SignInUser> userToSignInUser,
                         Mapper<SignUpUser, User> signUpUserToUser) {
    this.userRepository = userRepository;
    this.userToSignInUser = userToSignInUser;
    this.signUpUserToUser = signUpUserToUser;
  }
  
  @Override
  public Optional<SignInUser> login(String userName, String password) {
    return userRepository.findByEmailAndPassword(userName, password)
      .map(userToSignInUser::map);
  }
  
  @Transactional
  @Override
  public SignInUser register(SignUpUser signUpUser) {
    return Optional.of(signUpUser)
      .map(signUpUserToUser::map)
      .map(userRepository::save)
      .map(userToSignInUser::map)
      .orElseThrow(() -> new RuntimeException("Something wrong happen when trying to save the user, try again later"));
  }
}
