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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.LocalTime.MIDNIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VaccineToVaccineDtoMapperTest {

  private VaccineToVaccineDtoMapper vaccineDtoMapper;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    vaccineDtoMapper = new VaccineToVaccineDtoMapper();
  }

  @Test
  public void whenMap_thenReturnDto() {
    assertEquals(vaccineDtoMapper.map(buildVaccineDao()), buildVaccineDto());
  }

  @Test
  public void whenMapList_thenReturnDtoList() {
    assertEquals(vaccineDtoMapper.map(buildVaccineDaoList()), buildVaccineDtoList());
  }

  private VaccineDto buildVaccineDto() {
    return VaccineDto.builder().name("vaccine").build();
  }

  private List<VaccineDto> buildVaccineDtoList() {
    return Stream.of(buildVaccineDto()).
        collect(Collectors.toList());
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

  private List<Vaccine> buildVaccineDaoList() {
    return Stream.of(buildVaccineDao()).
        collect(Collectors.toList());
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
