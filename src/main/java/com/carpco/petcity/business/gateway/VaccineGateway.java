package com.carpco.petcity.business.gateway;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface VaccineGateway {

  List<VaccineDto> listVaccine(Veterinary veterinary, boolean enabled);
}
