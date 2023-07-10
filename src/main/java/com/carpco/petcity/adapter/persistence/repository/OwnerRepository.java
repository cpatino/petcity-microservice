package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OwnerRepository extends JpaRepository<OwnerEntity, BigInteger> {
}
