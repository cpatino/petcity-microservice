package com.carpco.petcity.mapper;

import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static java.time.LocalTime.MIDNIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyMapperTest {
  
  private CompanyMapper mapper;
  
  @BeforeEach
  public void setup() {
    mapper = new CompanyMapper();
  }
  
  @Test
  void whenMap_theReturnDAO() {
    CompanyDto companyDto = buildCompanyDto();
    Company company = mapper.map(companyDto);
    assertEquals(buildCompany(), company);
  }
  
  private CompanyDto buildCompanyDto() {
    return CompanyDto.builder()
      .actualCustomId(BigInteger.valueOf(1))
      .creation(MIDNIGHT)
      .document("123-456-789")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .initialCustomId(BigInteger.valueOf(1))
      .name("name")
      .paid(true)
      .photo("photo")
      .build();
  }
  
  private Company buildCompany() {
    return Company.builder()
      .actualCustomId(BigInteger.valueOf(1))
      .creation(MIDNIGHT)
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