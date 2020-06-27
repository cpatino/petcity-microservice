package com.carpco.petcity.gui.service.impl;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.gui.constants.AttributeConstants;
import com.carpco.petcity.gui.service.SessionService;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaadinSessionServiceImpl implements SessionService {
  
  @Override
  public Optional<SignUpUser> getSessionUser() {
    return Optional.of(VaadinSession.getCurrent())
      .map(session -> session.getAttribute(AttributeConstants.CLIENT))
      .map(SignUpUser.class::cast);
  }
  
  @Override
  public void registerSessionUser(SignUpUser signUpUser) {
    VaadinSession.getCurrent().setAttribute(AttributeConstants.CLIENT, signUpUser);
  }
}
