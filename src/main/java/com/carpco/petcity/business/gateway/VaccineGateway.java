package com.carpco.petcity.business.gateway;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;

import java.util.Set;

public interface VaccineGateway {
  
  Set<VaccineDto> find(Veterinary veterinary, boolean enabled);
  
  VaccineDto save(VaccineDto vaccine);
  
  VaccineDto findByName(Veterinary veterinary, String name, boolean enabled);
}
