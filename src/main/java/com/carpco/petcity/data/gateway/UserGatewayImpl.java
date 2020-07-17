package com.carpco.petcity.data.gateway;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.business.gateway.UserGateway;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.User;
import com.carpco.petcity.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
class UserGatewayImpl implements UserGateway {
  
  private final UserRepository userRepository;
  @Qualifier("userToSignInUser")
  private final Mapper<SignInUser, User> userToSignInUser;
  @Qualifier("signUpUserToUser")
  private final Mapper<User, SignUpUser> signUpUserToUser;
  
  public UserGatewayImpl(UserRepository userRepository, Mapper<SignInUser, User> userToSignInUser,
                         Mapper<User, SignUpUser> signUpUserToUser) {
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
