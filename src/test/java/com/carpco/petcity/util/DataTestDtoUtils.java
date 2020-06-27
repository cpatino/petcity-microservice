package com.carpco.petcity.util;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.Veterinary;

import java.math.BigInteger;

public abstract class DataTestDtoUtils {
  
  private DataTestDtoUtils() {
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
  
  public static final SignInUser SIGN_UP_USER_1 = SignInUser.builder()
    .veterinary(VETERINARY_1)
    .email("test@test.test")
    .active(true)
    .fullName("name lastName")
    .build();
  
  public static final SignInUser SIGN_UP_USER_2 = SignInUser.builder()
    .veterinary(VETERINARY_2)
    .email("create@test.test")
    .active(true)
    .fullName("create test")
    .build();
}
