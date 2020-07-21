package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.Vaccine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalTime.MIDNIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VaccineToVaccineDtoMapperTest {
  
  private VaccineToVaccineDtoMapper vaccineToVaccineDto;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    vaccineToVaccineDto = new VaccineToVaccineDtoMapper();
  }
  
  @Test
  public void whenMap_thenReturnDto() {
    assertEquals(vaccineToVaccineDto.map(buildVaccineDao()), buildVaccineDto());
  }
  
  private VaccineDto buildVaccineDto() {
    return VaccineDto.builder()
      .name("vaccine")
      .build();
  }
  
  private Vaccine buildVaccineDao() {
    return Vaccine.builder()
      .id(BigInteger.valueOf(1))
      .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
      .enabled(true)
      .name("vaccine")
      .company(buildCompany())
      .build();
  }
  
  private Company buildCompany() {
    return Company.builder()
      .actualCustomId(BigInteger.valueOf(1))
      .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
      .document("123-456-789")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .initialCustomId(BigInteger.valueOf(1))
      .name("name")
      .paid(true)
      .photo("photo")
      .build();
  }
}
