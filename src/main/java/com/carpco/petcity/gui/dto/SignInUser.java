package com.carpco.petcity.gui.dto;

public class SignInUser {
  
  private final String fullName;
  private final String email;
  private final Veterinary veterinary;
  private final boolean active;
  
  public SignInUser(Builder builder) {
    fullName = builder.fullName;
    email = builder.email;
    veterinary = builder.veterinary;
    active = builder.active;
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
  
  public static Builder builder() {
    return new Builder();
  }
  
  @Override
  public int hashCode() {
    int result = email.hashCode();
    result = 31 * result + veterinary.hashCode();
    return result;
  }
  
  public static Builder builder(SignInUser signInUser) {
    return new Builder(signInUser);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    SignInUser that = (SignInUser) o;
    
    if (!email.equals(that.email)) return false;
    return veterinary.equals(that.veterinary);
  }
  
  public static class Builder {
    
    private String fullName;
    private String email;
    private Veterinary veterinary;
    private boolean active;
    
    private Builder() {
      super();
    }
    
    private Builder(SignInUser signInUser) {
      fullName(signInUser.getFullName())
        .email(signInUser.email)
        .veterinary(signInUser.veterinary)
        .active(signInUser.isActive());
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
    
    public SignInUser build() {
      return new SignInUser(this);
    }
  }
}