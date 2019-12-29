package com.carpco.petcity.mapper;

import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<Company, CompanyDto> {
  
  @Override
  public Company toDbo(CompanyDto companyDto) {
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
      .photoBlob(companyDto.getPhotoBlob())
      .build();
  }
  
  @Override
  public CompanyDto toDto(Company company) {
    return CompanyDto.builder()
      .actualCustomId(company.getActualCustomId())
      .creation(company.getCreation())
      .document(company.getDocument())
      .enabled(company.isEnabled())
      .id(company.getId())
      .initialCustomId(company.getInitialCustomId())
      .name(company.getName())
      .paid(company.isPaid())
      .photo(company.getPhoto())
      .photoBlob(company.getPhotoBlob())
      .build();
  }
}
