package com.carpco.petcity.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity(name = "notification")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class NotificationEntity extends CommonData {

    @NotBlank
    @Column(name = "title")
    private String notificationTitle;
    @NotBlank
    private String message;
    @NotNull
    @Column(name = "notificationdate")
    private LocalDateTime notificationDate;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idpet")
    private PetEntity pet;
}
