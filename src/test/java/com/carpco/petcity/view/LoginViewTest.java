package com.carpco.petcity.view;

import com.carpco.petcity.dto.SignUpUser;
import com.carpco.petcity.service.SessionService;
import com.carpco.petcity.view.component.ConfirmDialog;
import com.github.mvysny.kaributesting.v10.MockVaadin;
import com.github.mvysny.kaributesting.v10.Routes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginViewTest {
  
  @Autowired
  private LoginView loginView;
  @SpyBean
  private ConfirmDialog confirmDialog;
  @SpyBean
  private SessionService sessionService;
  
  @Before
  public void setupVaadin() {
    Routes routes = new Routes().autoDiscoverViews("com.carpco.petcity.view");
    MockVaadin.setup(routes);
  }
  
  @Test
  public void givenUserNotEnabled_whenLogin_ThenShowDialog() {
    loginView.signIn("disabled@test.test", "password");
    verify(confirmDialog).show(anyString());
  }
  
  @Test
  public void givenUserNotKnown_whenLogin_ThenShowDialog() {
    loginView.signIn("disabled", "password");
    verify(confirmDialog).show(anyString());
  }
  
  @Test
  public void givenUserEnabled_whenLogin_ThenDoNotShowDialog() {
    loginView.signIn("test@test.test", "password");
    verify(confirmDialog, never()).show(anyString());
    verify(sessionService).registerSessionUser(any(SignUpUser.class));
  }
}