package com.carpco.petcity.service;

import com.carpco.petcity.dto.SignUpUser;

import java.util.Optional;

public interface LoginService {
  
  Optional<SignUpUser> login(String userName, String password);
}
