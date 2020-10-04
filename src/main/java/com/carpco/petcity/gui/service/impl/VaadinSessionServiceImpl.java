package com.carpco.petcity.gui.service.impl;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.gui.constants.AttributeConstants;
import com.carpco.petcity.gui.service.SessionService;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaadinSessionServiceImpl implements SessionService {
  
  @Override
  public Optional<SignInUser> getSessionUser() {
    return Optional.of(VaadinSession.getCurrent())
      .map(session -> session.getAttribute(AttributeConstants.CLIENT))
      .map(SignInUser.class::cast);
  }
  
  @Override
  public Optional<Veterinary> getVeterinary() {
    return getSessionUser()
      .map(SignInUser::getVeterinary);
  }
  
  @Override
  public void registerSessionUser(SignInUser signInUser) {
    VaadinSession.getCurrent().setAttribute(AttributeConstants.CLIENT, signInUser);
  }
}
