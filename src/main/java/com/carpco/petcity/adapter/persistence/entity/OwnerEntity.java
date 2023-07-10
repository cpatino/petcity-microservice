package com.carpco.petcity.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Where;

@Entity(name = "owner")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class OwnerEntity extends CommonDataWithNameAndCompany {

    @NotBlank
    @NaturalId
    private String document;
    @NotBlank
    @Column(name = "lastname")
    private String lastName;
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    private String phone2;
}
