package com.carpco.petcity.business.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class VaccineDto {
  @NotNull(message = "El nombre es obligatorio")
  private final String name;

  public VaccineDto(Builder builder) {
    name = builder.name;
  }

  public String getName() {
    return name;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VaccineDto)) return false;
    VaccineDto that = (VaccineDto) o;
    return Objects.equals(getName(), that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return "VaccineDto{" +
        "name='" + name + '\'' +
        '}';
  }

  public static class Builder {

    private String name;


    private Builder() {
      super();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public VaccineDto build() {
      return new VaccineDto(this);
    }
  }
}
