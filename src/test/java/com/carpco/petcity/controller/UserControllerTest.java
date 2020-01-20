package com.carpco.petcity.controller;

import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.dto.LoginDto;
import com.carpco.petcity.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.carpco.petcity.util.TestDtoUtils.*;
import static com.carpco.petcity.util.TestModelUtils.COMPANY_2;
import static com.carpco.petcity.util.TestModelUtils.USER_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserControllerTest {
  
  private final UserController userController;
  
  @Autowired
  public UserControllerTest(UserController userController) {
    this.userController = userController;
  }
  
  @Test
  public void whenLoginWithAKnownUser_thenReturnUserData() {
    Optional.of(new LoginDto("test@test.test", "password"))
      .map(userController::login)
      .ifPresent(userDtoResult -> {
        assertThat(userDtoResult).isEqualToIgnoringGivenFields(USER_DTO_1, "creation", "company");
        assertThat(userDtoResult.getCompany()).isEqualToIgnoringGivenFields(COMPANY_DTO_1, "creation");
      });
  }
  
  @Test
  public void whenLoginWithInvalidCredentials_thenThrowException() {
    Optional.of(new LoginDto("test@test.test", "xxx"))
      .ifPresent(given -> assertThrows(ResponseStatusException.class, () -> userController.login(given)));
  }
  
  @Test
  public void givenCreate_whenCallWithUserDto_thenCreateNewUser() {
    Optional.of(USER_DTO_2)
      .map(userController::create)
      .ifPresent(userDtoResult -> {
        assertThat(userDtoResult).isEqualToIgnoringGivenFields(new UserDto(USER_2), "creation", "company");
        assertThat(userDtoResult.getCompany()).isEqualToIgnoringGivenFields(new CompanyDto(COMPANY_2), "creation");
      });
  }
}