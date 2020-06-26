package com.carpco.petcity.business.dto;

import java.math.BigInteger;

public class Veterinary {
  
  private final BigInteger identifier;
  private final String name;
  private final boolean paid;
  private final String photo;
  
  public Veterinary(Builder builder) {
    identifier = builder.identifier;
    name = builder.name;
    paid = builder.paid;
    photo = builder.photo;
  }
  
  public static Builder builder(Veterinary veterinary) {
    return new Builder(veterinary);
  }
  
  public String getName() {
    return name;
  }
  
  public boolean isPaid() {
    return paid;
  }
  
  public String getPhoto() {
    return photo;
  }
  
  public BigInteger getIdentifier() {
    return identifier;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Veterinary that = (Veterinary) o;
    
    return identifier.equals(that.identifier);
  }
  
  @Override
  public int hashCode() {
    return identifier.hashCode();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  @Override
  public String toString() {
    return "Veterinary{" +
      "identifier=" + identifier +
      ", name='" + name + '\'' +
      ", paid=" + paid +
      ", photo='" + photo + '\'' +
      '}';
  }
  
  public static class Builder {
  
    private BigInteger identifier;
    private String name;
    private boolean paid;
    private String photo;
  
    private Builder() {
      super();
    }
  
    private Builder(Veterinary veterinary) {
      identifier(veterinary.getIdentifier())
        .name(veterinary.name)
        .paid(veterinary.paid)
        .photo(veterinary.photo);
    }
  
    public Builder identifier(BigInteger identifier) {
      this.identifier = identifier;
      return this;
    }
  
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  
    public Builder paid(boolean paid) {
      this.paid = paid;
      return this;
    }
  
    public Builder photo(String photo) {
      this.photo = photo;
      return this;
    }
  
    public Veterinary build() {
      return new Veterinary(this);
    }
  }
}