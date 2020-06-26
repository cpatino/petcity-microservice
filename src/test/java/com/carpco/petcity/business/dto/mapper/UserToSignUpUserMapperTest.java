package com.carpco.petcity.business.dto.mapper;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.repository.model.Company;
import com.carpco.petcity.repository.model.User;
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

public class UserToSignUpUserMapperTest {
  
  @Mock private CompanyToVeterinaryMapper companyToVeterinaryMapper;
  private UserToSignUpUserMapper mapper;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mapper = new UserToSignUpUserMapper(companyToVeterinaryMapper);
  }
  
  @Test
  void whenMap_theReturnDAO() {
    when(companyToVeterinaryMapper.map(buildCompany())).thenReturn(buildVeterinary());
    SignUpUser signUpUser = mapper.map(buildUser());
    assertEquals(buildSignUpUser(), signUpUser);
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
  
  private SignUpUser buildSignUpUser() {
    return SignUpUser.builder()
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