package com.carpco.petcity.util;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.business.dto.Veterinary;

import java.math.BigInteger;

public abstract class DataTestDtoUtils {
  
  private DataTestDtoUtils() {
    super();
  }
  
  public static final Veterinary VETERINARY_1 = Veterinary.builder()
    .identifier(BigInteger.valueOf(1))
    .document("123-456-789")
    .name("name")
    .paid(true)
    .photo("photo")
    .build();
  
  public static final Veterinary VETERINARY_2 = Veterinary.builder()
    .identifier(BigInteger.valueOf(2))
    .document("987-654-321")
    .name("name")
    .paid(true)
    .build();
  
  public static final SignInUser SIGN_IN_USER_1 = SignInUser.builder()
    .veterinary(VETERINARY_1)
    .email("test@test.test")
    .active(true)
    .fullName("name lastName")
    .build();
  
  public static final SignInUser SIGN_IN_USER_2 = SignInUser.builder()
    .veterinary(VETERINARY_2)
    .email("create@test.test")
    .active(true)
    .fullName("create test")
    .build();
  
  public static final SignUpUser SIGN_UP_USER_1 = SignUpUser.builder()
    .veterinary(VETERINARY_1)
    .document("123456")
    .email("test@test.test")
    .name("name")
    .lastName("lastName")
    .password("password")
    .phone("3000000000")
    .build();
}
