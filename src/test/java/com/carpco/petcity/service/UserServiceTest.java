package com.carpco.petcity.service;

import com.carpco.petcity.dao.UserDao;
import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.model.Company;
import com.carpco.petcity.model.User;
import com.carpco.petcity.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.Optional;

import static java.time.LocalTime.MIDNIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UserServiceTest {
  
  @Mock private UserDao userDao;
  private UserService userService;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userService = new UserServiceImpl(userDao);
  }
  
  @Test
  public void whenLoginWithRightUserAndPassword_thenReturnUserData() {
    String userName = "xxx";
    String password = "xxx";
    when(userDao.findByEmailAndPassword(userName, password)).thenReturn(buildUser());
    Optional.of(new LoginDto(userName, password))
      .map(userService::login)
      .ifPresent(userDtoResult -> assertEquals(buildUserDto(), userDtoResult));
  }
  
  @Test
  public void whenLoginWithWrongUserAndPassword_thenThrownException() {
    String userName = "xxx";
    String password = "xxx";
    when(userDao.findByEmailAndPassword(userName, password)).thenReturn(null);
    Optional.of(new LoginDto(userName, password))
      .ifPresent(given -> assertThrows(ResponseStatusException.class, () -> userService.login(given)));
  }
  
  private User buildUser() {
    return User.builder()
      .company(buildCompany())
      .creation(MIDNIGHT)
      .document("123456789")
      .email("test@test.test")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .lastName("lastName")
      .name("name")
      .password("password")
      .phone("987654321")
      .build();
  }
  
  private Company buildCompany() {
    return Company.builder()
      .actualCustomId(BigInteger.valueOf(1))
      .creation(MIDNIGHT)
      .document("123-456-789")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .initialCustomId(BigInteger.valueOf(1))
      .name("name")
      .paid(true)
      .photo("photo")
      .build();
  }
  
  private UserDto buildUserDto() {
    return UserDto.builder()
      .company(buildCompanyDto())
      .creation(MIDNIGHT)
      .document("123456789")
      .email("test@test.test")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .lastName("lastName")
      .name("name")
      .password("password")
      .phone("987654321")
      .build();
  }
  
  private CompanyDto buildCompanyDto() {
    return CompanyDto.builder()
      .actualCustomId(BigInteger.valueOf(1))
      .creation(MIDNIGHT)
      .document("123-456-789")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .initialCustomId(BigInteger.valueOf(1))
      .name("name")
      .paid(true)
      .photo("photo")
      .build();
  }
}
