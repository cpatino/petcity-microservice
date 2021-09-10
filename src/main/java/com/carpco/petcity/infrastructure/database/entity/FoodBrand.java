package com.carpco.petcity.infrastructure.database.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "foodbrand")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class FoodBrand extends CommonDataWithNameAndCompany {
  
  //For hibernate
  public FoodBrand() {
    super();
  }
  
  protected FoodBrand(Builder builder) {
    super(builder.id, builder.creation, builder.enabled, builder.name, builder.company);
  }
  
  @Override
  public String toString() {
    return "FoodBrand{} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(FoodBrand foodBrand) {
    return new Builder(foodBrand);
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
    
    private Builder(FoodBrand foodBrand) {
      id(foodBrand.getId()).creation(foodBrand.getCreation()).enabled(foodBrand.isEnabled())
        .name(foodBrand.getName()).company(foodBrand.getCompany());
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
    
    public FoodBrand build() {
      return new FoodBrand(this);
    }
  }
}