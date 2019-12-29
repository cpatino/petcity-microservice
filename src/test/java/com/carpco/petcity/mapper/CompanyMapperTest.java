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
  void toDbo() {
    CompanyDto companyDto = buildCompanyDto();
    Company company = mapper.toDbo(companyDto);
    assertEquals(buildCompany(), company);
  }
  
  @Test
  void toDto() {
    Company company = buildCompany();
    CompanyDto companyDto = mapper.toDto(company);
    assertEquals(buildCompanyDto(), companyDto);
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
      .photoBlob("photo".getBytes())
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
      .photoBlob("photo".getBytes())
      .build();
  }
}