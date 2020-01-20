package com.carpco.petcity.util;

import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.dto.UserDto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalTime.MIDNIGHT;

public class TestDtoUtils {
  
  private TestDtoUtils() {
    super();
  }
  
  public static final CompanyDto COMPANY_DTO_1 = CompanyDto.builder()
    .actualCustomId(BigInteger.valueOf(11))
    .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
    .document("123-456-789")
    .enabled(true)
    .id(BigInteger.valueOf(1))
    .initialCustomId(BigInteger.valueOf(10))
    .name("name")
    .paid(true)
    .photo("photo")
    .build();
  
  public static final CompanyDto COMPANY_DTO_2 = CompanyDto.builder()
    .actualCustomId(BigInteger.valueOf(1))
    .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
    .document("456-123-789")
    .enabled(true)
    .name("name")
    .paid(true)
    .build();
  
  public static final UserDto USER_DTO_1 = UserDto.builder()
    .company(COMPANY_DTO_1)
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
  
  public static final UserDto USER_DTO_2 = UserDto.builder()
    .company(COMPANY_DTO_2)
    .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
    .document("987654321")
    .email("create@test.test")
    .enabled(true)
    .lastName("test")
    .name("create")
    .password("password")
    .phone("600000000")
    .build();
}
