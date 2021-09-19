package com.carpco.petcity.gui.view;

import com.carpco.petcity.gui.component.ConfirmDialog;
import com.carpco.petcity.gui.constants.LoginConstants;
import com.carpco.petcity.gui.dto.SignInUser;
import com.carpco.petcity.gui.service.LoginService;
import com.carpco.petcity.gui.service.SessionService;
import com.carpco.petcity.gui.view.layout.MainLayout;
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
@Route(value = LoginConstants.ROUTE, layout = MainLayout.class)
@PageTitle(LoginConstants.PAGE_TITLE)
public class LoginView extends VerticalLayout implements HasUrlParameter<String>, AfterNavigationObserver {
  
  private static final Logger log = LoggerFactory.getLogger(LoginView.class);
  
  private final transient ConfirmDialog confirmDialog;
  private final transient LoginService loginService;
  private final transient SessionService sessionService;
  // UI Fields
  private final EmailField emailField;
  private final PasswordField passwordPwf;
  //Next navigation field
  private String location;
  
  public LoginView(ConfirmDialog confirmDialog, LoginService loginService, SessionService sessionService) {
    this.confirmDialog = confirmDialog;
    this.loginService = loginService;
    this.sessionService = sessionService;
    emailField = buildEmailField();
    passwordPwf = buildPasswordField();
    location = "";
  }
  
  @Override
  public void setParameter(BeforeEvent beforeEvent, String parameter) {
    this.location = parameter;
  }
  
  @Override
  public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
    addComponents();
  }
  
  protected void signIn(String userName, String password) {
    log.info("Checking login...");
    if (isNotEmpty(userName, password)) {
      Optional<SignInUser> userOptional = loginService.login(userName, password);
      if (userOptional.isPresent()) {
        checkUserEnabled(userOptional.get());
      } else {
        showInvalidSignIn(userName);
      }
    }
  }
  
  private void addComponents() {
    H4 title = new H4(LoginConstants.FORM_TITLE);
    Button signInBtn = new Button(LoginConstants.SIGN_IN_BUTTON, event -> signIn(emailField.getValue(), passwordPwf.getValue()));
    signInBtn.addClickShortcut(ENTER);
  
    FormLayout content = new FormLayout();
    content.setSizeUndefined();
    content.add(emailField, passwordPwf, signInBtn);
  
    RouterLink signUpRl = new RouterLink(LoginConstants.NEW_USER_LINK, SignUpView.class);
    RouterLink rememberPasswordRl = new RouterLink(LoginConstants.REMEMBER_PASSWORD_LINK, RememberPasswordView.class);
  
    setMargin(true);
    setSpacing(true);
    setHorizontalComponentAlignment(Alignment.CENTER, title, content, signUpRl, rememberPasswordRl);
    add(title, content, signUpRl, rememberPasswordRl);
  }
  
  private EmailField buildEmailField() {
    EmailField field = new EmailField(LoginConstants.USER_FIELD);
    field.setRequiredIndicatorVisible(true);
    field.setErrorMessage(LoginConstants.USER_REQUIRED_MESSAGE);
    return field;
  }
  
  private PasswordField buildPasswordField() {
    PasswordField passwordField = new PasswordField(LoginConstants.PASSWORD_FIELD);
    passwordField.setRequired(true);
    passwordField.setErrorMessage(LoginConstants.PASSWORD_REQUIRED_MESSAGE);
    return passwordField;
  }
  
  private void checkUserEnabled(SignInUser user) {
    if (user.isActive() && user.getVeterinary().isPaid()) {
      navigateToMain(user);
    } else {
      showDisabledUsername(user.getEmail());
    }
  }
  
  private void navigateToMain(SignInUser user) {
    log.info("User={} sign in correctly at {}", user.getEmail(), LocalDateTime.now());
    sessionService.registerSessionUser(user);
    UI.getCurrent().navigate(location);
  }
  
  private void showInvalidSignIn(String userName) {
    log.info("A valid username and password are required for username={}", userName);
    confirmDialog.show(LoginConstants.INVALID_SIGN_IN_MESSAGE);
  }
  
  private void showDisabledUsername(String userName) {
    log.info("The username={} is disabled", userName);
    confirmDialog.show(LoginConstants.DISABLED_USER_MESSAGE);
  }
  
  private boolean isNotEmpty(String userName, String password) {
    return isNotEmpty(userName, emailField) && isNotEmpty(password, passwordPwf);
  }
  
  private boolean isNotEmpty(String value, HasValidation field) {
    Optional.of(value)
      .filter(StringUtils::isEmpty)
      .ifPresent(given -> {
        log.info("The user is trying to login without providing all required data");
        field.setInvalid(true);
      });
    return StringUtils.isNotEmpty(value);
  }
}
