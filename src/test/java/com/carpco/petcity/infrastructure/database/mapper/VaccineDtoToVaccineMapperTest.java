package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.VaccineDto;
import com.carpco.petcity.gui.dto.Veterinary;
import com.carpco.petcity.infrastructure.database.entity.Company;
import com.carpco.petcity.infrastructure.database.entity.Vaccine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.carpco.petcity.util.DataTestDtoUtils.VACCINE_DTO_1;
import static com.carpco.petcity.util.DataTestDtoUtils.VETERINARY_1;
import static com.carpco.petcity.util.DataTestModelUtils.COMPANY_1;
import static com.carpco.petcity.util.DataTestModelUtils.VACCINE_1;
import static org.mockito.Mockito.when;

public class VaccineDtoToVaccineMapperTest {
  
  private Mapper<VaccineDto, Vaccine> vaccineDtoToVaccine;
  @Mock
  private Mapper<Veterinary, Company> veterinaryToCompany;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    vaccineDtoToVaccine = new VaccineDtoToVaccineMapper(veterinaryToCompany);
  }
  
  @Test
  public void whenMap_thenReturnDto() {
    when(veterinaryToCompany.map(VETERINARY_1)).thenReturn(COMPANY_1);
    Assertions.assertThat(vaccineDtoToVaccine.map(VACCINE_DTO_1))
      .isEqualToComparingOnlyGivenFields(VACCINE_1, "name", "company");
  }
}
