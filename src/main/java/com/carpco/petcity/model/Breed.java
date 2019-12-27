package com.carpco.petcity.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalTime;

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "breed")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class Breed extends CommonDataWithNameAndCompany {
  
  @ManyToOne
  @JoinColumn(name = "idpettype")
  @NotNull(message = "La especie es obligatoria")
  private PetType petType;
  
  public Breed() {
    super();
  }
  
  public Breed(Builder builder) {
    super(builder.id, builder.creation, builder.enabled, builder.name, builder.company);
    this.petType = builder.petType;
  }
  
  public PetType getPetType() {
    return petType;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    Breed breed = (Breed) o;
    
    return petType.equals(breed.petType);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + petType.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "Breed{" +
      "petType=" + petType +
      "} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(Breed breed) {
    return new Builder(breed);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private LocalTime creation;
    private boolean enabled;
    private String name;
    private PetType petType;
    private Company company;
    
    private Builder() {
      super();
    }
    
    private Builder(Breed breed) {
      id(breed.getId()).creation(breed.getCreation()).enabled(breed.isEnabled()).name(breed.getName())
        .petType(breed.getPetType()).company(breed.getCompany());
    }
    
    public Builder id(BigInteger id) {
      this.id = id;
      return this;
    }
    
    public Builder creation(LocalTime creation) {
      this.creation = creation;
      return this;
    }
    
    public Builder enabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder petType(PetType petType) {
      this.petType = petType;
      return this;
    }
    
    public Builder company(Company company) {
      this.company = company;
      return this;
    }
    
    public Breed build() {
      return new Breed(this);
    }
  }
}