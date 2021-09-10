package com.carpco.petcity.domain.service;

import com.carpco.petcity.domain.gateway.VaccineGateway;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.carpco.petcity.util.DataTestDtoUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VaccineServiceImplTest {
  
  @Mock
  private VaccineGateway vaccineGateway;
  
  private VaccineService vaccineService;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    vaccineService = new VaccineServiceImpl(vaccineGateway);
  }
  
  @Test
  public void whenVeterinaryWithVaccines_thenReturnVaccines() {
    when(vaccineGateway.find(VETERINARY_1, true))
      .thenReturn(ImmutableSet.of(VACCINE_DTO_1, VACCINE_DTO_2));
    assertEquals(vaccineService.find(VETERINARY_1, true),
      ImmutableSet.of(VACCINE_DTO_1, VACCINE_DTO_2));
  }
  
  @Test
  public void whenRigthNameAndVeterinary_thenSaveVaccine() {
    when(vaccineGateway.save(VACCINE_DTO_1))
      .thenReturn(VACCINE_DTO_1);
    assertEquals(vaccineService.save(VACCINE_DTO_1), VACCINE_DTO_1);
  }
}