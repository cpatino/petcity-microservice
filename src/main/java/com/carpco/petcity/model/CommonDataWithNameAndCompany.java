package com.carpco.petcity.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.time.LocalTime;

@MappedSuperclass
public abstract class CommonDataWithNameAndCompany extends CommonDataWithCompany {
  
  @NotBlank(message = "El nombre es obligatorio")
  private String name;
  
  public CommonDataWithNameAndCompany() {
    super();
  }
  
  public CommonDataWithNameAndCompany(BigInteger id, LocalTime creation, boolean enabled, String name, Company company) {
    super(id, creation, enabled, company);
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    CommonDataWithNameAndCompany that = (CommonDataWithNameAndCompany) o;
    
    return name.equals(that.name);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "CommonDataWithNameAndCompany{" +
      "name='" + name + '\'' +
      "} " + super.toString();
  }
}