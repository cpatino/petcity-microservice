package com.carpco.petcity.gui.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class VaccineDto {
  
  @NotNull(message = "El nombre es obligatorio")
  private final String name;
  @NotNull(message = "La veterinaria es obligatorio")
  private final Veterinary veterinary;
  
  public VaccineDto(Builder builder) {
    name = builder.name;
    veterinary = builder.veterinary;
  }
  
  public String getName() {
    return name;
  }
  
  public static Builder builder(VaccineDto vaccineDto) {
    return new Builder(vaccineDto);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public Veterinary getVeterinary() {
    return veterinary;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VaccineDto)) return false;
    VaccineDto that = (VaccineDto) o;
    return Objects.equals(getName(), that.getName()) &&
      Objects.equals(getVeterinary(), that.getVeterinary());
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getVeterinary());
  }
  
  @Override
  public String toString() {
    return "VaccineDto{" +
      "name='" + name + '\'' +
      ", veterinary=" + veterinary +
      '}';
  }
  
  public static class Builder {
  
    private String name;
    private Veterinary veterinary;
    
    private Builder() {
      super();
    }
  
    private Builder(VaccineDto vaccineDto) {
      name(vaccineDto.getName());
      veterinary(vaccineDto.getVeterinary());
    }
  
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  
    public Builder veterinary(Veterinary veterinary) {
      this.veterinary = veterinary;
      return this;
    }
  
    public VaccineDto build() {
      return new VaccineDto(this);
    }
  }
}
