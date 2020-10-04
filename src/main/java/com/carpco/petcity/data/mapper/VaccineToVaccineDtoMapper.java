package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.Vaccine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vaccineToVaccineDto")
public class VaccineToVaccineDtoMapper implements Mapper<Vaccine, VaccineDto> {
  
  @Qualifier("companyToVeterinary")
  private final Mapper<Company, Veterinary> companyToVeterinary;
  
  public VaccineToVaccineDtoMapper(Mapper<Company, Veterinary> companyToVeterinary) {
    this.companyToVeterinary = companyToVeterinary;
  }
  
  @Override
  public VaccineDto map(Vaccine vaccine) {
    return VaccineDto.builder()
      .name(vaccine.getName())
      .veterinary(companyToVeterinary.map(vaccine.getCompany()))
      .build();
  }
}
