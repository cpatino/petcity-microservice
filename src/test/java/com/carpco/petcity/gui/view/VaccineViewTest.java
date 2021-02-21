package com.carpco.petcity.gui.view;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.service.VaccineService;
import com.carpco.petcity.gui.service.SessionService;
import com.github.mvysny.kaributesting.v10.MockVaadin;
import com.github.mvysny.kaributesting.v10.Routes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static com.carpco.petcity.util.DataTestDtoUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VaccineViewTest {
  
  @Autowired private SessionService sessionService;
  @Autowired private VaccineView vaccineView;
  @Autowired private VaccineService vaccineService;
  
  @Before
  public void setup() {
    Routes routes = new Routes().autoDiscoverViews("com.carpco.petcity.view");
    MockVaadin.setup(routes);
  }
  
  @Test
  public void givenVeterinary_thenReturnVaccines() {
    sessionService.registerSessionUser(SIGN_IN_USER_1);
    assertThat(vaccineView.findVaccines())
      .containsAnyOf(VACCINE_DTO_1, VACCINE_DTO_2, VACCINE_DTO_6);
  }
  
  @Test
  public void givenVeterinaryWithDisabledVaccines_thenReturnEmptyVaccines() {
    sessionService.registerSessionUser(SIGN_IN_USER_2);
    assertThat(vaccineView.findVaccines()).isEmpty();
  }
  
  @Test
  public void givenVeterinaryWithoutVaccines_thenReturnEmptyVaccines() {
    sessionService.registerSessionUser(SIGN_IN_USER_3);
    assertThat(vaccineView.findVaccines()).isEmpty();
  }
  
  @Test
  public void givenRightNameAndVeterinary_whenSave_thenReturnNewVaccine() {
    sessionService.registerSessionUser(SIGN_IN_USER_1);
    assertThat(vaccineView.save(VACCINE_DTO_6)).isEqualTo(VACCINE_DTO_6);
  }
  
  @Test
  public void givenEmptyVaccine_whenSave_thenReturnConstraintViolationException() {
    sessionService.registerSessionUser(SIGN_IN_USER_1);
    VaccineDto vaccine = VaccineDto.builder().build();
    try {
      vaccineView.save(vaccine);
      fail("Constraint violation expected.");
    } catch (ConstraintViolationException ignored) {
    }
  }
  
  @Test
  public void givenOtherName_whenSave_thenReturnVaccineUpdated() {
    sessionService.registerSessionUser(SIGN_IN_USER_1);
    String newName = "vaccine2Updated";
    VaccineDto vaccine = VaccineDto.builder(VACCINE_DTO_2)
      .name(newName)
      .build();
    assertThat(vaccineView.save(vaccine).getName()).isEqualTo(newName);
  }
}
