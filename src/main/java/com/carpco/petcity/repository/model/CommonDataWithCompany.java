package com.carpco.petcity.repository.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class CommonDataWithCompany extends CommonData {
  
  @ManyToOne
  @JoinColumn(name = "idcompany")
  @NotNull(message = "La veterinaria es obligatoria")
  private Company company;
  
  public CommonDataWithCompany() {
    super();
  }
  
  protected CommonDataWithCompany(BigInteger id, LocalDateTime creation, boolean enabled, Company company) {
    super(id, creation, enabled);
    this.company = company;
  }
  
  public Company getCompany() {
    return company;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    CommonDataWithCompany that = (CommonDataWithCompany) o;
    
    return company.equals(that.company);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + company.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "CommonDataWithCompany{" +
      "company=" + company +
      "} " + super.toString();
  }
}