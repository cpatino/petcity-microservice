package com.carpco.petcity.gui.service;

import com.carpco.petcity.gui.dto.SignInUser;
import com.carpco.petcity.gui.vaadin.VaadinSessionManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class VaadinSessionService implements SessionService {
  
  private final VaadinSessionManager vaadinSessionManager;
  
  public VaadinSessionService(final VaadinSessionManager vaadinSessionManager) {
    this.vaadinSessionManager = vaadinSessionManager;
  }
  
  @Override
  public Optional<SignInUser> fetchSessionUser() {
    return vaadinSessionManager.fetch();
  }
  
  @Override
  public void registerSessionUser(SignInUser signInUser) {
    vaadinSessionManager.store(signInUser);
  }
}
