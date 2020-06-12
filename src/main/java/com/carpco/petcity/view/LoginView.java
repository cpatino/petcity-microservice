package com.carpco.petcity.view;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.service.admin.LoginService;
import com.carpco.petcity.view.account.RememberPasswordView;
import com.carpco.petcity.view.account.SignUpView;
import com.carpco.petcity.view.component.ConfirmDialog;
import com.carpco.petcity.view.layout.MainLayout;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.vaadin.flow.component.Key.ENTER;

@Component
@Scope("prototype")
@Route(value = "login", layout = MainLayout.class)
@PageTitle("Vet Soporte | login")
public class LoginView extends VerticalLayout implements HasUrlParameter<String> {
  
  private static final Logger log = LoggerFactory.getLogger(LoginView.class);
  
  private final transient ConfirmDialog confirmDialog;
  private final transient LoginService loginService;
  // UI Fields
  private final EmailField emailField;
  private final PasswordField passwordPwf;
  //Next navigation field
  private String location;
  
  public LoginView(ConfirmDialog confirmDialog, LoginService loginService) {
    this.confirmDialog = confirmDialog;
    this.loginService = loginService;
    emailField = buildEmailField();
    passwordPwf = buildPasswordField();
    location = "";
    addComponents();
  }
  
  @Override
  public void setParameter(BeforeEvent beforeEvent, String parameter) {
    this.location = parameter;
  }
  
  protected void signIn(String userName, String password) {
    log.info("Checking login...");
    if (isNotEmpty(userName, emailField)
      && isNotEmpty(password, passwordPwf)) {
      Optional<UserDto> userOptional = loginService.login(userName, password);
      if (userOptional.isPresent()) {
        checkUserEnabled(userOptional.get());
      } else {
        showInvalidSignIn(userName);
      }
    }
  }
  
  private void addComponents() {
    H4 title = new H4("Inicio de sesión");
    Button signInBtn = new Button("Ingresar", event -> signIn(emailField.getValue(), passwordPwf.getValue()));
    signInBtn.addClickShortcut(ENTER);
    
    FormLayout content = new FormLayout();
    content.setSizeUndefined();
    content.add(emailField, passwordPwf, signInBtn);
    
    RouterLink signUpRl = new RouterLink("Nuevo usuario", SignUpView.class);
    RouterLink rememberPasswordRl = new RouterLink("Olvide mi contraseña", RememberPasswordView.class);
    
    setMargin(true);
    setSpacing(true);
    setHorizontalComponentAlignment(Alignment.CENTER, title, content, signUpRl, rememberPasswordRl);
    add(title, content, signUpRl, rememberPasswordRl);
  }
  
  private EmailField buildEmailField() {
    EmailField field = new EmailField("Usuario:");
    field.setRequiredIndicatorVisible(true);
    field.setErrorMessage("El email es requerido");
    return field;
  }
  
  private PasswordField buildPasswordField() {
    PasswordField passwordField = new PasswordField("Contraseña:");
    passwordField.setRequired(true);
    passwordField.setErrorMessage("La contraseña es requerida");
    return passwordField;
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
    loginService.registerSessionUser(user);
    UI.getCurrent().navigate(location);
  }
  
  private void showInvalidSignIn(String userName) {
    log.info("A valid username and password are required for username={}", userName);
    confirmDialog.show("Datos erroneos! Usuario o contraseña incorrectos");
  }
  
  private void showDisabledUsername(String userName) {
    log.info("The username={} is disabled", userName);
    confirmDialog.show("El Usuario está desactivado, pongase en contacto con el proveedor.");
  }
  
  private boolean isNotEmpty(String value, HasValidation field) {
    boolean isEmpty = StringUtils.isEmpty(value);
    if (isEmpty) {
      log.info("The user is trying to login without providing all required data");
      field.setInvalid(true);
    }
    return !isEmpty;
  }
}
