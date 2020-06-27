package com.carpco.petcity.gui.service;

import com.carpco.petcity.business.dto.SignInUser;

import java.util.Optional;

public interface SessionService {
  
  Optional<SignInUser> getSessionUser();
  
  void registerSessionUser(SignInUser signInUser);
}
