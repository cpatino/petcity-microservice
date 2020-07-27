package com.carpco.petcity.gui.view;

import com.carpco.petcity.gui.service.SessionService;
import com.github.mvysny.kaributesting.v10.MockVaadin;
import com.github.mvysny.kaributesting.v10.Routes;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.carpco.petcity.util.DataTestDtoUtils.*;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VaccineViewTest {
  
  @Autowired
  private SessionService sessionService;
  
  @Autowired
  private VaccineView vaccineView;
  
  public VaccineViewTest() {
  }
  
  @Before
  public void setup() {
    Routes routes = new Routes().autoDiscoverViews("com.carpco.petcity.view");
    MockVaadin.setup(routes);
  }
  
  @Test
  public void givenVeterinary_thenReturnVaccines() {
    sessionService.registerSessionUser(SIGN_UP_USER_1);
    Assertions.assertThat(vaccineView.findVaccines())
      .containsExactlyInAnyOrder(VACCINE_DTO_1, VACCINE_DTO_2);
  }
  
  @Test
  public void givenVeterinaryWithDisabledVaccines_thenReturnEmptyVaccines() {
    sessionService.registerSessionUser(SIGN_UP_USER_2);
    Assertions.assertThat(vaccineView.findVaccines()).isEmpty();
  }
  
  @Test
  public void givenVeterinaryWithoutVaccines_thenReturnEmptyVaccines() {
    sessionService.registerSessionUser(SIGN_UP_USER_3);
    Assertions.assertThat(vaccineView.findVaccines()).isEmpty();
  }
  
  @Test
  public void givenRightNameAndVeterinary_whenSave_thenReturnNewVaccine() {
    sessionService.registerSessionUser(SIGN_UP_USER_1);
    assertEquals(vaccineView.save(VACCINE_DTO_6), VACCINE_DTO_6);
  }
  
  @Test
  public void givenOther_whenSave_thenReturnVaccineUpdated() {
    sessionService.registerSessionUser(SIGN_UP_USER_1);
    assertEquals(vaccineView.save(UPDATED_VACCINE_DTO_2), UPDATED_VACCINE_DTO_2);
  }
}
