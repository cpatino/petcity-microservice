package com.carpco.petcity.gui.view;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.business.service.VaccineService;
import com.carpco.petcity.gui.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class VaccineView {
  
  private static final Logger log = LoggerFactory.getLogger(VaccineView.class);
  
  private final VaccineService vaccineService;
  private final SessionService sessionService;
  
  public VaccineView(VaccineService vaccineService, SessionService sessionService) {
    this.vaccineService = vaccineService;
    this.sessionService = sessionService;
  }
  
  protected Set<VaccineDto> findVaccines() {
    log.info("Checking findVaccines...");
    Veterinary veterinary = sessionService.getSessionUser()
      .map(SignInUser::getVeterinary)
      .orElse(Veterinary.builder().build());
    return vaccineService.find(veterinary, true);
  }
  
  protected VaccineDto save(VaccineDto vaccineDto) {
    log.info("Checking save vaccine...");
    return vaccineService.save(vaccineDto);
  }
}
