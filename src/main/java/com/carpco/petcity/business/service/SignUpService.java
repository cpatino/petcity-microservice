package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.SignInUser;

import java.util.Optional;

public interface SignUpService {
  
  Optional<SignInUser> signUp();
}
