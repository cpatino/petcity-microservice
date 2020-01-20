package com.carpco.petcity.mapper;

import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.model.Company;
import com.carpco.petcity.model.User;
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

public class UserMapperTest {
  
  @Mock private CompanyMapper companyMapper;
  private UserMapper mapper;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mapper = new UserMapper(companyMapper);
  }
  
  @Test
  void whenMap_theReturnDAO() {
    when(companyMapper.map(buildCompanyDto())).thenReturn(buildCompany());
    User user = mapper.map(buildUserDto());
    assertEquals(buildUser(), user);
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
  
  private UserDto buildUserDto() {
    return UserDto.builder()
      .company(buildCompanyDto())
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
  
  private CompanyDto buildCompanyDto() {
    return CompanyDto.builder()
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
}