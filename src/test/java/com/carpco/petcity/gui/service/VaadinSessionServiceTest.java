package com.carpco.petcity.gui.service;

import com.carpco.petcity.gui.vaadin.VaadinSessionManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.carpco.petcity.util.DataTestDtoUtils.SIGN_IN_USER_1;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = VaadinSessionService.class)
class VaadinSessionServiceTest {
  
  @MockBean
  private VaadinSessionManager vaadinSessionManager;
  @Autowired
  private SessionService sessionService;
  
  @Test
  void givenASignInUser_whenRegisterAndFetch_thenRegisterAndFetch() {
    sessionService.registerSessionUser(SIGN_IN_USER_1);
    verify(vaadinSessionManager).store(SIGN_IN_USER_1);
    
    sessionService.fetchSessionUser();
    verify(vaadinSessionManager).fetch();
  }
}
