package com.carpco.petcity.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public abstract class CommonDataDto {
  
  private BigInteger id;
  private LocalDateTime creation;
  private boolean enabled;
  
  public CommonDataDto() {
    super();
  }
  
  public CommonDataDto(BigInteger id, LocalDateTime creation, boolean enabled) {
    super();
    this.id = id;
    this.creation = creation;
    this.enabled = enabled;
  }
  
  public BigInteger getId() {
    return id;
  }
  
  public LocalDateTime getCreation() {
    return creation;
  }
  
  public boolean isEnabled() {
    return enabled;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    CommonDataDto that = (CommonDataDto) o;
    
    if (enabled != that.enabled) return false;
    if (!id.equals(that.id)) return false;
    return creation.equals(that.creation);
  }
  
  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + creation.hashCode();
    result = 31 * result + (enabled ? 1 : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return "CommonDataDto{" +
      "id=" + id +
      ", creation=" + creation +
      ", enabled=" + enabled +
      '}';
  }
}