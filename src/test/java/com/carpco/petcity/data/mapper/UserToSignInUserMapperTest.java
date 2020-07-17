package com.carpco.petcity.data.mapper;

import com.carpco.petcity.business.dto.SignInUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.carpco.petcity.util.DataTestDtoUtils.SIGN_IN_USER_1;
import static com.carpco.petcity.util.DataTestDtoUtils.VETERINARY_1;
import static com.carpco.petcity.util.DataTestModelUtils.COMPANY_1;
import static com.carpco.petcity.util.DataTestModelUtils.USER_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserToSignInUserMapperTest {
  
  @Mock private CompanyToVeterinaryMapper companyToVeterinaryMapper;
  private UserToSignInUserMapper mapper;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mapper = new UserToSignInUserMapper(companyToVeterinaryMapper);
  }
  
  @Test
  void whenMap_theReturnDAO() {
    when(companyToVeterinaryMapper.map(COMPANY_1)).thenReturn(VETERINARY_1);
    SignInUser signInUser = mapper.map(USER_1);
    assertEquals(SIGN_IN_USER_1, signInUser);
  }
}