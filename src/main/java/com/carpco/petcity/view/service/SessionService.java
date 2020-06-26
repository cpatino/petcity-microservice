package com.carpco.petcity.view.service;

import com.carpco.petcity.business.dto.SignUpUser;

import java.util.Optional;

public interface SessionService {
  
  Optional<SignUpUser> getSessionUser();
  
  void registerSessionUser(SignUpUser signUpUser);
}
