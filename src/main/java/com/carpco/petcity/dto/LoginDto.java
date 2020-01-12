package com.carpco.petcity.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {
  
  @NotBlank private String email;
  @NotBlank private String password;
  
  public LoginDto() {
    super();
  }
  
  public LoginDto(String email, String password) {
    this.email = email;
    this.password = password;
  }
  
  public String getEmail() {
    return email;
  }
  
  public String getPassword() {
    return password;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    LoginDto loginDto = (LoginDto) o;
    
    if (!email.equals(loginDto.email)) return false;
    return password.equals(loginDto.password);
  }
  
  @Override
  public int hashCode() {
    int result = email.hashCode();
    result = 31 * result + password.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "LoginDto{" +
      "email='" + email + '\'' +
      ", password='" + password + '\'' +
      '}';
  }
}
