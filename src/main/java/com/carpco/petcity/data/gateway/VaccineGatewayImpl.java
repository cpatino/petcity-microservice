package com.carpco.petcity.data.gateway;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.business.gateway.VaccineGateway;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.Vaccine;
import com.carpco.petcity.data.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class VaccineGatewayImpl implements VaccineGateway {
  
  private final VaccineRepository vaccineRepository;
  
  @Qualifier("vaccineToVaccineDto")
  private final Mapper<Vaccine, VaccineDto> vaccineToVaccineDto;
  @Qualifier("vaccineDtoToVaccine")
  private final Mapper<VaccineDto, Vaccine> vaccineDtoToVaccine;
  
  public VaccineGatewayImpl(VaccineRepository vaccineRepository, Mapper<Vaccine, VaccineDto> vaccineToVaccineDto, Mapper<VaccineDto, Vaccine> vaccineDtoToVaccine) {
    this.vaccineRepository = vaccineRepository;
    this.vaccineToVaccineDto = vaccineToVaccineDto;
    this.vaccineDtoToVaccine = vaccineDtoToVaccine;
  }
  
  @Override
  public Set<VaccineDto> find(Veterinary veterinary, boolean enabled) {
    return vaccineRepository.findAllByCompanyIdAndEnabled(veterinary.getIdentifier(), enabled).stream()
      .map(vaccineToVaccineDto::map)
      .collect(Collectors.toSet());
  }
  
  @Override
  public VaccineDto save(VaccineDto vaccineDto) {
    return Optional.of(vaccineDto)
      .map(vaccineDtoToVaccine::map)
      .map(vaccineRepository::save)
      .map(vaccineToVaccineDto::map)
      .orElseThrow(RuntimeException::new);
  }
  
  @Override
  public VaccineDto findByName(Veterinary veterinary, String name, boolean enabled) {
    return Optional.of(vaccineRepository
      .findByCompanyIdAndNameAndEnabled(veterinary.getIdentifier(), name, enabled))
      .map(vaccineToVaccineDto::map)
      .orElseThrow(RuntimeException::new);
  }
}
