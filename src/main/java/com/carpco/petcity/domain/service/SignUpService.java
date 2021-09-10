package com.carpco.petcity.domain.service;

import com.carpco.petcity.gui.dto.SignInUser;
import com.carpco.petcity.gui.dto.SignUpUser;

import java.util.Optional;

public interface SignUpService {
  
  Optional<SignInUser> register(SignUpUser signUpUser);
}
