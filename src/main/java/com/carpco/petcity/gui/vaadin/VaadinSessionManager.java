package com.carpco.petcity.gui.vaadin;

import com.carpco.petcity.gui.dto.SignInUser;

import java.util.Optional;

public interface VaadinSessionManager {
  
  Optional<SignInUser> fetch();
  
  void store(SignInUser signInUser);
}
