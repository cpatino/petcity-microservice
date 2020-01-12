package com.carpco.petcity.mapper;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {
  
  private final CompanyMapper companyMapper;
  
  public UserMapper(CompanyMapper companyMapper) {
    this.companyMapper = companyMapper;
  }
  
  @Override
  public User map(UserDto userDto) {
    return User.builder()
      .company(companyMapper.map(userDto.getCompany()))
      .creation(userDto.getCreation())
      .document(userDto.getDocument())
      .email(userDto.getEmail())
      .enabled(userDto.isEnabled())
      .id(userDto.getId())
      .lastName(userDto.getLastName())
      .name(userDto.getName())
      .password(userDto.getPassword())
      .phone(userDto.getPhone())
      .build();
  }
}
