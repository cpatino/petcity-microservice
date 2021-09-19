package com.carpco.petcity.gui.vaadin;

import com.carpco.petcity.gui.constants.AttributeConstants;
import com.carpco.petcity.gui.dto.SignInUser;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
class VaadinSessionManagerImp implements VaadinSessionManager {
  
  @Override
  public Optional<SignInUser> fetch() {
    return Optional.of(VaadinSession.getCurrent())
      .map(session -> session.getAttribute(AttributeConstants.CLIENT))
      .map(SignInUser.class::cast);
  }
  
  @Override
  public void store(SignInUser signInUser) {
    VaadinSession vaadinSession = VaadinSession.getCurrent();
    if (Objects.nonNull(vaadinSession)) {
      vaadinSession.setAttribute(AttributeConstants.CLIENT, signInUser);
    } else {
      throw new IllegalStateException("Something wrong happen, there is not current Vaadin session");
    }
  }
}
