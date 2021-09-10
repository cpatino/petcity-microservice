package com.carpco.petcity.domain.service;

import com.carpco.petcity.gui.dto.SignInUser;

import java.util.Optional;

public interface LoginService {
  
  Optional<SignInUser> login(String userName, String password);
}
