package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.VaccineDto;
import com.carpco.petcity.gui.dto.Veterinary;
import com.carpco.petcity.infrastructure.database.entity.Company;
import com.carpco.petcity.infrastructure.database.entity.Vaccine;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VaccineDtoToVaccineMapper implements Mapper<VaccineDto, Vaccine> {
  
  private final Mapper<Veterinary, Company> veterinaryToCompany;
  
  public VaccineDtoToVaccineMapper(Mapper<Veterinary, Company> veterinaryToCompany) {
    this.veterinaryToCompany = veterinaryToCompany;
  }
  
  @Override
  public Vaccine map(VaccineDto vaccineDto) {
    return Vaccine.builder()
      .name(vaccineDto.getName())
      .company(veterinaryToCompany.map(vaccineDto.getVeterinary()))
      .enabled(true)
      .creation(LocalDateTime.now())
      .build();
  }
}
