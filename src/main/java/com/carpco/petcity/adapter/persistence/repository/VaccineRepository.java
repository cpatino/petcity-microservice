package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.VaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.math.BigInteger;
import java.util.Optional;

public interface VaccineRepository extends JpaRepository<VaccineEntity, BigInteger> {

    Streamable<VaccineEntity> findAllByCompanyId(BigInteger companyId);

    Optional<VaccineEntity> findByCompanyIdAndName(BigInteger companyId, String name);
}
