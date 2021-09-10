package com.carpco.petcity.domain.service;

import com.carpco.petcity.gui.dto.VaccineDto;
import com.carpco.petcity.gui.dto.Veterinary;

import java.util.Set;

public interface VaccineService {
  
  Set<VaccineDto> find(Veterinary veterinary, boolean enabled);
  
  VaccineDto save(VaccineDto vaccineDto);
  
  VaccineDto findByName(Veterinary veterinary, String name, boolean enabled);
}
