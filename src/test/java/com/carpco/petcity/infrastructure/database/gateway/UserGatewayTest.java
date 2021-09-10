package com.carpco.petcity.infrastructure.database.gateway;

import com.carpco.petcity.domain.gateway.UserGateway;
import com.carpco.petcity.gui.dto.SignInUser;
import com.carpco.petcity.gui.dto.SignUpUser;
import com.carpco.petcity.infrastructure.database.entity.User;
import com.carpco.petcity.infrastructure.database.mapper.Mapper;
import com.carpco.petcity.infrastructure.database.repository.UserRepository;
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

class UserGatewayTest {
  
  @Mock private UserRepository userRepository;
  @Mock private Mapper<User, SignInUser> userToSignInUserMapper;
  @Mock private Mapper<SignUpUser, User> signUpUserUserMapper;
  private UserGateway userGateway;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userGateway = new UserGatewayImpl(userRepository, userToSignInUserMapper, signUpUserUserMapper);
  }
  
  @Test
  void whenLoginWithRightUserAndPassword_thenReturnUserData() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.of(USER_1));
    when(userToSignInUserMapper.map(USER_1)).thenReturn(SIGN_IN_USER_1);
    userGateway.login(userName, password)
      .ifPresent(signUpUser -> assertEquals(SIGN_IN_USER_1, signUpUser));
  }
  
  @Test
  void whenLoginWithWrongUserAndPassword_thenReturnEmpty() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.empty());
    assertEquals(Optional.empty(), userGateway.login(userName, password));
  }
  
  @Test
  void givenCreate_whenUserDtoIsValid_thenSaveData() {
    when(signUpUserUserMapper.map(SIGN_UP_USER_1)).thenReturn(USER_2);
    when(userRepository.save(USER_2)).thenReturn(USER_2);
    when(userToSignInUserMapper.map(USER_2)).thenReturn(SIGN_IN_USER_2);
    Optional.of(SIGN_UP_USER_1)
      .map(userGateway::register)
      .ifPresent(userDtoResult -> assertEquals(SIGN_IN_USER_2, userDtoResult));
  }
}
