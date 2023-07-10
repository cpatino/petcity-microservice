package com.carpco.petcity.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Where;

@Entity(name = "app_user")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class UserEntity extends CommonData {

    @NotBlank
    @NaturalId
    private String document;
    @NotBlank
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idcompany")
    private CompanyEntity company;
}
