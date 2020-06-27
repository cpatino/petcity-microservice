package com.carpco.petcity.data.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "pet")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class Pet extends CommonDataWithNameAndCompany {
  
  @NotBlank(message = "El color de la mascota es obligatorio")
  private String color;
  @NotBlank(message = "El sexo de la mascota es obligatorio")
  private String sex;
  @Column(name = "borndate")
  private LocalTime bornDate;
  @Column(name = "bornplace")
  @NotBlank(message = "El lugar de procedencia de la mascota es obligatorio")
  private String bornPlace;
  private String photo;
  private String history;
  @ManyToOne
  @JoinColumn(name = "idreproduction")
  @NotNull(message = "El estado reproductivo de la mascota es obligatorio")
  private Reproduction reproduction;
  @ManyToOne
  @JoinColumn(name = "idpettype")
  @NotNull(message = "La especie es obligatoria")
  private PetType petType;
  @ManyToOne
  @JoinColumn(name = "idbreed")
  @NotNull(message = "La raza es obligatoria")
  private Breed breed;
  @ManyToOne
  @JoinColumn(name = "idowner")
  @NotNull(message = "El propietario es obligatorio")
  private Owner owner;
  private byte[] photoBlob;
  
  public Pet() {
    super();
  }
  
  protected Pet(Builder builder) {
    super(builder.id, builder.creation, builder.enabled, builder.name, builder.company);
    color = builder.color;
    sex = builder.sex;
    bornDate = builder.bornDate;
    bornPlace = builder.bornPlace;
    photo = builder.photo;
    history = builder.history;
    reproduction = builder.reproduction;
    petType = builder.petType;
    breed = builder.breed;
    owner = builder.owner;
    photoBlob = builder.photoBlob;
  }
  
  public String getColor() {
    return color;
  }
  
  public String getSex() {
    return sex;
  }
  
  public LocalTime getBornDate() {
    return bornDate;
  }
  
  public String getBornPlace() {
    return bornPlace;
  }
  
  public String getPhoto() {
    return photo;
  }
  
  public String getHistory() {
    return history;
  }
  
  public Reproduction getReproduction() {
    return reproduction;
  }
  
  public PetType getPetType() {
    return petType;
  }
  
  public Breed getBreed() {
    return breed;
  }
  
  public Owner getOwner() {
    return owner;
  }
  
  public byte[] getPhotoBlob() {
    return photoBlob;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    Pet pet = (Pet) o;
    
    if (!color.equals(pet.color)) return false;
    if (!sex.equals(pet.sex)) return false;
    if (!bornDate.equals(pet.bornDate)) return false;
    if (!bornPlace.equals(pet.bornPlace)) return false;
    if (!Objects.equals(photo, pet.photo)) return false;
    if (!Objects.equals(history, pet.history)) return false;
    if (!reproduction.equals(pet.reproduction)) return false;
    if (!petType.equals(pet.petType)) return false;
    if (!breed.equals(pet.breed)) return false;
    if (!owner.equals(pet.owner)) return false;
    return Arrays.equals(photoBlob, pet.photoBlob);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + color.hashCode();
    result = 31 * result + sex.hashCode();
    result = 31 * result + bornDate.hashCode();
    result = 31 * result + bornPlace.hashCode();
    result = 31 * result + (photo != null ? photo.hashCode() : 0);
    result = 31 * result + (history != null ? history.hashCode() : 0);
    result = 31 * result + reproduction.hashCode();
    result = 31 * result + petType.hashCode();
    result = 31 * result + breed.hashCode();
    result = 31 * result + owner.hashCode();
    result = 31 * result + Arrays.hashCode(photoBlob);
    return result;
  }
  
  @Override
  public String toString() {
    return "Pet{" +
      "color='" + color + '\'' +
      ", sex='" + sex + '\'' +
      ", bornDate=" + bornDate +
      ", bornPlace='" + bornPlace + '\'' +
      ", photo='" + photo + '\'' +
      ", history='" + history + '\'' +
      ", reproduction=" + reproduction +
      ", petType=" + petType +
      ", breed=" + breed +
      ", owner=" + owner +
      ", photoBlob=" + Arrays.toString(photoBlob) +
      "} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(Pet pet) {
    return new Builder(pet);
  }
  
  public static class Builder {
    
    private BigInteger id;
    private LocalDateTime creation;
    private boolean enabled;
    private String name;
    private String color;
    private String sex;
    private LocalTime bornDate;
    private String bornPlace;
    private String photo;
    private String history;
    private Reproduction reproduction;
    private PetType petType;
    private Breed breed;
    private Owner owner;
    private byte[] photoBlob;
    private Company company;
    
    private Builder() {
      super();
    }
    
    private Builder(Pet pet) {
      id(pet.getId()).creation(pet.getCreation()).enabled(pet.isEnabled()).name(pet.getName())
        .color(pet.getColor()).sex(pet.getSex()).bornDate(pet.getBornDate()).bornPlace(pet.getBornPlace())
        .photo(pet.getPhoto()).history(pet.getHistory()).reproduction(pet.getReproduction())
        .petType(pet.getPetType()).breed(pet.getBreed()).owner(pet.getOwner()).photoBlob(pet.getPhotoBlob())
        .company(pet.getCompany());
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
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder color(String color) {
      this.color = color;
      return this;
    }
    
    public Builder sex(String sex) {
      this.sex = sex;
      return this;
    }
    
    public Builder bornDate(LocalTime bornDate) {
      this.bornDate = bornDate;
      return this;
    }
    
    public Builder bornPlace(String bornPlace) {
      this.bornPlace = bornPlace;
      return this;
    }
    
    public Builder photo(String photo) {
      this.photo = photo;
      return this;
    }
    
    public Builder history(String history) {
      this.history = history;
      return this;
    }
    
    public Builder reproduction(Reproduction reproduction) {
      this.reproduction = reproduction;
      return this;
    }
    
    public Builder petType(PetType petType) {
      this.petType = petType;
      return this;
    }
    
    public Builder breed(Breed breed) {
      this.breed = breed;
      return this;
    }
    
    public Builder owner(Owner owner) {
      this.owner = owner;
      return this;
    }
    
    public Builder company(Company company) {
      this.company = company;
      return this;
    }
    
    public Builder photoBlob(byte[] photoBlob) {
      this.photoBlob = photoBlob;
      return this;
    }
    
    public Pet build() {
      return new Pet(this);
    }
  }
}