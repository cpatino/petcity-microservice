package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.SignUpUser;
import com.carpco.petcity.infrastructure.database.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SignUpUserToUserMapper implements Mapper<SignUpUser, User> {
  
  private final VeterinaryToCompanyMapper veterinaryToCompany;
  
  public SignUpUserToUserMapper(VeterinaryToCompanyMapper veterinaryToCompany) {
    this.veterinaryToCompany = veterinaryToCompany;
  }
  
  @Override
  public User map(SignUpUser signUpUser) {
    return User.builder()
      .company(veterinaryToCompany.map(signUpUser.getVeterinary()))
      .document(signUpUser.getDocument())
      .email(signUpUser.getEmail())
      .name(signUpUser.getName())
      .lastName(signUpUser.getLastName())
      .password(signUpUser.getPassword())
      .phone(signUpUser.getPhone())
      .build();
  }
}
