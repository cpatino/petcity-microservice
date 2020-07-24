package com.carpco.petcity.util;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;

import java.math.BigInteger;

public abstract class DataTestDtoUtils {
  
  private DataTestDtoUtils() {
    super();
  }
  
  public static final Veterinary VETERINARY_1 = Veterinary.builder()
    .identifier(BigInteger.valueOf(1))
    .name("veterinary1")
    .paid(true)
    .photo("photo")
    .build();
  
  public static final Veterinary VETERINARY_2 = Veterinary.builder()
    .identifier(BigInteger.valueOf(2))
    .name("veterinary2")
    .paid(true)
    .build();
  
  public static final Veterinary VETERINARY_3 = Veterinary.builder()
    .identifier(BigInteger.valueOf(3))
    .name("veterinary3")
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
  
  public static final SignInUser SIGN_UP_USER_3 = SignInUser.builder()
    .veterinary(VETERINARY_3)
    .email("create@test.test")
    .active(true)
    .fullName("create test")
    .build();
  
  public static final VaccineDto VACCINE_DTO_1 =
    VaccineDto.builder().name("vaccine1").veterinary(VETERINARY_1).build();
  
  public static final VaccineDto VACCINE_DTO_2 =
    VaccineDto.builder().name("vaccine2").veterinary(VETERINARY_1).build();
  
  public static final VaccineDto VACCINE_DTO_3 =
    VaccineDto.builder().name("vaccine3").veterinary(VETERINARY_1).build();
  
  public static final VaccineDto VACCINE_DTO_4 =
    VaccineDto.builder().name("vaccine4").veterinary(VETERINARY_2).build();
  
  public static final VaccineDto VACCINE_DTO_5 =
    VaccineDto.builder().name("vaccine5").veterinary(VETERINARY_2).build();
  
  public static final VaccineDto VACCINE_DTO_6 =
    VaccineDto.builder().name("vaccine6").veterinary(VETERINARY_1).build();
  
  public static final VaccineDto UPDATED_VACCINE_DTO_2 =
    VaccineDto.builder(VACCINE_DTO_2).name("vaccine2Updated").build();
  
  
}
