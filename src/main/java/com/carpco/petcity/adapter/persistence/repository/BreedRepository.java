package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.BreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BreedRepository extends JpaRepository<BreedEntity, BigInteger> {
}
