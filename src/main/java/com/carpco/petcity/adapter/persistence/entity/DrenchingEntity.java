package com.carpco.petcity.adapter.persistence.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

@Entity(name = "drenching")
@Where(clause = "enabled = true")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@ToString
public class DrenchingEntity extends CommonDataWithNameAndCompany {
}
