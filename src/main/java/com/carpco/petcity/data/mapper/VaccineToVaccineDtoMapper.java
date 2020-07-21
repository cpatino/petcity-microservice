package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.data.model.Vaccine;
import org.springframework.stereotype.Component;

@Component("vaccineToVaccineDto")
public class VaccineToVaccineDtoMapper implements Mapper<Vaccine, VaccineDto> {
  
  @Override
  public VaccineDto map(Vaccine vaccine) {
    return VaccineDto.builder()
      .name(vaccine.getName())
      .build();
  }
}
