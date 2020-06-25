package com.carpco.petcity.dto.mapper;

import com.carpco.petcity.dto.Veterinary;
import com.carpco.petcity.repository.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalTime.MIDNIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyToVeterinaryMapperTest {
  
  private CompanyToVeterinaryMapper mapper;
  
  @BeforeEach
  public void setup() {
    mapper = new CompanyToVeterinaryMapper();
  }
  
  @Test
  void whenMap_theReturnDAO() {
    Veterinary veterinary = mapper.map(buildCompany());
    assertEquals(buildVeterinary(), veterinary);
  }
  
  private Veterinary buildVeterinary() {
    return Veterinary.builder()
      .identifier(BigInteger.valueOf(1))
      .name("name")
      .paid(true)
      .photo("photo")
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