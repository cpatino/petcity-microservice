package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;

import java.util.Set;

public interface VaccineService {
  
  Set<VaccineDto> findVaccines(Veterinary veterinary, boolean enabled);
}
