package com.carpco.petcity.business.service.impl;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.business.gateway.VaccineGateway;
import com.carpco.petcity.business.service.VaccineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

  private final VaccineGateway vaccineGateway;

  public VaccineServiceImpl(VaccineGateway vaccineGateway) {
    this.vaccineGateway = vaccineGateway;
  }

  @Override
  public List<VaccineDto> listVaccine(Veterinary veterinary, boolean isEnabled) {
    return vaccineGateway.listVaccine(veterinary, isEnabled);
  }
}
