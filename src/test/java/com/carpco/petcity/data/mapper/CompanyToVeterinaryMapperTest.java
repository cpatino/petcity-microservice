package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.data.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.carpco.petcity.util.DataTestDtoUtils.VETERINARY_1;
import static com.carpco.petcity.util.DataTestModelUtils.COMPANY_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyToVeterinaryMapperTest {
  
  private Mapper<Company, Veterinary> mapper;
  
  @BeforeEach
  public void setup() {
    mapper = new CompanyToVeterinaryMapper();
  }
  
  @Test
  void whenMapDao_theReturnDto() {
    assertEquals(mapper.map(COMPANY_1), VETERINARY_1);
  }
}
