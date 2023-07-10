package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PetRepository extends JpaRepository<PetEntity, BigInteger> {
}
