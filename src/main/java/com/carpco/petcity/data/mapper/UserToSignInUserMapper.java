package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.data.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToSignInUserMapper implements Mapper<User, SignInUser> {
  
  private final CompanyToVeterinaryMapper companyToVeterinaryMapper;
  
  public UserToSignInUserMapper(CompanyToVeterinaryMapper companyToVeterinaryMapper) {
    this.companyToVeterinaryMapper = companyToVeterinaryMapper;
  }
  
  @Override
  public SignInUser map(User user) {
    return SignInUser.builder()
      .fullName(user.getName() + " " + user.getLastName())
      .email(user.getEmail())
      .veterinary(companyToVeterinaryMapper.map(user.getCompany()))
      .active(user.isEnabled())
      .build();
  }
}
