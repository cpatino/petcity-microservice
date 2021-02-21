package com.carpco.petcity.business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class SignUpUser {
  
  @NotEmpty private final String document;
  @NotEmpty private final String name;
  @NotEmpty private final String lastName;
  @NotEmpty private final String phone;
  @NotEmpty private final String email;
  @NotEmpty private final String password;
  @NotBlank private final Veterinary veterinary;
  
  public SignUpUser(Builder builder) {
    document = builder.document;
    name = builder.name;
    lastName = builder.lastName;
    phone = builder.phone;
    email = builder.email;
    password = builder.password;
    veterinary = builder.veterinary;
  }
  
  public static Builder builder(SignUpUser signInUser) {
    return new Builder(signInUser);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public String getDocument() {
    return document;
  }
  
  public String getName() {
    return name;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public String getEmail() {
    return email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public Veterinary getVeterinary() {
    return veterinary;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    SignUpUser that = (SignUpUser) o;
    
    if (!document.equals(that.document)) return false;
    return veterinary.equals(that.veterinary);
  }
  
  @Override
  public int hashCode() {
    int result = document.hashCode();
    result = 31 * result + veterinary.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "SignUpUser{" +
      "document='" + document + '\'' +
      ", name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      ", phone='" + phone + '\'' +
      ", email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", veterinary=" + veterinary +
      '}';
  }
  
  public static class Builder {
    
    private String document;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Veterinary veterinary;
    
    private Builder() {
      super();
    }
    
    private Builder(SignUpUser signUpUser) {
      document(signUpUser.getDocument())
        .name(signUpUser.getName())
        .lastName(signUpUser.getLastName())
        .phone(signUpUser.getPhone())
        .email(signUpUser.getEmail())
        .password(signUpUser.getPassword())
        .veterinary(signUpUser.getVeterinary());
    }
    
    public Builder document(String document) {
      this.document = document;
      return this;
    }
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }
    
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }
    
    public Builder email(String email) {
      this.email = email;
      return this;
    }
    
    public Builder password(String password) {
      this.password = password;
      return this;
    }
    
    public Builder veterinary(Veterinary veterinary) {
      this.veterinary = veterinary;
      return this;
    }
    
    public SignUpUser build() {
      return new SignUpUser(this);
    }
  }
}