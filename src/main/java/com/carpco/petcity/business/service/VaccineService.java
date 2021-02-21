package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;

import java.util.Set;

public interface VaccineService {
  
  Set<VaccineDto> find(Veterinary veterinary, boolean enabled);
  
  VaccineDto save(VaccineDto vaccineDto);
  
  VaccineDto findByName(Veterinary veterinary, String name, boolean enabled);
}
