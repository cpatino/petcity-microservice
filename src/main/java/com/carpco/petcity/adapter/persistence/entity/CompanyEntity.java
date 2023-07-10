package com.carpco.petcity.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Where;

import java.math.BigInteger;

@Entity(name = "company")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class CompanyEntity extends CommonData {

    @NotBlank
    @NaturalId
    private String document;
    @NotBlank
    private String name;
    private boolean paid;
    private String photo;
    @Column(name = "initialcustomid")
    private BigInteger initialCustomId;
    @Column(name = "actualcustomid")
    private BigInteger actualCustomId;
}
