package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.PetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PetTypeRepository extends JpaRepository<PetTypeEntity, BigInteger> {
}
