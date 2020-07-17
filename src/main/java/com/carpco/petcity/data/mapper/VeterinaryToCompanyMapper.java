package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.data.model.Company;
import org.springframework.stereotype.Component;

@Component("veterinaryToCompany")
public class VeterinaryToCompanyMapper implements Mapper<Company, Veterinary> {
  
  @Override
  public Company map(Veterinary veterinary) {
    return Company.builder()
      .id(veterinary.getIdentifier())
      .document(veterinary.getDocument())
      .name(veterinary.getName())
      .paid(veterinary.isPaid())
      .photo(veterinary.getPhoto())
      .build();
  }
}
