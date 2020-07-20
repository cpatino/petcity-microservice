package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;

import java.util.List;


public interface VaccineService {

  List<VaccineDto> listVaccine(Veterinary veterinary, boolean isEnabled);
}
