package com.carpco.petcity.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import java.math.BigInteger;

@Entity(name = "clinichistory")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class ClinicHistoryEntity extends CommonDataWithCompany {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idpet")
    private PetEntity pet;

    @Column(name = "recordcustomid")
    private BigInteger recordCustomId;
}
