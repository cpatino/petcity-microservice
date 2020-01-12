package com.carpco.petcity.controller;

import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.model.Company;
import com.carpco.petcity.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.Optional;

import static java.time.LocalTime.MIDNIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserControllerTest {
  
  @Autowired private UserController userController;
  
  @Test
  public void whenLoginWithAKnownUser_thenReturnUserData() {
    Optional.of(new LoginDto("test@test.test", "password"))
      .map(userController::login)
      .ifPresent(userDtoResult -> {
        assertThat(userDtoResult).isEqualToIgnoringGivenFields(buildUser(), "creation", "company");
        assertThat(userDtoResult.getCompany()).isEqualToIgnoringGivenFields(buildCompany(), "creation");
      });
  }
  
  @Test
  public void whenLoginWithInvalidCredentials_thenThrowException() {
    Optional.of(new LoginDto("test@test.test", "xxx"))
      .ifPresent(given -> assertThrows(ResponseStatusException.class, () -> userController.login(given)));
  }
  
  private User buildUser() {
    return User.builder()
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
      .actualCustomId(BigInteger.valueOf(11))
      .creation(MIDNIGHT)
      .document("123-456-789")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .initialCustomId(BigInteger.valueOf(10))
      .name("name")
      .paid(true)
      .photo("photo")
      .build();
  }
}