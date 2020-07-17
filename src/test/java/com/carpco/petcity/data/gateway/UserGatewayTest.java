package com.carpco.petcity.data.gateway;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.business.gateway.UserGateway;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.User;
import com.carpco.petcity.data.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.carpco.petcity.util.DataTestDtoUtils.*;
import static com.carpco.petcity.util.DataTestModelUtils.USER_1;
import static com.carpco.petcity.util.DataTestModelUtils.USER_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserGatewayTest {
  
  @Mock private UserRepository userRepository;
  @Mock private Mapper<SignInUser, User> userToSignInUser;
  @Mock private Mapper<User, SignUpUser> signUpUserToUser;
  private UserGateway userGateway;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userGateway = new UserGatewayImpl(userRepository, userToSignInUser, signUpUserToUser);
  }
  
  @Test
  public void whenLoginWithRightUserAndPassword_thenReturnUserData() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.of(USER_1));
    when(userToSignInUser.map(USER_1)).thenReturn(SIGN_IN_USER_1);
    userGateway.login(userName, password)
      .ifPresent(signUpUser -> assertEquals(SIGN_IN_USER_1, signUpUser));
  }
  
  @Test
  public void whenLoginWithWrongUserAndPassword_thenReturnEmpty() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.empty());
    assertEquals(Optional.empty(), userGateway.login(userName, password));
  }
  
  @Test
  public void givenCreate_whenUserDtoIsValid_thenSaveData() {
    when(signUpUserToUser.map(SIGN_UP_USER_1)).thenReturn(USER_2);
    when(userRepository.save(USER_2)).thenReturn(USER_2);
    when(userToSignInUser.map(USER_2)).thenReturn(SIGN_IN_USER_2);
    Optional.of(SIGN_UP_USER_1)
      .map(userGateway::register)
      .ifPresent(userDtoResult -> assertEquals(SIGN_IN_USER_2, userDtoResult));
  }
}
