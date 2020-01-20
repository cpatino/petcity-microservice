package com.carpco.petcity.dto;

import com.carpco.petcity.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserDto extends CommonDataDto {
  
  @NotBlank private String document;
  @NotBlank private String name;
  @NotBlank private String lastName;
  @NotBlank private String phone;
  @NotBlank private String email;
  @NotBlank private String password;
  @NotNull private CompanyDto company;
  
  public UserDto() {
    super();
  }
  
  public UserDto(Builder builder) {
    super(builder.id, builder.creation, builder.enabled);
    this.document = builder.document;
    this.name = builder.name;
    this.lastName = builder.lastName;
    this.phone = builder.phone;
    this.email = builder.email;
    this.password = builder.password;
    this.company = builder.company;
  }
  
  public UserDto(User user) {
    super(user.getId(), user.getCreation(), user.isEnabled());
    this.document = user.getDocument();
    this.name = user.getName();
    this.lastName = user.getLastName();
    this.phone = user.getPhone();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.company = new CompanyDto(user.getCompany());
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
  
  public CompanyDto getCompany() {
    return company;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    UserDto userDto = (UserDto) o;
    
    if (!document.equals(userDto.document)) return false;
    if (!name.equals(userDto.name)) return false;
    if (!lastName.equals(userDto.lastName)) return false;
    if (!phone.equals(userDto.phone)) return false;
    if (!Objects.equals(email, userDto.email)) return false;
    if (!Objects.equals(password, userDto.password)) return false;
    return company.equals(userDto.company);
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
  
  public static Builder builder(UserDto userDto) {
    return new Builder(userDto);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private String document;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private CompanyDto company;
    private LocalDateTime creation;
    private boolean enabled;
    
    private Builder() {
      super();
    }
    
    private Builder(UserDto userDto) {
      id(userDto.getId())
        .document(userDto.document)
        .name(userDto.name)
        .lastName(userDto.lastName)
        .phone(userDto.phone)
        .email(userDto.email)
        .password(userDto.password)
        .company(userDto.company)
        .creation(userDto.getCreation())
        .enabled(userDto.isEnabled());
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
    
    public Builder company(CompanyDto company) {
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
    
    public UserDto build() {
      return new UserDto(this);
    }
  }
}