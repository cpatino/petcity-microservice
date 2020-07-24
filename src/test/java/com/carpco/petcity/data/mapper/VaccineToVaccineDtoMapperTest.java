package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.Vaccine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.carpco.petcity.util.DataTestDtoUtils.VACCINE_DTO_1;
import static com.carpco.petcity.util.DataTestDtoUtils.VETERINARY_1;
import static com.carpco.petcity.util.DataTestModelUtils.COMPANY_1;
import static com.carpco.petcity.util.DataTestModelUtils.VACCINE_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VaccineToVaccineDtoMapperTest {
  
  private Mapper<Vaccine, VaccineDto> vaccineToVaccineDto;
  @Mock
  private Mapper<Company, Veterinary> companyToVeterinary;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    vaccineToVaccineDto = new VaccineToVaccineDtoMapper(companyToVeterinary);
  }
  
  @Test
  public void whenMap_thenReturnDto() {
    when(companyToVeterinary.map(COMPANY_1)).thenReturn(VETERINARY_1);
    assertEquals(vaccineToVaccineDto.map(VACCINE_1), VACCINE_DTO_1);
  }
}
