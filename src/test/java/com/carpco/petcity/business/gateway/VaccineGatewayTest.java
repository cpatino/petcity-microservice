package com.carpco.petcity.business.gateway;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.business.gateway.impl.VaccineGatewayImpl;
import com.carpco.petcity.data.mapper.ListMapper;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.Vaccine;
import com.carpco.petcity.data.repository.VaccineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.carpco.petcity.util.DataTestDtoUtils.*;
import static com.carpco.petcity.util.DataTestModelUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class VaccineGatewayTest {

  @Mock
  private VaccineRepository vaccineRepository;
  @Mock
  private Mapper<Veterinary, Company> companyMapper;
  @Mock
  private ListMapper<Vaccine, VaccineDto> vaccineListMapper;

  private VaccineGateway vaccineGateway;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    vaccineGateway = new VaccineGatewayImpl(vaccineRepository, companyMapper, vaccineListMapper);
  }

  @Test
  public void whenRightCompanyAndEnabled_thenReturnVaccineList() {
    when(vaccineRepository.findAllByCompanyAndEnabled(COMPANY_1, true)).thenReturn(VACCINE_LIST);
    when(companyMapper.map(VETERINARY_1)).thenReturn(COMPANY_1);
    when(vaccineListMapper.map(VACCINE_LIST)).thenReturn(VACCINE_DTO_LIST);
    assertEquals(vaccineGateway.listVaccine(VETERINARY_1,true),VACCINE_DTO_LIST);
  }

}
