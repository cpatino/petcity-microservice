package com.carpco.petcity.adapter.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

@Entity(name = "breed")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class BreedEntity extends CommonDataWithNameAndCompany {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idpettype")
    private PetTypeEntity petType;
}
