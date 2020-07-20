package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.data.model.Company;
import org.springframework.stereotype.Component;

@Component("veterinaryToCompany")
public class VeterinaryToCompanyMapper implements  Mapper<Veterinary, Company> {
  @Override
  public Company map(Veterinary veterinary) {
    return Company.builder().name(veterinary.getName()).build();
  }
}
