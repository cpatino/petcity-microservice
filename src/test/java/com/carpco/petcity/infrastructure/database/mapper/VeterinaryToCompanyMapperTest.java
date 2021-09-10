package com.carpco.petcity.infrastructure.database.mapper;

import com.carpco.petcity.gui.dto.Veterinary;
import com.carpco.petcity.infrastructure.database.entity.Company;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.carpco.petcity.util.DataTestDtoUtils.VETERINARY_1;
import static com.carpco.petcity.util.DataTestModelUtils.COMPANY_1;

public class VeterinaryToCompanyMapperTest {
  
  private Mapper<Veterinary, Company> mapper;
  
  @BeforeEach
  public void setup() {
    mapper = new VeterinaryToCompanyMapper();
  }
  
  @Test
  void whenMapDto_theReturnDao() {
    Assertions.assertThat(mapper.map(VETERINARY_1))
      .isEqualToComparingOnlyGivenFields(COMPANY_1,
        "id", "name", "paid", "photo");
  }
}
