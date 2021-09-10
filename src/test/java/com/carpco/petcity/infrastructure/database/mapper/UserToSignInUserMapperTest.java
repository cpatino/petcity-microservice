package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.SignInUser;
import com.carpco.petcity.gui.dto.Veterinary;
import com.carpco.petcity.infrastructure.database.entity.Company;
import com.carpco.petcity.infrastructure.database.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalTime.MIDNIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserToSignInUserMapperTest {
  
  @Mock
  private CompanyToVeterinaryMapper companyToVeterinaryMapper;
  private UserToSignInUserMapper mapper;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mapper = new UserToSignInUserMapper(companyToVeterinaryMapper);
  }
  
  @Test
  void whenMap_theReturnDAO() {
    when(companyToVeterinaryMapper.map(buildCompany())).thenReturn(buildVeterinary());
    SignInUser signInUser = mapper.map(buildUser());
    assertEquals(buildSignUpUser(), signInUser);
  }
  
  private User buildUser() {
    return User.builder()
      .company(buildCompany())
      .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
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
      .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
      .document("123-456-789")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .initialCustomId(BigInteger.valueOf(1))
      .name("name")
      .paid(true)
      .photo("photo")
      .build();
  }
  
  private SignInUser buildSignUpUser() {
    return SignInUser.builder()
      .veterinary(buildVeterinary())
      .email("test@test.test")
      .active(true)
      .fullName("name lastName")
      .build();
  }
  
  private Veterinary buildVeterinary() {
    return Veterinary.builder()
      .identifier(BigInteger.valueOf(1))
      .name("name")
      .paid(true)
      .photo("photo")
      .build();
  }
}
