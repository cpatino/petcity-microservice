package com.carpco.petcity.mapper;

import com.carpco.petcity.dto.CompanyDto;
import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.model.Company;
import com.carpco.petcity.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static java.time.LocalTime.MIDNIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {
  
  @Mock private CompanyMapper companyMapper;
  @InjectMocks private UserMapper mapper;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  void toDbo() {
    when(companyMapper.toDbo(buildCompanyDto())).thenReturn(buildCompany());
    User user = mapper.toDbo(buildUserDto());
    assertEquals(buildUser(), user);
  }
  
  @Test
  void toDto() {
    when(companyMapper.toDto(buildCompany())).thenReturn(buildCompanyDto());
    UserDto userDto = mapper.toDto(buildUser());
    assertEquals(buildUserDto(), userDto);
  }
  
  private User buildUser() {
    return User.builder()
      .company(buildCompany())
      .creation(MIDNIGHT)
      .document("123456789")
      .email("test@test.test")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .lastName("lastName")
      .name("name")
      .password("password")
      .phone("987654321")
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
  
  private UserDto buildUserDto() {
    return UserDto.builder()
      .company(buildCompanyDto())
      .creation(MIDNIGHT)
      .document("123456789")
      .email("test@test.test")
      .enabled(true)
      .id(BigInteger.valueOf(1))
      .lastName("lastName")
      .name("name")
      .password("password")
      .phone("987654321")
      .build();
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
}