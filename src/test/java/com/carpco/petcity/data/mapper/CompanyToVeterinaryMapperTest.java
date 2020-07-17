package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.Veterinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.carpco.petcity.util.DataTestDtoUtils.VETERINARY_1;
import static com.carpco.petcity.util.DataTestModelUtils.COMPANY_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyToVeterinaryMapperTest {
  
  private CompanyToVeterinaryMapper mapper;
  
  @BeforeEach
  public void setup() {
    mapper = new CompanyToVeterinaryMapper();
  }
  
  @Test
  void whenMap_theReturnDAO() {
    Veterinary veterinary = mapper.map(COMPANY_1);
    assertEquals(VETERINARY_1, veterinary);
  }
}