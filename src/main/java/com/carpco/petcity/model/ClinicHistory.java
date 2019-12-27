package com.carpco.petcity.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalTime;

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "clinichistory")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class ClinicHistory extends CommonDataWithCompany {
  
  @ManyToOne
  @JoinColumn(name = "idpet")
  @NotNull(message = "La mascota es obligatoria")
  private Pet pet;
  @Column(name = "recordcustomid")
  private BigInteger recordCustomId;
  
  public ClinicHistory() {
    super();
  }
  
  public ClinicHistory(Builder builder) {
    super(builder.id, builder.creation, builder.enabled, builder.company);
    pet = builder.pet;
    recordCustomId = builder.recordCustomId;
  }
  
  public Pet getPet() {
    return pet;
  }
  
  public BigInteger getRecordCustomId() {
    return recordCustomId;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    ClinicHistory that = (ClinicHistory) o;
    
    if (!pet.equals(that.pet)) return false;
    return recordCustomId != null ? recordCustomId.equals(that.recordCustomId) : that.recordCustomId == null;
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + pet.hashCode();
    result = 31 * result + (recordCustomId != null ? recordCustomId.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return "ClinicHistory{" +
      "pet=" + pet +
      ", recordCustomId=" + recordCustomId +
      "} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(ClinicHistory clinicHistory) {
    return new Builder(clinicHistory);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private LocalTime creation;
    private boolean enabled;
    private Pet pet;
    private Company company;
    private BigInteger recordCustomId;
    
    private Builder() {
      super();
    }
    
    private Builder(ClinicHistory clinicHistory) {
      id(clinicHistory.getId()).creation(clinicHistory.getCreation()).enabled(clinicHistory.isEnabled())
        .pet(clinicHistory.pet).company(clinicHistory.getCompany());
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
    
    private Builder pet(Pet pet) {
      this.pet = pet;
      return this;
    }
    
    public Builder company(Company company) {
      this.company = company;
      return this;
    }
    
    public Builder recordCustomId(BigInteger recordCustomId) {
      this.recordCustomId = recordCustomId;
      return this;
    }
    
    public ClinicHistory build() {
      return new ClinicHistory(this);
    }
  }
}