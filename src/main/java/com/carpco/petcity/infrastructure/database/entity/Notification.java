package com.carpco.petcity.infrastructure.database.entity;

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

import static org.hibernate.annotations.OptimisticLockType.DIRTY;

@Entity(name = "notification")
@OptimisticLocking(type = DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class Notification extends CommonData {
  
  @Column(name = "title")
  @NotBlank(message = "El título es obligatorio")
  private String notificationTitle;
  @NotBlank(message = "El mensaje es obligatorio")
  private String message;
  @Column(name = "notificationdate")
  @NotNull(message = "La fecha es obligatoria")
  private LocalDateTime notificationDate;
  @ManyToOne
  @JoinColumn(name = "idpet")
  @NotNull(message = "La mascota es obligatoria")
  private Pet pet;
  
  //For hibernate
  public Notification() {
    super();
  }
  
  protected Notification(Builder builder) {
    super(builder.id, builder.creation, builder.enabled);
    notificationTitle = builder.notificationTitle;
    message = builder.message;
    notificationDate = builder.notificationDate;
    pet = builder.pet;
  }
  
  public String getNotificationTitle() {
    return notificationTitle;
  }
  
  public String getMessage() {
    return message;
  }
  
  public LocalDateTime getNotificationDate() {
    return notificationDate;
  }
  
  public Pet getPet() {
    return pet;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    
    Notification that = (Notification) o;
    
    if (!notificationTitle.equals(that.notificationTitle)) return false;
    if (!message.equals(that.message)) return false;
    if (!notificationDate.equals(that.notificationDate)) return false;
    return pet.equals(that.pet);
  }
  
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + notificationTitle.hashCode();
    result = 31 * result + message.hashCode();
    result = 31 * result + notificationDate.hashCode();
    result = 31 * result + pet.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return "Notification{" +
      "notificationTitle='" + notificationTitle + '\'' +
      ", message='" + message + '\'' +
      ", notificationDate=" + notificationDate +
      ", pet=" + pet +
      "} " + super.toString();
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static Builder builder(Notification notification) {
    return new Builder(notification);
  }
  
  public static class Builder {
    
    public String getNotificationTitle() {
      return notificationTitle;
    }
    
    private BigInteger id;
    private LocalDateTime creation;
    private boolean enabled;
    private String notificationTitle;
    private String message;
    private LocalDateTime notificationDate;
    private Pet pet;
    
    private Builder() {
      super();
    }
    
    private Builder(Notification notification) {
      id(notification.getId()).creation(notification.getCreation()).enabled(notification.isEnabled())
        .title(notification.notificationTitle).message(notification.message)
        .notificationDate(notification.notificationDate).pet(notification.pet);
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
    
    public Builder title(String notificationTitle) {
      this.notificationTitle = notificationTitle;
      return this;
    }
    
    public Builder message(String message) {
      this.message = message;
      return this;
    }
    
    public Builder notificationDate(LocalDateTime notificationDate) {
      this.notificationDate = notificationDate;
      return this;
    }
    
    private Builder pet(Pet pet) {
      this.pet = pet;
      return this;
    }
    
    public Notification build() {
      return new Notification(this);
    }
  }
}