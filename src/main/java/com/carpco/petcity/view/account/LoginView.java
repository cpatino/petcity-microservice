package com.carpco.petcity.view.account;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Optional;

@Route
public class LoginView extends VerticalLayout {
  
  private static final Logger log = LoggerFactory.getLogger(LoginView.class);
  
  private final UserService userService;
  
  public LoginView(UserService userService) {
    this.userService = userService;
    addComponents();
  }
  
  private void addComponents() {
    TextField usernameTxf = new TextField("Usuario:");
    PasswordField passwordPwf = new PasswordField("Contraseña:");
    Button signInBtn = new Button("Ingresar", event -> signIn(usernameTxf.getValue(), passwordPwf.getValue()));
    add(usernameTxf, passwordPwf, signInBtn);
  }
  
  protected void signIn(String userName, String password) {
    log.info("Checking login...");
    Optional<UserDto> userOptional = userService.login(userName, password);
    if (!userOptional.isPresent()) {
      showInvalidSignIn(userName);
    }
    userOptional.ifPresent(this::checkUserEnabled);
  }
  
  private void checkUserEnabled(UserDto user) {
    if (user.isEnabled()) {
      goToMain(user);
    } else {
      showDisabledUsername(user.getEmail());
    }
  }
  
  private void goToMain(UserDto user) {
    log.info("User={} sign in correctly at {}", user.getEmail(), LocalDateTime.now());
  }
  
  private void showInvalidSignIn(String userName) {
    log.info("A valid username and password are required for username={}", userName);
  }
  
  private void showDisabledUsername(String userName) {
    log.info("The username={} is disabled", userName);
  }
}
