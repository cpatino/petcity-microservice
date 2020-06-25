package com.carpco.petcity.repository.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.CascadeType.PERSIST;
import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "user")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class User extends CommonData {
  
  @NaturalId
  private String document;
  private String name;
  @Column(name = "lastname")
  private String lastName;
  private String phone;
  private String email;
  private String password;
  @ManyToOne(cascade = PERSIST)
  @JoinColumn(name = "idcompany")
  private Company company;
  
  public User() {
    super();
  }
  
  protected User(Builder builder) {
    super(builder.id, builder.creation, builder.enabled);
    this.document = builder.document;
    this.name = builder.name;
    this.lastName = builder.lastName;
    this.phone = builder.phone;
    this.email = builder.email;
    this.password = builder.password;
    this.company = builder.company;
  }
  
  public String getDocument() {
    return document;
  }
  
  public String getName() {
    return name;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public String getEmail() {
    return email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public Company getCompany() {
    return company;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    User user = (User) o;
    
    if (!document.equals(user.document)) return false;
    if (!name.equals(user.name)) return false;
    if (!lastName.equals(user.lastName)) return false;
    if (!phone.equals(user.phone)) return false;
    if (!Objects.equals(email, user.email)) return false;
    if (!Objects.equals(password, user.password)) return false;
    return company.equals(user.company);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + document.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + phone.hashCode();
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + company.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "User{" +
      "document='" + document + '\'' +
      ", name='" + name + '\'' +
      ", lastName='" + lastName + '\'' +
      ", phone='" + phone + '\'' +
      ", email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", company=" + company +
      "} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(User user) {
    return new Builder(user);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private String document;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Company company;
    private LocalDateTime creation;
    private boolean enabled;
    
    private Builder() {
      super();
    }
    
    private Builder(User user) {
      id(user.getId())
        .document(user.document)
        .name(user.name)
        .lastName(user.lastName)
        .phone(user.phone)
        .email(user.email)
        .password(user.password)
        .company(user.company)
        .creation(user.getCreation())
        .enabled(user.isEnabled());
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
    
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }
    
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }
    
    public Builder email(String email) {
      this.email = email;
      return this;
    }
    
    public Builder password(String password) {
      this.password = password;
      return this;
    }
    
    public Builder company(Company company) {
      this.company = company;
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
    
    public User build() {
      return new User(this);
    }
  }
}