package com.carpco.petcity.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import java.math.BigInteger;
import java.time.LocalTime;

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "reproduction")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class Reproduction extends CommonDataWithNameAndCompany {
  
  public Reproduction() {
    super();
  }
  
  public Reproduction(Builder builder) {
    super(builder.id, builder.creation, builder.enabled, builder.name, builder.company);
  }
  
  @Override
  public String toString() {
    return "Reproduction{} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(Reproduction reproduction) {
    return new Builder(reproduction);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private LocalTime creation;
    private boolean enabled;
    private String name;
    private Company company;
    
    private Builder() {
      super();
    }
    
    private Builder(Reproduction reproduction) {
      id(reproduction.getId()).creation(reproduction.getCreation()).enabled(reproduction.isEnabled())
        .name(reproduction.getName()).company(reproduction.getCompany());
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
    
    public Builder company(Company company) {
      this.company = company;
      return this;
    }
    
    public Reproduction build() {
      return new Reproduction(this);
    }
  }
}