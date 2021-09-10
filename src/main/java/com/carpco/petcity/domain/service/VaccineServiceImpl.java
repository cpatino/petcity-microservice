package com.carpco.petcity.domain.service;

import com.carpco.petcity.domain.gateway.VaccineGateway;
import com.carpco.petcity.gui.dto.VaccineDto;
import com.carpco.petcity.gui.dto.Veterinary;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class VaccineServiceImpl implements VaccineService {
  
  private final VaccineGateway vaccineGateway;
  
  public VaccineServiceImpl(VaccineGateway vaccineGateway) {
    this.vaccineGateway = vaccineGateway;
  }
  
  @Override
  public Set<VaccineDto> find(Veterinary veterinary, boolean enabled) {
    return vaccineGateway.find(veterinary, enabled);
  }
  
  @Override
  public VaccineDto save(VaccineDto vaccineDto) {
    return vaccineGateway.save(vaccineDto);
  }
  
  @Override
  public VaccineDto findByName(Veterinary veterinary, String name, boolean enabled) {
    return vaccineGateway.findByName(veterinary, name, enabled);
  }
}
