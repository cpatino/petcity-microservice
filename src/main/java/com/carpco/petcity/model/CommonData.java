package com.carpco.petcity.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public abstract class CommonData {
  
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private BigInteger id;
  
  @Column(insertable = false, updatable = false)
  private LocalDateTime creation;
  
  private boolean enabled;
  
  public CommonData() {
    super();
  }
  
  public CommonData(BigInteger id, LocalDateTime creation, boolean enabled) {
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
    
    CommonData that = (CommonData) o;
    
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
    return "CommonData{" +
      "id=" + id +
      ", creation=" + creation +
      ", enabled=" + enabled +
      '}';
  }
}