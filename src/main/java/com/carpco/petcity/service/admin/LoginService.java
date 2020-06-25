package com.carpco.petcity.service.admin;

import com.carpco.petcity.dto.SignUpUser;

import java.util.Optional;

public interface LoginService {
  
  void registerSessionUser(SignUpUser signUpUser);
  
  Optional<SignUpUser> login(String userName, String password);
}
