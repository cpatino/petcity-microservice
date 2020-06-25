package com.carpco.petcity.dto.mapper;

import com.carpco.petcity.dto.Veterinary;
import com.carpco.petcity.repository.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyToVeterinaryMapper implements Mapper<Veterinary, Company> {
  
  @Override
  public Veterinary map(Company company) {
    return Veterinary.builder()
      .identifier(company.getId())
      .name(company.getName())
      .paid(company.isPaid())
      .photo(company.getPhoto())
      .build();
  }
}
