package com.carpco.petcity.view.account;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.service.UserService;
import com.carpco.petcity.view.component.ConfirmDialog;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Scope("prototype")
@Route
public class LoginView extends VerticalLayout {
  
  private static final Logger log = LoggerFactory.getLogger(LoginView.class);
  
  private final UserService userService;
  private final ConfirmDialog confirmDialog;
  
  public LoginView(UserService userService, ConfirmDialog confirmDialog) {
    this.userService = userService;
    this.confirmDialog = confirmDialog;
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
    if (userOptional.isPresent()) {
      checkUserEnabled(userOptional.get());
    } else {
      showInvalidSignIn(userName);
    }
  }
  
  private void checkUserEnabled(UserDto user) {
    if (user.isEnabled()) {
      navigateToMain(user);
    } else {
      showDisabledUsername(user.getEmail());
    }
  }
  
  private void navigateToMain(UserDto user) {
    log.info("User={} sign in correctly at {}", user.getEmail(), LocalDateTime.now());
    UI.getCurrent().navigate("");
  }
  
  private void showInvalidSignIn(String userName) {
    log.info("A valid username and password are required for username={}", userName);
    confirmDialog.show("Datos erroneos! Usuario o contraseña incorrectos");
  }
  
  private void showDisabledUsername(String userName) {
    log.info("The username={} is disabled", userName);
    confirmDialog.show("El Usuario está desactivado, pongase en contacto con el proveedor.");
  }
}
