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

import java.time.LocalTime;

@Entity(name = "pet")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class PetEntity extends CommonDataWithNameAndCompany {

    @NotBlank
    private String color;
    @NotBlank
    private String sex;
    @Column(name = "borndate")
    private LocalTime bornDate;
    @NotBlank
    @Column(name = "bornplace")
    private String bornPlace;
    private String photo;
    private String history;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idreproduction")
    private ReproductionEntity reproduction;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idpettype")
    private PetTypeEntity petType;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idbreed")
    private BreedEntity breed;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idowner")
    private OwnerEntity owner;
    private byte[] photoBlob;
}
