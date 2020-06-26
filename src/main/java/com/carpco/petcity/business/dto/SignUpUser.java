package com.carpco.petcity.business.dto;

public class SignUpUser {
  
  private final String fullName;
  private final String email;
  private final Veterinary veterinary;
  private final boolean active;
  
  public SignUpUser(Builder builder) {
    fullName = builder.fullName;
    email = builder.email;
    veterinary = builder.veterinary;
    active = builder.active;
  }
  
  public static Builder builder(SignUpUser signUpUser) {
    return new Builder(signUpUser);
  }
  
  public String getEmail() {
    return email;
  }
  
  public String getFullName() {
    return fullName;
  }
  
  public Veterinary getVeterinary() {
    return veterinary;
  }
  
  public boolean isActive() {
    return active;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    SignUpUser that = (SignUpUser) o;
    
    if (!email.equals(that.email)) return false;
    return veterinary.equals(that.veterinary);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  @Override
  public int hashCode() {
    int result = email.hashCode();
    result = 31 * result + veterinary.hashCode();
    return result;
  }
  
  public static class Builder {
    
    private String fullName;
    private String email;
    private Veterinary veterinary;
    private boolean active;
    
    private Builder() {
      super();
    }
    
    private Builder(SignUpUser signUpUser) {
      fullName(signUpUser.getFullName())
        .email(signUpUser.email)
        .veterinary(signUpUser.veterinary)
        .active(signUpUser.isActive());
    }
    
    public Builder fullName(String fullName) {
      this.fullName = fullName;
      return this;
    }
    
    public Builder email(String email) {
      this.email = email;
      return this;
    }
    
    public Builder veterinary(Veterinary veterinary) {
      this.veterinary = veterinary;
      return this;
    }
    
    public Builder active(boolean active) {
      this.active = active;
      return this;
    }
    
    public SignUpUser build() {
      return new SignUpUser(this);
    }
  }
}