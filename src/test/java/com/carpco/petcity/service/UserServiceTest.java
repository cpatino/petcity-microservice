package com.carpco.petcity.service;

import com.carpco.petcity.dao.UserDao;
import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.mapper.UserMapper;
import com.carpco.petcity.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.carpco.petcity.util.TestDtoUtils.USER_DTO_1;
import static com.carpco.petcity.util.TestDtoUtils.USER_DTO_2;
import static com.carpco.petcity.util.TestModelUtils.USER_1;
import static com.carpco.petcity.util.TestModelUtils.USER_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UserServiceTest {
  
  @Mock private UserDao userDao;
  @Mock private UserMapper userMapper;
  private UserService userService;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userService = new UserServiceImpl(userDao, userMapper);
  }
  
  @Test
  public void whenLoginWithRightUserAndPassword_thenReturnUserData() {
    String userName = "xxx";
    String password = "xxx";
    when(userDao.findByEmailAndPassword(userName, password)).thenReturn(USER_1);
    Optional.of(new LoginDto(userName, password))
      .map(userService::login)
      .ifPresent(userDtoResult -> assertEquals(USER_DTO_1, userDtoResult));
  }
  
  @Test
  public void whenLoginWithWrongUserAndPassword_thenThrownException() {
    String userName = "xxx";
    String password = "xxx";
    when(userDao.findByEmailAndPassword(userName, password)).thenReturn(null);
    Optional.of(new LoginDto(userName, password))
      .ifPresent(given -> assertThrows(ResponseStatusException.class, () -> userService.login(given)));
  }
  
  @Test
  public void givenCreate_whenUserDtoIsValid_thenSaveData() {
    when(userMapper.map(USER_DTO_2)).thenReturn(USER_2);
    when(userDao.save(USER_2)).thenReturn(USER_2);
    Optional.of(USER_DTO_2)
      .map(userService::create)
      .ifPresent(userDtoResult -> assertEquals(new UserDto(USER_2), userDtoResult));
  }
}
