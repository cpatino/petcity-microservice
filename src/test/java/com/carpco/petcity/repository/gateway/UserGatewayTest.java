package com.carpco.petcity.repository.gateway;

import com.carpco.petcity.repository.UserRepository;
import com.carpco.petcity.repository.gateway.impl.UserGatewayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.carpco.petcity.util.TestModelUtils.USER_1;
import static com.carpco.petcity.util.TestModelUtils.USER_2;
import static org.mockito.Mockito.when;

public class UserGatewayTest {
  
  @Mock private UserRepository userRepository;
  private UserGateway userGateway;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userGateway = new UserGatewayImpl(userRepository);
  }
  
  @Test
  public void whenLoginWithRightUserAndPassword_thenReturnUserData() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.of(USER_1));
    userGateway.login(userName, password)
      .ifPresent(userDtoResult -> Assertions.assertEquals(USER_1, userDtoResult));
  }
  
  @Test
  public void whenLoginWithWrongUserAndPassword_thenReturnEmpty() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.empty());
    Assertions.assertEquals(Optional.empty(), userGateway.login(userName, password));
  }
  
  @Test
  public void givenCreate_whenUserDtoIsValid_thenSaveData() {
    when(userRepository.save(USER_2)).thenReturn(USER_2);
    Optional.of(USER_2)
      .map(userGateway::create)
      .ifPresent(userDtoResult -> Assertions.assertEquals(USER_2, userDtoResult));
  }
}
