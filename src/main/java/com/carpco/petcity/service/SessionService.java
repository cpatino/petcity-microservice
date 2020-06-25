package com.carpco.petcity.service;

import com.carpco.petcity.dto.SignUpUser;

import java.util.Optional;

public interface SessionService {
  
  Optional<SignUpUser> getSessionUser();
  
  void registerSessionUser(SignUpUser signUpUser);
}
