package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.ReproductionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ReproductionRepository extends JpaRepository<ReproductionEntity, BigInteger> {
}
