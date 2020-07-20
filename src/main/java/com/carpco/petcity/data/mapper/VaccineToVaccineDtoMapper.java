package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.data.model.Vaccine;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("vaccineToVaccineDto")
public class VaccineToVaccineDtoMapper implements Mapper<Vaccine, VaccineDto>, ListMapper<Vaccine, VaccineDto> {

  @Override
  public VaccineDto map(Vaccine vaccine) {
    return VaccineDto.builder().name(vaccine.getName()).build();
  }

  @Override
  public List<VaccineDto> map(List<Vaccine> vaccineList) {
    List<VaccineDto> vaccineDtoList = new ArrayList<VaccineDto>();

    for (Vaccine vaccine : vaccineList) {
      VaccineDto vaccineDto = map(vaccine);
      vaccineDtoList.add(vaccineDto);
    }

    return vaccineDtoList;
  }
}
