package com.carpco.petcity.gui.service;

import com.carpco.petcity.gui.dto.SignInUser;

import java.util.Optional;

public interface SessionService {
  
  Optional<SignInUser> getSessionUser();
  
  void registerSessionUser(SignInUser signInUser);
}
