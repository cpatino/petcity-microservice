package com.carpco.petcity.util;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.business.dto.Veterinary;

import java.math.BigInteger;

public abstract class TestDtoUtils {
  
  private TestDtoUtils() {
    super();
  }
  
  public static final Veterinary VETERINARY_1 = Veterinary.builder()
    .identifier(BigInteger.valueOf(1))
    .name("name")
    .paid(true)
    .photo("photo")
    .build();
  
  public static final Veterinary VETERINARY_2 = Veterinary.builder()
    .identifier(BigInteger.valueOf(2))
    .name("name")
    .paid(true)
    .build();
  
  public static final SignUpUser SIGN_UP_USER_1 = SignUpUser.builder()
    .veterinary(VETERINARY_1)
    .email("test@test.test")
    .active(true)
    .fullName("name lastName")
    .build();
  
  public static final SignUpUser SIGN_UP_USER_2 = SignUpUser.builder()
    .veterinary(VETERINARY_2)
    .email("create@test.test")
    .active(true)
    .fullName("create test")
    .build();
}
