package com.carpco.petcity.business.service;

import com.carpco.petcity.business.dto.SignUpUser;

import java.util.Optional;

public interface LoginService {
  
  Optional<SignUpUser> login(String userName, String password);
}
