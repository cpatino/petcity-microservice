package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.data.model.User;
import org.springframework.stereotype.Component;

@Component("signUpUserToUser")
public class SignUpUserToUserMapper implements Mapper<User, SignUpUser> {
  
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
