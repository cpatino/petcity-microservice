package com.carpco.petcity.gui.vaadin;

import com.carpco.petcity.gui.constants.AttributeConstants;
import com.carpco.petcity.gui.dto.SignInUser;
import com.vaadin.flow.server.VaadinSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.carpco.petcity.util.DataTestDtoUtils.SIGN_IN_USER_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VaadinSessionManagerImpTest {
  
  @Mock
  private VaadinSession vaadinSession;
  private VaadinSessionManager vaadinSessionManager;
  
  @BeforeEach
  void setup() {
    vaadinSessionManager = new VaadinSessionManagerImp();
  }
  
  @Test
  void givenNoVaadinSession_whenStore_thenThrowException() {
    VaadinSession.setCurrent(null);
    Assertions.assertThrows(IllegalStateException.class, () -> vaadinSessionManager.store(SIGN_IN_USER_1));
  }
  
  @Test
  void givenSignInUser_whenStoreAndFetch_ThenExerciseVaadinSession() {
    VaadinSession.setCurrent(vaadinSession);
    vaadinSessionManager.store(SIGN_IN_USER_1);
    verify(vaadinSession).setAttribute(AttributeConstants.CLIENT, SIGN_IN_USER_1);
    
    when(vaadinSession.getAttribute(AttributeConstants.CLIENT)).thenReturn(SIGN_IN_USER_1);
    Optional<SignInUser> signInUserOptional = vaadinSessionManager.fetch();
    assertThat(signInUserOptional).isPresent();
    assertThat(signInUserOptional.get()).isEqualTo(SIGN_IN_USER_1);
  }
}
