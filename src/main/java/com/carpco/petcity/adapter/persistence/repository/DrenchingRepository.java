package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.DrenchingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DrenchingRepository extends JpaRepository<DrenchingEntity, BigInteger> {
}
