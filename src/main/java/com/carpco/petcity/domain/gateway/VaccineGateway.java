package com.carpco.petcity.domain.gateway;

import com.carpco.petcity.gui.dto.VaccineDto;
import com.carpco.petcity.gui.dto.Veterinary;

import java.util.Set;

public interface VaccineGateway {
  
  Set<VaccineDto> find(Veterinary veterinary, boolean enabled);
  
  VaccineDto save(VaccineDto vaccine);
  
  VaccineDto findByName(Veterinary veterinary, String name, boolean enabled);
}
