package com.carpco.petcity.dto.mapper;

import com.carpco.petcity.dto.SignUpUser;
import com.carpco.petcity.repository.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToSignUpUserMapper implements Mapper<SignUpUser, User> {
  
  private final CompanyToVeterinaryMapper companyToVeterinaryMapper;
  
  public UserToSignUpUserMapper(CompanyToVeterinaryMapper companyToVeterinaryMapper) {
    this.companyToVeterinaryMapper = companyToVeterinaryMapper;
  }
  
  @Override
  public SignUpUser map(User user) {
    return SignUpUser.builder()
      .fullName(user.getName() + " " + user.getLastName())
      .email(user.getEmail())
      .veterinary(companyToVeterinaryMapper.map(user.getCompany()))
      .active(user.isEnabled())
      .build();
  }
}
