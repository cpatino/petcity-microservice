package com.carpco.petcity.data.repository;

import com.carpco.petcity.data.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, BigInteger> {
  
  Streamable<Vaccine> findAllByCompanyIdAndEnabled(BigInteger companyId, boolean enabled);
}
