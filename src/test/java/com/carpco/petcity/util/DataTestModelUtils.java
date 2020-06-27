package com.carpco.petcity.util;

import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.User;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalTime.MIDNIGHT;

public class DataTestModelUtils {
  
  private DataTestModelUtils() {
    super();
  }
  
  public static final Company COMPANY_1 = Company.builder()
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
  
  public static final Company COMPANY_2 = Company.builder()
    .actualCustomId(BigInteger.valueOf(1))
    .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
    .document("456-123-789")
    .enabled(true)
    .id(BigInteger.valueOf(2))
    .name("name")
    .paid(true)
    .build();
  
  public static final User USER_1 = User.builder()
    .company(COMPANY_1)
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
  
  public static final User USER_2 = User.builder()
    .company(COMPANY_2)
    .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
    .document("987654321")
    .email("create@test.test")
    .enabled(true)
    .id(BigInteger.valueOf(2))
    .lastName("test")
    .name("create")
    .password("password")
    .phone("600000000")
    .build();
}
