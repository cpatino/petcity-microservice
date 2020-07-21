package com.carpco.petcity.business.gateway;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;

import java.util.Set;

public interface VaccineGateway {
  
  Set<VaccineDto> findVaccines(Veterinary veterinary, boolean enabled);
}
