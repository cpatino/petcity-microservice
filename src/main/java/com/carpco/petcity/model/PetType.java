package com.carpco.petcity.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "pettype")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class PetType extends CommonDataWithNameAndCompany {
  
  public PetType() {
    super();
  }
  
  protected PetType(Builder builder) {
    super(builder.id, builder.creation, builder.enabled, builder.name, builder.company);
  }
  
  @Override
  public String toString() {
    return "PetType{} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(PetType petType) {
    return new Builder(petType);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private LocalDateTime creation;
    private boolean enabled;
    private String name;
    private Company company;
    
    private Builder() {
      super();
    }
    
    private Builder(PetType petType) {
      id(petType.getId()).creation(petType.getCreation()).enabled(petType.isEnabled()).name(petType.getName())
        .company(petType.getCompany());
    }
    
    public Builder id(BigInteger id) {
      this.id = id;
      return this;
    }
    
    public Builder creation(LocalDateTime creation) {
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
    
    public Builder company(Company company) {
      this.company = company;
      return this;
    }
    
    public PetType build() {
      return new PetType(this);
    }
  }
}