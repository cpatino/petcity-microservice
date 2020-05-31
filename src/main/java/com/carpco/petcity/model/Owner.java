package com.carpco.petcity.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "owner")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class Owner extends CommonDataWithNameAndCompany {
  
  @NaturalId
  @NotBlank(message = "El número de documento es obligatorio")
  private String document;
  @Column(name = "lastname")
  @NotBlank(message = "El apellido es obligatorio")
  private String lastName;
  private String email;
  @NotBlank(message = "La dirección es obligatorio")
  private String address;
  @NotBlank(message = "El número de celular es obligatorio")
  private String phone;
  private String phone2;
  
  //For hibernate
  public Owner() {
    super();
  }
  
  protected Owner(Builder builder) {
    super(builder.id, builder.creation, builder.enabled, builder.name, builder.company);
    document = builder.document;
    lastName = builder.lastName;
    email = builder.email;
    address = builder.address;
    phone = builder.phone;
    phone2 = builder.phone2;
  }
  
  public String getDocument() {
    return document;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public String getAddress() {
    return address;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public String getPhone2() {
    return phone2;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    Owner owner = (Owner) o;
    
    if (!document.equals(owner.document)) return false;
    if (!lastName.equals(owner.lastName)) return false;
    if (!Objects.equals(email, owner.email)) return false;
    if (!address.equals(owner.address)) return false;
    if (!phone.equals(owner.phone)) return false;
    return Objects.equals(phone2, owner.phone2);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + document.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + address.hashCode();
    result = 31 * result + phone.hashCode();
    result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return "Owner{" +
      "document='" + document + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", address='" + address + '\'' +
      ", phone='" + phone + '\'' +
      ", phone2='" + phone2 + '\'' +
      "} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(Owner owner) {
    return new Builder(owner);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private LocalDateTime creation;
    private boolean enabled;
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String phone2;
    private Company company;
    
    private Builder() {
      super();
    }
    
    private Builder(Owner owner) {
      id(owner.getId()).creation(owner.getCreation()).enabled(owner.isEnabled()).document(owner.getDocument())
        .name(owner.getName()).lastName(owner.getLastName()).email(owner.getEmail())
        .address(owner.getAddress()).phone(owner.getPhone()).phone2(owner.getPhone2())
        .company(owner.getCompany());
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
    
    public Builder document(String document) {
      this.document = document;
      return this;
    }
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }
    
    public Builder email(String email) {
      this.email = email;
      return this;
    }
    
    public Builder address(String address) {
      this.address = address;
      return this;
    }
    
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }
    
    public Builder phone2(String phone2) {
      this.phone2 = phone2;
      return this;
    }
    
    public Builder company(Company company) {
      this.company = company;
      return this;
    }
    
    public Owner build() {
      return new Owner(this);
    }
  }
}