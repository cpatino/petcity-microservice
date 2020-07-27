package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.Vaccine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("vaccineDtoToVaccine")
public class VaccineDtoToVaccineMapper implements Mapper<VaccineDto, Vaccine> {
  
  @Qualifier("veterinaryToComponent")
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
