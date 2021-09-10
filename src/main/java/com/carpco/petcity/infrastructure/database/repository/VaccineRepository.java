package com.carpco.petcity.infrastructure.database.repository;

import com.carpco.petcity.infrastructure.database.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, BigInteger> {
  
  Streamable<Vaccine> findAllByCompanyIdAndEnabled(BigInteger companyId, boolean enabled);
  
  Vaccine findByCompanyIdAndNameAndEnabled(BigInteger companyId, String name, boolean enabled);
}
