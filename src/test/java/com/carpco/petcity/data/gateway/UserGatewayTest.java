package com.carpco.petcity.data.gateway;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.gateway.UserGateway;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.User;
import com.carpco.petcity.data.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.carpco.petcity.util.DataTestDtoUtils.SIGN_UP_USER_1;
import static com.carpco.petcity.util.DataTestModelUtils.USER_1;
import static com.carpco.petcity.util.DataTestModelUtils.USER_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserGatewayTest {
  
  @Mock
  private UserRepository userRepository;
  @Mock
  private Mapper<User, SignInUser> mapper;
  private UserGateway userGateway;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userGateway = new UserGatewayImpl(userRepository, mapper);
  }
  
  @Test
  public void whenLoginWithRightUserAndPassword_thenReturnUserData() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.of(USER_1));
    when(mapper.map(USER_1)).thenReturn(SIGN_UP_USER_1);
    userGateway.login(userName, password)
      .ifPresent(signUpUser -> assertEquals(SIGN_UP_USER_1, signUpUser));
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
    when(userRepository.save(USER_2)).thenReturn(USER_2);
    Optional.of(USER_2)
      .map(userGateway::create)
      .ifPresent(userDtoResult -> assertEquals(USER_2, userDtoResult));
  }
}
