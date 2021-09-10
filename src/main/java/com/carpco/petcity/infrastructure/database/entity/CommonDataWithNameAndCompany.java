package com.carpco.petcity.infrastructure.database.entity;

import javax.persistence.MappedSuperclass;
import java.math.BigInteger;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class CommonDataWithNameAndCompany extends CommonDataWithCompany {

  private String name;

  public CommonDataWithNameAndCompany() {
    super();
  }

  protected CommonDataWithNameAndCompany(BigInteger id, LocalDateTime creation, boolean enabled, String name, Company company) {
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