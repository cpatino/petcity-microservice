package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.SignInUser;

import java.util.Optional;

public interface LoginService {
  
  Optional<SignInUser> login(String userName, String password);
}
