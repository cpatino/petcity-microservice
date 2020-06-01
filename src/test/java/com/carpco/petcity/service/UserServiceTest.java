package com.carpco.petcity.service;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.mapper.UserMapper;
import com.carpco.petcity.repository.UserRepository;
import com.carpco.petcity.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.carpco.petcity.util.TestDtoUtils.USER_DTO_1;
import static com.carpco.petcity.util.TestDtoUtils.USER_DTO_2;
import static com.carpco.petcity.util.TestModelUtils.USER_1;
import static com.carpco.petcity.util.TestModelUtils.USER_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {
  
  @Mock private UserRepository userRepository;
  @Mock private UserMapper userMapper;
  private UserService userService;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userService = new UserServiceImpl(userRepository, userMapper);
  }
  
  @Test
  public void whenLoginWithRightUserAndPassword_thenReturnUserData() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.of(USER_1));
    userService.login(userName, password)
      .ifPresent(userDtoResult -> assertEquals(USER_DTO_1, userDtoResult));
  }
  
  @Test
  public void whenLoginWithWrongUserAndPassword_thenReturnEmpty() {
    String userName = "xxx";
    String password = "xxx";
    when(userRepository.findByEmailAndPassword(userName, password)).thenReturn(Optional.empty());
    assertEquals(Optional.empty(), userService.login(userName, password));
  }
  
  @Test
  public void givenCreate_whenUserDtoIsValid_thenSaveData() {
    when(userMapper.map(USER_DTO_2)).thenReturn(USER_2);
    when(userRepository.save(USER_2)).thenReturn(USER_2);
    Optional.of(USER_DTO_2)
      .map(userService::create)
      .ifPresent(userDtoResult -> assertEquals(new UserDto(USER_2), userDtoResult));
  }
}
