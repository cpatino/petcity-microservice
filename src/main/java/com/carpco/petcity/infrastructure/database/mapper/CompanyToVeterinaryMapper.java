package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.Veterinary;
import com.carpco.petcity.infrastructure.database.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyToVeterinaryMapper implements Mapper<Company, Veterinary> {
  
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
