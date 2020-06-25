package com.carpco.petcity.service.impl;

import com.carpco.petcity.dto.SignUpUser;
import com.carpco.petcity.service.SessionService;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.carpco.petcity.view.constants.AttributeConstants.CLIENT;

@Service
public class VaadinSessionServiceImpl implements SessionService {
  
  @Override
  public Optional<SignUpUser> getSessionUser() {
    return Optional.of(VaadinSession.getCurrent())
      .map(session -> session.getAttribute(CLIENT))
      .map(SignUpUser.class::cast);
  }
  
  @Override
  public void registerSessionUser(SignUpUser signUpUser) {
    VaadinSession.getCurrent().setAttribute(CLIENT, signUpUser);
  }
}
