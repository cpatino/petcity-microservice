package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.ClinicHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ClinicHistoryRepository extends JpaRepository<ClinicHistoryEntity, BigInteger> {
}
