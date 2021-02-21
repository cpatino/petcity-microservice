package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.SignInUser;
import com.carpco.petcity.business.dto.SignUpUser;

import java.util.Optional;

public interface SignUpService {
  
  Optional<SignInUser> register(SignUpUser signUpUser);
}
