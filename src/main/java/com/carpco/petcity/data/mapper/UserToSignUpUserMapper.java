package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.data.model.User;
import org.springframework.stereotype.Component;

@Component("userToSignUpUser")
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
