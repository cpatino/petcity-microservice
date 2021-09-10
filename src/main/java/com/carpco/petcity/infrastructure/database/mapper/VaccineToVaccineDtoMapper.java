package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.VaccineDto;
import com.carpco.petcity.gui.dto.Veterinary;
import com.carpco.petcity.infrastructure.database.entity.Company;
import com.carpco.petcity.infrastructure.database.entity.Vaccine;
import org.springframework.stereotype.Component;

@Component
public class VaccineToVaccineDtoMapper implements Mapper<Vaccine, VaccineDto> {
  
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
