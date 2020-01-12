package com.carpco.petcity.mapper;

import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<Company, CompanyDto> {
  
  @Override
  public Company map(CompanyDto companyDto) {
    return Company.builder()
      .actualCustomId(companyDto.getActualCustomId())
      .creation(companyDto.getCreation())
      .document(companyDto.getDocument())
      .enabled(companyDto.isEnabled())
      .id(companyDto.getId())
      .initialCustomId(companyDto.getInitialCustomId())
      .name(companyDto.getName())
      .paid(companyDto.isPaid())
      .photo(companyDto.getPhoto())
      .build();
  }
}
