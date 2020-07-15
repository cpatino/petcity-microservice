package com.carpco.petcity.business.dto;

import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.util.Objects;

public class Veterinary {
  
  private final BigInteger identifier;
  @NotEmpty private final String document;
  @NotEmpty private final String name;
  private final boolean paid;
  private final String photo;
  
  public Veterinary(Builder builder) {
    identifier = builder.identifier;
    document = builder.document;
    name = builder.name;
    paid = builder.paid;
    photo = builder.photo;
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
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(Veterinary veterinary) {
    return new Builder(veterinary);
  }
  
  public String getDocument() {
    return document;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Veterinary that = (Veterinary) o;
    
    if (!Objects.equals(identifier, that.identifier)) return false;
    return document.equals(that.document);
  }
  
  @Override
  public int hashCode() {
    int result = identifier != null ? identifier.hashCode() : 0;
    result = 31 * result + document.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "Veterinary{" +
      "identifier=" + identifier +
      ", document='" + document + '\'' +
      ", name='" + name + '\'' +
      ", paid=" + paid +
      ", photo='" + photo + '\'' +
      '}';
  }
  
  public static class Builder {
  
    private BigInteger identifier;
    private String document;
    private String name;
    private boolean paid = true;
    private String photo;
  
    private Builder() {
      super();
    }
  
    private Builder(Veterinary veterinary) {
      identifier(veterinary.getIdentifier())
        .document(veterinary.getDocument())
        .name(veterinary.name)
        .paid(veterinary.paid)
        .photo(veterinary.photo);
    }
  
    public Builder identifier(BigInteger identifier) {
      this.identifier = identifier;
      return this;
    }
  
    public Builder document(String document) {
      this.document = document;
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