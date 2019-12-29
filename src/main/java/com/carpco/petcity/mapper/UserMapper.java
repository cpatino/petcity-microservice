package com.carpco.petcity.mapper;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {
  
  @Autowired private CompanyMapper companyMapper;
  
  @Override
  public User toDbo(UserDto userDto) {
    return User.builder()
      .company(companyMapper.toDbo(userDto.getCompany()))
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
  
  @Override
  public UserDto toDto(User user) {
    return UserDto.builder()
      .company(companyMapper.toDto(user.getCompany()))
      .creation(user.getCreation())
      .document(user.getDocument())
      .email(user.getEmail())
      .enabled(user.isEnabled())
      .id(user.getId())
      .lastName(user.getLastName())
      .name(user.getName())
      .password(user.getPassword())
      .phone(user.getPhone())
      .build();
  }
}
