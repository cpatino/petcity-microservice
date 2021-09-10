package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.Veterinary;
import com.carpco.petcity.infrastructure.database.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class VeterinaryToCompanyMapper implements Mapper<Veterinary, Company> {
  
  @Override
  public Company map(Veterinary veterinary) {
    return Company.builder()
      .id(veterinary.getIdentifier())
      .name(veterinary.getName())
      .paid(veterinary.isPaid())
      .photo(veterinary.getPhoto())
      .build();
  }
}
