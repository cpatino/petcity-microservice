package com.carpco.petcity.data.gateway;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.gateway.VaccineGateway;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.Vaccine;
import com.carpco.petcity.data.repository.VaccineRepository;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Streamable;

import java.math.BigInteger;
import java.util.Collections;

import static com.carpco.petcity.util.DataTestDtoUtils.*;
import static com.carpco.petcity.util.DataTestModelUtils.VACCINE_1;
import static com.carpco.petcity.util.DataTestModelUtils.VACCINE_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VaccineGatewayTest {
  
  @Mock
  private VaccineRepository vaccineRepository;
  @Mock
  private Mapper<Vaccine, VaccineDto> vaccineToVaccineDto;
  @Mock
  private Mapper<VaccineDto, Vaccine> vaccineDtoToVaccine;
  private VaccineGateway vaccineGateway;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    vaccineGateway = new VaccineGatewayImpl(vaccineRepository, vaccineToVaccineDto, vaccineDtoToVaccine);
  }
  
  @Test
  public void whenCompanyWithVaccines_thenReturnVaccines() {
    when(vaccineRepository.findAllByCompanyIdAndEnabled(BigInteger.valueOf(1), true)).
      thenReturn(Streamable.of(VACCINE_1, VACCINE_2));
    when(vaccineToVaccineDto.map(VACCINE_1)).thenReturn(VACCINE_DTO_1);
    when(vaccineToVaccineDto.map(VACCINE_2)).thenReturn(VACCINE_DTO_2);
    assertEquals(vaccineGateway.findVaccines(VETERINARY_1, true),
      ImmutableSet.of(VACCINE_DTO_1, VACCINE_DTO_2));
  }
  
  @Test
  public void whenCompanyWithoutVaccines_thenReturnEmptyVaccines() {
    when(vaccineRepository.findAllByCompanyIdAndEnabled(BigInteger.valueOf(1), true))
      .thenReturn(Streamable.empty());
    when(vaccineToVaccineDto.map(VACCINE_1)).thenReturn(VACCINE_DTO_1);
    assertEquals(vaccineGateway.findVaccines(VETERINARY_1, true), Collections.EMPTY_SET);
  }
  
  @Test
  public void whenRightNameAndCompany_thenSaveVaccine() {
    when(vaccineRepository.save(VACCINE_1)).thenReturn(VACCINE_1);
    when(vaccineToVaccineDto.map(VACCINE_1)).thenReturn(VACCINE_DTO_1);
    when(vaccineDtoToVaccine.map(VACCINE_DTO_1)).thenReturn(VACCINE_1);
    assertEquals(vaccineGateway.save(VACCINE_DTO_1), VACCINE_DTO_1);
  }
}
