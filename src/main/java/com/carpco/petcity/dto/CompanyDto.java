package com.carpco.petcity.dto;

import com.carpco.petcity.model.Company;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

public class CompanyDto extends CommonDataDto {
  
  @NotBlank private String document;
  @NotBlank private String name;
  private boolean paid;
  private String photo;
  private BigInteger initialCustomId;
  private BigInteger actualCustomId;
  
  public CompanyDto() {
    super();
  }
  
  public CompanyDto(Builder builder) {
    super(builder.id, builder.creation, builder.enabled);
    this.document = builder.document;
    this.name = builder.name;
    this.paid = builder.paid;
    this.photo = builder.photo;
    this.initialCustomId = builder.initialCustomId;
    this.actualCustomId = builder.actualCustomId;
  }
  
  public CompanyDto(Company company) {
    super(company.getId(), company.getCreation(), company.isEnabled());
    this.document = company.getDocument();
    this.name = company.getName();
    this.paid = company.isPaid();
    this.photo = company.getPhoto();
    this.initialCustomId = company.getInitialCustomId();
    this.actualCustomId = company.getActualCustomId();
  }
  
  public String getDocument() {
    return document;
  }
  
  public String getName() {
    return name;
  }
  
  public boolean isPaid() {
    return paid;
  }
  
  public String getPhoto() {
    return photo;
  }
  
  public BigInteger getInitialCustomId() {
    return initialCustomId;
  }
  
  public BigInteger getActualCustomId() {
    return actualCustomId;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    CompanyDto that = (CompanyDto) o;
    
    if (paid != that.paid) return false;
    if (!document.equals(that.document)) return false;
    if (!name.equals(that.name)) return false;
    if (!Objects.equals(photo, that.photo)) return false;
    if (!Objects.equals(initialCustomId, that.initialCustomId)) return false;
    return Objects.equals(actualCustomId, that.actualCustomId);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + document.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + (paid ? 1 : 0);
    result = 31 * result + (photo != null ? photo.hashCode() : 0);
    result = 31 * result + (initialCustomId != null ? initialCustomId.hashCode() : 0);
    result = 31 * result + (actualCustomId != null ? actualCustomId.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return "Company{" +
      "document='" + document + '\'' +
      ", name='" + name + '\'' +
      ", paid=" + paid +
      ", photo='" + photo + '\'' +
      ", initialCustomId=" + initialCustomId +
      ", actualCustomId=" + actualCustomId +
      "} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(CompanyDto company) {
    return new Builder(company);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private String document;
    private String name;
    private boolean paid;
    private String photo;
    private BigInteger initialCustomId;
    private BigInteger actualCustomId;
    private LocalDateTime creation;
    private boolean enabled;
    
    private Builder() {
      super();
    }
    
    private Builder(CompanyDto company) {
      id(company.getId())
        .document(company.document)
        .name(company.name)
        .paid(company.paid)
        .photo(company.photo)
        .initialCustomId(company.initialCustomId)
        .actualCustomId(company.actualCustomId)
        .creation(company.getCreation())
        .enabled(company.isEnabled());
    }
    
    public Builder id(BigInteger id) {
      this.id = id;
      return this;
    }
    
    public Builder document(String document) {
      this.document = document;
      return this;
    }
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder paid(boolean paid) {
      this.paid = paid;
      return this;
    }
    
    public Builder photo(String photo) {
      this.photo = photo;
      return this;
    }
    
    public Builder initialCustomId(BigInteger initialCustomId) {
      this.initialCustomId = initialCustomId;
      return this;
    }
    
    public Builder actualCustomId(BigInteger actualCustomId) {
      this.actualCustomId = actualCustomId;
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
    
    public CompanyDto build() {
      return new CompanyDto(this);
    }
  }
}