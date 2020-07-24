package com.carpco.petcity.gui.service;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.Veterinary;

import java.util.Optional;

public interface SessionService {
  
  Optional<SignInUser> getSessionUser();
  
  Optional<Veterinary> getVeterinary();
  
  void registerSessionUser(SignInUser signInUser);
}
