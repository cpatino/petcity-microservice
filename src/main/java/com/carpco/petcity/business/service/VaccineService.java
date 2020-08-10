package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Set;

@Validated
public interface VaccineService {
  
  Set<VaccineDto> find(Veterinary veterinary, boolean enabled);
  
  VaccineDto save(@Valid VaccineDto vaccineDto);
  
  VaccineDto findByName(Veterinary veterinary, String name, boolean enabled);
}
