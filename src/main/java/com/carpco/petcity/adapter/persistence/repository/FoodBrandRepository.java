package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.FoodBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FoodBrandRepository extends JpaRepository<FoodBrandEntity, BigInteger> {
}
